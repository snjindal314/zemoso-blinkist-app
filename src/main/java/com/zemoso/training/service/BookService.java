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

     List<Blink> getBlinksByBookId(UUID bookId);

     UUID addBlinkByBookId(UUID bookId, Blink blink);

//     List<Blink> getAllBlinksByBookId(UUID bookId);

     Optional<Book> getBookByBookId(UUID bookId);

     void deleteBookByBookId(UUID bookId);

//     void deleteBlinksByBookId(UUID bookId);

     List<Book> getPopularBooks(int popularBooks);

     List<Book> getRecentlyAddedBooks(int recentlyAddedBooks);
 }
