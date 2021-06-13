package com.zemoso.training.serviceTest;

import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.service.LibraryService;
import com.zemoso.training.test.CreateTestData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class LibraryServiceTest {

    @Autowired
    LibraryService libraryService;

    CreateTestData createTestData = new CreateTestData();

    @Test
    void addCategoryTest(){
        Category category = createTestData.createNewCategory();

        category = libraryService.addNewCategory(category);

        Assert.assertNotNull(category);
    }

    @Test
    void addNewLanguageTest(){
        Language language = createTestData.addNewLanguage();

        language = libraryService.addNewLanguage(language);

        Assert.assertNotNull(language);
    }
}
