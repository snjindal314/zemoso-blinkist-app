package com.zemoso.training.controller;

import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/library-service")
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/user-libraries")
    public ResponseEntity<UserLibrary> addNewUserBook(@RequestBody UserLibrary userLibrary){
        return new ResponseEntity<>(userLibrary, HttpStatus.OK);
    }
}
