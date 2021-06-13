package com.zemoso.training.serviceTest;

import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.Category;
import com.zemoso.training.entity.Language;
import com.zemoso.training.service.BookService;
import com.zemoso.training.service.LibraryService;
import com.zemoso.training.test.CreateTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    LibraryService libraryService;


    CreateTestData createTestData = new CreateTestData();

    @Test
    void saveBookTest() {
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("test category", "This is a test category"));
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));


        Book book = createTestData.createNewBook(category, language, "Space book", true, "Elon Musk", 200, 10);
        var addedBook = bookService.saveBook(book);

        Assertions.assertNotNull(addedBook);

    }

    @Test
    void updateBookTest() {

        Category category = libraryService.addNewCategory(createTestData.createNewCategory("test category new", "This is a new test category"));
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("uk-en", "UK English", true));

        Book book = createTestData.createNewBook(category, language, "Science book", true, "Newton", 200, 10);

        var addedBook = bookService.saveBook(book);

        var book1 = bookService.getBookByBookId(addedBook);

        book = book1.orElse(null);

        if(book != null)
            book.setBookTitle("updated Title");

        var updatedBook = bookService.updateBook(book);

        Assertions.assertEquals("updated Title", updatedBook.getBookTitle());

    }

    @Test
    void getBooksByCategory() {
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("Science", "This is a science category"));
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));


        var book = createTestData.createNewBook(category, language, "Space book", true, "Elon Musk", 200, 10);
        var addedBook = bookService.saveBook(book);

        category = libraryService.addNewCategory(createTestData.createNewCategory("space", "This is a space category"));

        book = createTestData.createNewBook(category, language, "science book", true, "Einstein", 200, 10);
        bookService.saveBook(book);

        List<Book> bookList = bookService.getBooksByCategory(category.getCategoryId());

        Assertions.assertEquals(1, bookList.size());
        Assertions.assertEquals(category.getCategoryId(), bookList.get(0).getCategory().getCategoryId());
    }

    @Test
    void addBlinkByBookIdTest(){

    }

    @Test
    void getAllBlinksByBookId(){

    }

    @Test
    void getBookByBookIdTest(){

    }


    @Test
    void deleteAllBlinksByBookIdTest(){

    }

    @Test
    void getPopularBooksTest(){
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("Science", "This is a science category"));
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));


        var book = createTestData.createNewBook(category, language, "Space book", true, "Elon Musk", 100, 10);
        var addedBook = bookService.saveBook(book);

        category = libraryService.addNewCategory(createTestData.createNewCategory("space", "This is a space category"));

        book = createTestData.createNewBook(category, language, "science book", true, "Einstein", 200, 10);
        bookService.saveBook(book);

        List<Book> bookList = bookService.getPopularBooks(199);

        Assertions.assertEquals(1, bookList.size());
    }

    @Test
    void getRecentlyAddedBooksTest(){
        Category category = libraryService.addNewCategory(createTestData.createNewCategory("Science", "This is a science category"));
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage("us-en", "us English", true));


        var book = createTestData.createNewBook(category, language, "Space book", true, "Elon Musk", 100, 10);
        var addedBook = bookService.saveBook(book);

        category = libraryService.addNewCategory(createTestData.createNewCategory("space", "This is a space category"));

        book = createTestData.createNewBook(category, language, "science book", true, "Einstein", 200, 10);
        bookService.saveBook(book);

        List<Book> bookList = bookService.getRecentlyAddedBooks(10);

        Assertions.assertEquals(2, bookList.size(), 8);
    }

    @Test
    void deleteBlinkbyBlinkIdTest(){

    }
}
