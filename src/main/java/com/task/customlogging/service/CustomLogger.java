package com.task.customlogging.service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.customlogging.entity.LogCapture;
import com.task.customlogging.exception.UserDefinedException;
import com.task.customlogging.interfaces.ICustomLogger;
import com.task.customlogging.repo.LogCaptureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger implements ICustomLogger {

    @Autowired
    LogCaptureRepository logCaptureRepository;

    @Override
    public void generateProcess(String[] args) {
        ObjectMapper Obj = new ObjectMapper();

        try (FileWriter fWriter = new FileWriter("./" + args[0])) {
            if (args.length > 0) {
                System.out.println(args[0]);
                LogCounter cnt = new LogCounter();
                while (cnt.isAlive()) {
                    Date date = new Date();
                    LogCapture logId = logCaptureRepository
                            .save(new LogCapture("STARTED", new Timestamp(date.getTime())));
                    System.out.println("Start thread " + Obj.writeValueAsString(logId));
                    fWriter.write(Obj.writeValueAsString(logId) + "\n");

                    Thread.sleep(1500);

                    Optional<LogCapture> loggUpdate = logCaptureRepository.findById(logId.getId());
                    LogCapture logId1 = new LogCapture();
                    if (!loggUpdate.isPresent()) {
                        throw new UserDefinedException("LogId Not Found");
                    } else {
                        logId1.setId(loggUpdate.get().getId());
                        logId1.setState("FINISHED");
                        logId1.setTimestamp(new Timestamp(date.getTime()));

                        LogCapture logCapture = logCaptureRepository.save(logId1);
                        System.out.println("Ended thread " + Obj.writeValueAsString(logCapture));
                        fWriter.write(Obj.writeValueAsString(logCapture) + "\n");
                    }

                }

                System.out.println("Main thread's run is over");
            } else {
                System.out.println("Please Enter fileName as Argument Input");
            }
            fWriter.close();
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        } catch (UserDefinedException e) {
            throw e;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
