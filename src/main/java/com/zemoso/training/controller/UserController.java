package com.zemoso.training.controller;

import com.zemoso.training.dto.BookDto;
import com.zemoso.training.dto.UserDto;
import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.User;
import com.zemoso.training.service.UserService;
import com.zemoso.training.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/user-service")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, ModelMapper modelMapper){
        this.userService = userServiceImpl;
        this.modelMapper = modelMapper;
    }

    @PutMapping("/users")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<UserDto>(modelMapper.map(updatedUser, UserDto.class), HttpStatus.OK);
    }
    
    @GetMapping("/users/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username){
        User user = userService.findUserByUserName(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users/{user-id}/user-libraries")
    public ResponseEntity<String> addNewBookToUserLibrary(@PathVariable UUID userId, @RequestBody BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);

        return null;
    }
}
