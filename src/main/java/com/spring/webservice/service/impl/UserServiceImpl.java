package com.spring.webservice.service.impl;

import com.spring.webservice.model.request.UpdateUserDetailsRequest;
import com.spring.webservice.model.request.UserDetailsRequest;
import com.spring.webservice.model.response.UserRest;
import com.spring.webservice.service.UserService;
import com.spring.webservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public UserRest getUser(String userId) {
        if(users.containsKey(userId)){
            return users.get(userId);
        }
        return null;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequest userDetails) {
        UserRest storedUser = users.get(userId);
        storedUser.setFirstName(userDetails.getFirstName());
        storedUser.setLastName(userDetails.getLastName());
        users.put(userId, storedUser);
        return storedUser;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}
