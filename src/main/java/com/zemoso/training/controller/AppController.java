package com.zemoso.training.controller;

import com.zemoso.training.dto.UserDto;
import com.zemoso.training.entity.User;
import com.zemoso.training.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AppController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppController(UserService userService, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        var user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createNewUser(user);
        return new ResponseEntity<>("User is created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserDto userDto){
        // Code to create new user session.
        return new ResponseEntity<>("User is authenticated successfully.", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> userLogout(@RequestBody UserDto userDto){
        // Code to remove user from session.
        return new ResponseEntity<>("User is logged out successfully.", HttpStatus.OK);
    }

}
