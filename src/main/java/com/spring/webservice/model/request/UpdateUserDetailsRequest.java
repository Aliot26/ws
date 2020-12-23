package com.spring.webservice.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 *Created by olga on 23.12.2020
 */
public class UpdateUserDetailsRequest {
    @NotNull(message = "firstName can't be null")
    @Size(min = 2, message = "FirstName must be equal or more than 2 characters")
    private String firstName;

    @NotNull(message = "lastName can't be null")
    @Size(min = 2, message = "LastName must be equal or more than 2 characters")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
