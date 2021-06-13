package com.zemoso.training.service;

import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.entity.UserLibrary;
import org.springframework.stereotype.Service;

@Service
public interface LibraryService {

    Category addNewCategory(Category category);

    Language addNewLanguage(Language language);

    void addNewUserBook(UserLibrary userLibrary);
}
