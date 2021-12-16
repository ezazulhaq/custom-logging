package com.task.customlogging.repo;

import com.task.customlogging.entity.LogCapture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCaptureRepository extends JpaRepository<LogCapture, Integer> {

}
