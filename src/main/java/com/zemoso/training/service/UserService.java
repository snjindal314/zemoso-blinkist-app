package com.zemoso.training.service;

import com.zemoso.training.entity.User;
import com.zemoso.training.exception.ValidationException;

import java.util.List;

public interface UserService {
    //Method to create new user.
    User createNewUser(User user);

    //Method to return list of all the users.
    List<User> getAllUsers();

    //Method to return specific user.
    User findUserByUserName(String username);

    //Method to update an user.
    User updateUser(User user) throws ValidationException;

}
