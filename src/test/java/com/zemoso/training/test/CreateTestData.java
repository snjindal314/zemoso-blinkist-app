package com.zemoso.training.test;

import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;

public class CreateTestData {

    public Category createNewCategory(){
        Category category = new Category();
        category.setCategoryName("testCategory");
        category.setDescription("This is a test category");

        return category;
    }

    public Language addNewLanguage(){
        Language language = new Language();
        language.setLanguageCode("testCode");
        language.setLanguageName("testLanguage");
        language.setActive(true);

        return language;
    }
}
