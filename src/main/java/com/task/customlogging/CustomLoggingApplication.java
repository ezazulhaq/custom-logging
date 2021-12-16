package com.task.customlogging;

import com.task.customlogging.interfaces.ICustomLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomLoggingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CustomLoggingApplication.class, args);

		ICustomLogger custom = context.getBean(ICustomLogger.class);
		custom.generateProcess(args);

	}

}
