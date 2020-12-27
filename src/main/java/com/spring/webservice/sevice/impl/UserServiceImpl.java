package com.spring.webservice.sevice.impl;

import com.spring.webservice.model.request.UserDetailsRequest;
import com.spring.webservice.model.response.UserRest;
import com.spring.webservice.sevice.UserService;
import com.spring.webservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 *Created by olga on 27.12.2020
 */
@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetails) {
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        user.setUserId(userId);
        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, user);
        return user;
    }
}
