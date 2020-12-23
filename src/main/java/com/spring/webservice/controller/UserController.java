package com.spring.webservice.controller;

import com.spring.webservice.model.UserRest;
import com.spring.webservice.model.request.UserDetailsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest user = new UserRest();
        user.setFirstName("Ivan");
        user.setLastName("Petroff");
        user.setEmail("test@test.com");

        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {

        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());


        System.out.println(user);
        System.out.println(user.getEmail());
        System.out.println(user.getUserId());
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }
}
