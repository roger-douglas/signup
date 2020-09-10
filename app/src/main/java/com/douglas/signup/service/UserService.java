package com.douglas.signup.service;

import com.douglas.signup.model.User;
import com.douglas.signup.service.exception.InvalidUserException;

public class UserService {

    public User registerUser(String firstName, String lastName, String password)
            throws InvalidUserException {
        final User user = new User(firstName, lastName, password);
        validate(user);
        return user;
    }

    private void validate(User user) throws InvalidUserException {
        if (user.getFirstName().isEmpty()) {
            throw new InvalidUserException("First name field is empty.");
        }

        if (user.getLastName().isEmpty()) {
            throw new InvalidUserException("Last name field is empty.");
        }

        if (user.getPassword().isEmpty()) {
            throw new InvalidUserException("Password field is empty.");
        }
    }
}
