package com.zemoso.training.controller;

import com.zemoso.training.dto.UserDto;
import com.zemoso.training.dto.UserLibraryDto;
import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.User;
import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.entity.UserLibraryId;
import com.zemoso.training.exception.ResourceNotFoundException;
import com.zemoso.training.exception.ValidationException;
import com.zemoso.training.service.LibraryService;
import com.zemoso.training.service.UserService;
import com.zemoso.training.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/user-service")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LibraryService libraryService;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, ModelMapper modelMapper, LibraryService libraryService){
        this.userService = userServiceImpl;
        this.modelMapper = modelMapper;
        this.libraryService = libraryService;
    }

    @PutMapping("/users")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) throws ValidationException {
        var user = modelMapper.map(userDto, User.class);
        var updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(modelMapper.map(updatedUser, UserDto.class), HttpStatus.OK);
    }
    
    @GetMapping("/users/{username}")
    public ResponseEntity<UserDto> findUserByUsername(@PathVariable String username){
        var user = userService.findUserByUserName(username);

        if(user == null){
            throw new ResourceNotFoundException("User " + username + " not found.");
        }
        return new ResponseEntity<>(modelMapper.map(user, UserDto.class), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        if(users.isEmpty()){
            throw new ResourceNotFoundException("No users found.");
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users/{user-id}/user-libraries")
    public ResponseEntity<String> addNewBookToUserLibrary(@PathVariable(name = "user-id") UUID userId, @RequestBody UserLibraryDto userLibraryDto){
        var userLibrary = new UserLibrary();

        User user = new User();
        Book book = new Book();

        user.setUserId(userLibraryDto.getUserId());
        book.setBookId(userLibraryDto.getBookId());

        UserLibraryId userLibraryId = new UserLibraryId();
        userLibraryId.setUser(user);
        userLibraryId.setBook(book);

        userLibrary.setUserLibraryId(userLibraryId);
        userLibrary.setFinished(false);
        userLibrary.setBlinkNumber(1);
        userLibrary.setStartDate(new Date());
        userLibrary.setFinishDate(null);

        libraryService.addNewUserBook(userLibrary);

        return new ResponseEntity<>("New user book has been added to user library.", HttpStatus.OK);
    }

    @GetMapping("/users/{user-id}/user-libraries")
    public ResponseEntity<List<UserLibrary>> getAllUserBooks(@PathVariable(name = "user-id") UUID userId){

        List<UserLibrary> userLibraryList = libraryService.getAllUserBooks(userId);

        return new ResponseEntity<>(userLibraryList, HttpStatus.OK);
    }

}
