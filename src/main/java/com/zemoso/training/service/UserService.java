package com.zemoso.training.service;

import com.zemoso.training.entity.User;

import java.util.List;

public interface UserService {
//    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    //Method to create new user.
    public User createNewUser(User user);

    //Method to return list of all the users.
    public List<User> getAllUsers();

    //Method to return specific user.
    public User findUserByUserName(String username);

    //Method to update an user.
    public User updateUser(User user);

//    //Method to find all user highlights
//    public List<Highlight> findAllUserHighlights(UUID userId);
//
//    //Method to create new user highlight
//    public Highlight createHighlightByUserId(UUID userId, Highlight highlight);
}
