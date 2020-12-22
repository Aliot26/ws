package com.spring.webservice.controller;

import org.springframework.web.bind.annotation.*;

/*
 *Created by olga on 22.12.2020
 */
@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page",  defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "20") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "return user form page " + page + " with limit " + limit + " sort " + sort;
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId) {
        return "return user by userId " + userId;
    }
}
