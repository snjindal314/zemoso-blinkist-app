package com.zemoso.training.controller;

import com.zemoso.training.dto.CategoryDto;
import com.zemoso.training.dto.LanguageDto;
import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.service.LibraryService;
import org.modelmapper.ModelMapper;
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

    private ModelMapper modelMapper;

    @Autowired
    public LibraryController(LibraryService libraryService, ModelMapper modelMapper) {
        this.libraryService = libraryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/user-libraries")
    public ResponseEntity<UserLibrary> addNewUserBook(@RequestBody UserLibrary userLibrary){
        return new ResponseEntity<>(userLibrary, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> addNewCategory(@RequestBody CategoryDto categoryDto){
        var category = modelMapper.map(categoryDto, Category.class);
        categoryDto = modelMapper.map(libraryService.addNewCategory(category), CategoryDto.class);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @PostMapping("/languages")
    public ResponseEntity<LanguageDto> addNewLanguage(@RequestBody LanguageDto languageDto){
        var language = modelMapper.map(languageDto, Language.class);
        languageDto = modelMapper.map(libraryService.addNewLanguage(language), LanguageDto.class);
        return new ResponseEntity<>(languageDto, HttpStatus.OK);
    }
}
