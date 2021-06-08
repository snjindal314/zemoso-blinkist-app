package com.zemoso.training.service;

import com.zemoso.training.entity.User;
import com.zemoso.training.exception.ResourceNotFoundException;
import com.zemoso.training.exception.ValidationException;
import com.zemoso.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(User user) {
        if(user == null) {
            throw new ValidationException("User information is not provided.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new ResourceNotFoundException("No users found.");
        }
        return users;
    }

    @Override
    public User findUserByUserName(String username) {
        Optional<User> optionalUser = userRepository.findByUserName(username);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new ResourceNotFoundException(username + " not found.");
        }
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getUserId());

        User user1;
        if(existingUser.isPresent()){
            user1 = existingUser.get();
        }
        else {
            throw new ResourceNotFoundException(user.getUsername() + " User not found.");
        }

        user1.setUserId(user.getUserId());
        user1.setUserId(user.getUserId());
        user1.setActive(user.isActive());
        user1.setAdmin(user.isAdmin());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());

        return userRepository.save(user1);
    }
}
