package com.spring.webservice.controller;

import com.spring.webservice.model.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/*
 *Created by olga on 22.12.2020
 */
@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "20") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "return user form page " + page + " with limit " + limit + " sort " + sort;
    }

    @GetMapping(value = "/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String userId) {
        UserRest user = new UserRest();
        user.setFirstName("Ivan");
        user.setLastName("Petroff");
        user.setEmail("test@test.com");

        System.out.println(user);
        System.out.println(user.getEmail());
        System.out.println(user.getUserId());
        return user;
    }
}
