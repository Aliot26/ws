package com.spring.webservice.service;

import com.spring.webservice.model.request.UpdateUserDetailsRequest;
import com.spring.webservice.model.request.UserDetailsRequest;
import com.spring.webservice.model.response.UserRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/*
 *Created by olga on 27.12.2020
 */
public interface UserService {
    UserRest createUser(UserDetailsRequest userDetails);
    UserRest getUser(String userId);
    UserRest updateUser(String userId, UpdateUserDetailsRequest userDetails);
    void deleteUser(String userId);
}
