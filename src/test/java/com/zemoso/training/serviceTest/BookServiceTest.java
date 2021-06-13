package com.zemoso.training.serviceTest;

import com.zemoso.training.entity.Blink;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    LibraryService libraryService;


    CreateTestData createTestData = new CreateTestData();

    public Book createNewBook(){

        Category category = libraryService.addNewCategory(createTestData.createNewCategory());
        Language language = libraryService.addNewLanguage(createTestData.addNewLanguage());

        var book = new Book();

        book.setCategory(category);
        book.setLanguage(language);
        book.setBookTitle("Test Book");
        book.setActive(true);
        book.setAuthor("Test Author");
        book.setNumberOfReads(0);
        book.setTotalReadTime(14);

        return book;
    }

    @Test
    void saveBookTest() {

        Book book = createNewBook();
        var addedBook = bookService.saveBook(book);

        Assertions.assertNotNull(addedBook);

    }

    @Test
    void updateBookTest() {
        Book book = createNewBook();

        var addedBook = bookService.saveBook(book);

        var book1 = bookService.getBookByBookId(addedBook);

        book = book1.orElse(null);

        if(book != null)
            book.setBookTitle("updated Title");

        var updatedBook = bookService.updateBook(book);

        Assertions.assertEquals("updated Title", updatedBook.getBookTitle());

    }

    @Test
    public List<Book> getBooksByCategory(UUID categoryId) {
//        return bookRepository.findAllBooksByCategory(categoryId);
        return null;
    }

    @Test
    public List<Blink> getBlinksByBookId(UUID bookId) {
        return new ArrayList<>();
    }

//    @Test
//    public UUID addBlinkByBookId(UUID bookId, Blink blink) {
//        Blink blink1 = blinkRepository.save(blink);
//        return blink1.getBlinkId();
//    }
//
////    @Override
////    public List<Blink> getAllBlinksByBookId(UUID bookId) {
////        //TODO : find blinks by bookId
////        return blinkRepository.findAllBlinksByBooksId(bookId);
////    }
//
//    @Test
//    public Optional<Book> getBookByBookId(UUID bookId) {
//        return bookRepository.findById(bookId);
//    }
//
//    @Test
//    public void deleteBookByBookId(UUID bookId) {
//        bookRepository.deleteById(bookId);
//    }
//
////    @Override
////    public void deleteBlinksByBookId(UUID bookId) {
////        blinkRepository.deleteAllBlinksByBookId(bookId);
////    }
//
//    @Test
//    public List<Book> getPopularBooks(int popularBooks) {
//        return bookRepository.findPopularBooks(popularBooks);
//    }
//
//    @Test
//    public List<Book> getRecentlyAddedBooks(int recentBooks) {
//        return bookRepository.findRecentlyAddedBooks(recentBooks);
//    }
}
