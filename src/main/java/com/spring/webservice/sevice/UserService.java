package com.spring.webservice.sevice;

import com.spring.webservice.model.request.UserDetailsRequest;
import com.spring.webservice.model.response.UserRest;

/*
 *Created by olga on 27.12.2020
 */
public interface UserService {
    UserRest createUser(UserDetailsRequest userDetails);
}
