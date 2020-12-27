package com.spring.webservice.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

/*
 *Created by olga on 27.12.2020
 */
@Service
public class Utils {
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
