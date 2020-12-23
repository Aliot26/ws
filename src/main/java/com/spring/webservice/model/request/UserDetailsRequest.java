package com.spring.webservice.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 *Created by olga on 23.12.2020
 */
public class UserDetailsRequest {
    @NotNull(message = "firstName can't be null")
    private String firstName;

    @NotNull(message = "lastName can't be null")
    private String lastName;

    @NotNull(message = "email can't be null")
    @Email
    private String email;

    @NotNull(message = "firstName can't be null")
    @Size(min = 3, max = 5, message = "Password must be equal or more than 3 or less than 5")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
