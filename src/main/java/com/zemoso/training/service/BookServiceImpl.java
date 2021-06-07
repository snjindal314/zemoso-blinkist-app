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
        Book addedBook = bookRepository.save(book);
        return addedBook.getBookId();
    }

    @Override
    public UUID updateBook(Book book) {
        Book updatedBook = bookRepository.save(book);
        return updatedBook.getBookId();
    }

    @Override
    public Book getBookByBookCategoryId(UUID CategoryId) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Blink> getBlinksByBookId(UUID bookId) {
        return null;
    }

    @Override
    public UUID addBlinkByBookId(UUID bookId, Blink blink) {
        Blink blink1 = blinkRepository.save(blink);
        return blink1.getBlinkId();
    }

    @Override
    public List<Blink> getAllBlinksByBookId(UUID bookId) {
        //TODO : find blinks by bookId
        return blinkRepository.findAllBlinksByBooksId(bookId);
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
    public void deleteBlinksByBookId(UUID bookId) {
        blinkRepository.deleteAllBlinksByBookId(bookId);
    }
}
