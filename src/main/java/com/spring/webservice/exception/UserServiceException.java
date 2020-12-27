package com.spring.webservice.exception;

/*
 *Created by olga on 27.12.2020
 */
public class UserServiceException extends  RuntimeException {
    public static final long serialVersionUID = 1348L;
    public UserServiceException(String message){
        super(message);
    }
}
