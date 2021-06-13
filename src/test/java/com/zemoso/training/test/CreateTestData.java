package com.zemoso.training.test;

import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.entity.User;

public class CreateTestData {

    public Category createNewCategory(String categoryName, String description){
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setDescription(description);

        return category;
    }

    public Language addNewLanguage(String languageCode, String languageName, boolean isActive){
        Language language = new Language();
        language.setLanguageCode(languageCode);
        language.setLanguageName(languageName);
        language.setActive(isActive);

        return language;
    }

    public Book createNewBook(Category category, Language language, String bookTitle, boolean isActive, String author, int numberOfReads, int totalReadTime){
        var book = new Book();

        book.setCategory(category);
        book.setLanguage(language);
        book.setBookTitle(bookTitle);
        book.setActive(isActive);
        book.setAuthor(author);
        book.setNumberOfReads(numberOfReads);
        book.setTotalReadTime(totalReadTime);

        return book;
    }

    public User createNewUserData(String username, String name, String email, long phone, boolean isActive, boolean isAdmin){
        User user = new User();

        user.setUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAdmin(isAdmin);
        user.setActive(isActive);
        user.setPassword("33af75d2-b042-43e8-b772-84bb2fdd5b2c");

        return user;
    }
}
