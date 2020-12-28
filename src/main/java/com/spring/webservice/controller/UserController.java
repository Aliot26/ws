package com.spring.webservice.controller;

import com.spring.webservice.model.response.UserRest;
import com.spring.webservice.model.request.UpdateUserDetailsRequest;
import com.spring.webservice.model.request.UserDetailsRequest;
import com.spring.webservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/*
 *Created by olga on 22.12.2020
 */
@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

//        if(true){
//            throw new UserServiceException("UserServiceException is thrown");
//        }
        UserRest user = userService.getUser(userId);
        if ( user!= null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {

        UserRest user = userService.createUser(userDetails);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
                                               @Valid @RequestBody UpdateUserDetailsRequest userDetails) {

        UserRest storedUserDetails = userService.updateUser(userId, userDetails);

        return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
