package com.spring.webservice.model.response;

import java.util.Date;

/*
 *Created by olga on 23.12.2020
 */
public class ErrorMessage {
    private Date timestamp;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
