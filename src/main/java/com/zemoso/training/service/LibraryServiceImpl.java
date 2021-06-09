package com.zemoso.training.service;

import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.repository.CategoryRepository;
import com.zemoso.training.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    private CategoryRepository categoryRepository;
    private LanguageRepository languageRepository;

    @Autowired
    public LibraryServiceImpl(CategoryRepository categoryRepository, LanguageRepository languageRepository) {
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
    }

    public LibraryServiceImpl() {
    }

    @Override
    public Book saveUserBook(UserLibrary userLibrary) {
        return null;
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Language addNewLanguage(Language language) {
        return languageRepository.save(language);
    }
}
