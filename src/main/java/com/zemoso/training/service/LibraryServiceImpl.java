package com.zemoso.training.service;

import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.repository.CategoryRepository;
import com.zemoso.training.repository.LanguageRepository;
import com.zemoso.training.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    private CategoryRepository categoryRepository;
    private LanguageRepository languageRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(CategoryRepository categoryRepository, LanguageRepository languageRepository, LibraryRepository libraryRepository) {
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
        this.libraryRepository = libraryRepository;
    }

    public LibraryServiceImpl() {
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Language addNewLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void addNewUserBook(UserLibrary userLibrary) {
        libraryRepository.save(userLibrary);
    }
}
