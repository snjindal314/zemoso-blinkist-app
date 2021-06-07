package com.zemoso.training.controller;

import com.zemoso.training.dto.BlinkDto;
import com.zemoso.training.dto.BookDto;
import com.zemoso.training.entity.Blink;
import com.zemoso.training.entity.Book;
import com.zemoso.training.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


//TODO Response From controller: Data/Status/TimeStamp

//TODO Rest ExceptionHandler
@RestController
@RequestMapping("/api/v1/book-service")
public class BookController {


    private final BookService bookService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<String> addNewBook(@RequestBody BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        UUID bookId = bookService.saveBook(book);
        return new ResponseEntity(bookId, HttpStatus.OK);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    @PutMapping("/books")
    public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        UUID bookId = bookService.updateBook(book);
        return new ResponseEntity(bookId, HttpStatus.OK);
    }

    @DeleteMapping("/books/{book-id}")
    public int deleteBookByBookId(@PathVariable(value = "book-id") UUID bookId){
        bookService.deleteBookByBookId(bookId);
        return 1;
    }

    @GetMapping("/books/{book-id}")
    public ResponseEntity<Book> getBookByBookId(@PathVariable UUID bookId){
        Optional<Book> book = bookService.getBookByBookId(bookId);
        return new ResponseEntity(book, HttpStatus.OK);

    }

    @PostMapping("/books/{book-id}/blinks")
    public ResponseEntity addBlinksByBooksId(@PathVariable(value = "book-id") UUID bookId, @RequestBody BlinkDto blinkDto){
        Blink blink = modelMapper.map(blinkDto, Blink.class);
        blink.setBookId(bookId);
        UUID blinkId = bookService.addBlinkByBookId(bookId, blink);
        return new ResponseEntity(blinkId, HttpStatus.OK);
    }

    @GetMapping("/books/{book-id}/blinks")
    public List<Blink> findAllBlinksByBookId(@PathVariable(value = "book-id") UUID bookId){
        return bookService.getAllBlinksByBookId(bookId);
    }

    @DeleteMapping("/books/{book-id}/blinks")
    public ResponseEntity deleteBlinksByBookId(@PathVariable(value = "book-id") UUID bookId){
        bookService.deleteBlinksByBookId(bookId);
        return new ResponseEntity("All blinks have been deleted.", HttpStatus.OK);
    }
}
