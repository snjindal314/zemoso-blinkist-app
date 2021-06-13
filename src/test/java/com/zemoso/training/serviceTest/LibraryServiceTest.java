package com.zemoso.training.serviceTest;

import com.zemoso.training.entity.*;
import com.zemoso.training.service.BookService;
import com.zemoso.training.service.LibraryService;
import com.zemoso.training.service.UserService;
import com.zemoso.training.test.CreateTestData;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class LibraryServiceTest {

    @Autowired
    LibraryService libraryService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    CreateTestData createTestData = new CreateTestData();

    @Test
    void addCategoryTest(){
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("test category", "This is a test category"));

        category = libraryService.addNewCategory(category);

        Assertions.assertNotNull(category);
    }

    @Test
    void addNewLanguageTest(){
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));

        language = libraryService.addNewLanguage(language);

        Assertions.assertNotNull(language);
    }

    @Test
    void addNewUserBookTest(){
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("test category", "This is a test category"));
        category = libraryService.addNewCategory(category);
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));
        language = libraryService.addNewLanguage(language);

        User user = userService.createNewUser(createTestData.createNewUserData("test123", "testuser", "test123@gmail.com", 98765433210L, true, true));

        Book book = createTestData.createNewBook(category, language, "Space book", true, "Elon Musk", 200, 10);
        var addedBook = bookService.saveBook(book);

        UserLibrary userLibrary = new UserLibrary();
        UserLibraryId userLibraryId = new UserLibraryId();

        userLibraryId.setUser(user);
        userLibraryId.setBook(book);

        userLibrary.setUserLibraryId(userLibraryId);
        userLibrary.setBlinkNumber(1);
        userLibrary.setFinished(false);
        userLibrary.setFinishDate(new Date());
        userLibrary.setFinishDate(null);

        libraryService.addNewUserBook(userLibrary);

        List<UserLibrary> userLibraryList = libraryService.getAllUserBooks(user.getUserId());

        Assertions.assertEquals(1, userLibraryList.size());

    }
}
