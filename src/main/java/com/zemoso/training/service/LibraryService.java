package com.zemoso.training.service;

import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.UserLibrary;
import org.springframework.stereotype.Service;

@Service
public interface LibraryService {

    //Method to save book to user library
    Book saveUserBook(UserLibrary userLibrary);
}
