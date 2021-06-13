package com.zemoso.training.service;

import com.zemoso.training.entity.Blink;
import com.zemoso.training.entity.Book;
import com.zemoso.training.repository.BlinkRepository;
import com.zemoso.training.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final BlinkRepository blinkRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BlinkRepository blinkRepository){
        this.bookRepository = bookRepository;
        this.blinkRepository = blinkRepository;
    }

    @Override
    public UUID saveBook(Book book) {
        var addedBook = bookRepository.save(book);
        return addedBook.getBookId();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByCategory(UUID categoryId) {
        return bookRepository.findBookByCategoryCategoryId(categoryId);
    }

    @Override
    public List<Blink> addBlinkByBookId(UUID bookId, List<Blink> blinkList) {
        return blinkRepository.saveAll(blinkList);
    }

    @Override
    public List<Blink> getAllBlinksByBookId(UUID bookId) {
        return blinkRepository.findBlinksByBookBookId(bookId);
    }

    @Override
    public Optional<Book> getBookByBookId(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public void deleteBookByBookId(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Blink> deleteAllBlinksByBookId(UUID bookId) {
       return blinkRepository.deleteBlinksByBookBookId(bookId);
    }

    @Override
    public List<Book> getPopularBooks(int popularBooks) {
        return bookRepository.findPopularBooks(popularBooks);
    }

    @Override
    public List<Book> getRecentlyAddedBooks(int recentBooks) {
        return bookRepository.findRecentlyAddedBooks(recentBooks);
    }

    @Override
    public void deleteBlinkbyBlinkId(UUID blinkId) {
        blinkRepository.deleteById(blinkId);
    }
}
