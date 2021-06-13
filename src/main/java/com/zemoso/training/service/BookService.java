package com.zemoso.training.service;

import com.zemoso.training.entity.Blink;
import com.zemoso.training.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


 public interface BookService {
     UUID saveBook(Book book);

     Book updateBook(Book book);

     List<Book> getBooksByCategory(UUID categoryId);

     List<Blink> addBlinkByBookId(UUID bookId, List<Blink> blinkList);

     List<Blink> getAllBlinksByBookId(UUID bookId);

     Optional<Book> getBookByBookId(UUID bookId);

     void deleteBookByBookId(UUID bookId);

     List<Blink> deleteAllBlinksByBookId(UUID bookId);

     List<Book> getPopularBooks(int popularBooks);

     List<Book> getRecentlyAddedBooks(int recentlyAddedBooks);

     void deleteBlinkbyBlinkId(UUID blinkId);
 }
