package com.task.customlogging.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogCapture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String state;

    private Timestamp timestamp;

    public LogCapture() {
    }

    public LogCapture(String state, Timestamp timestamp) {
        this.state = state;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
