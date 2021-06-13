package com.zemoso.training.controller;

import com.zemoso.training.dto.BlinkDto;
import com.zemoso.training.dto.BookDto;
import com.zemoso.training.entity.Blink;
import com.zemoso.training.entity.Book;
import com.zemoso.training.entity.Category;
import com.zemoso.training.exception.ValidationException;
import com.zemoso.training.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/book-service")
public class BookController {

    @Value("${book.recentBooksDay}")
    private Integer recentlyAddedBooksDays;

    @Value("${book.popularNumberOfReads}")
    private Integer popularBooks;

    private final BookService bookService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<String> addNewBook(@RequestBody BookDto bookDto){
        var book = modelMapper.map(bookDto, Book.class);
        var category = modelMapper.map(bookDto.getCategoryDto(), Category.class);
        book.setCategory(category);
        book.getCategory().setCategoryId(bookDto.getCategoryDto().getCategoryId());
        book.getLanguage().setLanguageId(bookDto.getLanguageDto().getLanguageId());
//        book.getBlinkList().stream().forEach((blink) -> blink.setBook(bookDto.));
        UUID bookId = bookService.saveBook(book);
        return new ResponseEntity<>("New book has been added. Book Id: " +bookId, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam Map<String, String> params){
        List<Book> books;
        if(params.get("fetchPopularBooks") != null && Boolean.parseBoolean(params.get("fetchPopularBooks"))){
            books = bookService.getPopularBooks(popularBooks);
        }
        else if(params.get("fetchRecentlyAddedBooks") != null && Boolean.parseBoolean(params.get("fetchRecentlyAddedBooks"))){
            books = bookService.getRecentlyAddedBooks(recentlyAddedBooksDays);
        }
        else if(params.get("fetchBooksByCategoryId") != null){
            books = bookService.getBooksByCategory(UUID.fromString(params.get("fetchBooksByCategoryId")));
        }
        else
            throw new ValidationException("Please select type of books.");
        return new ResponseEntity<>(books.stream().map(book -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        var book = modelMapper.map(bookDto, Book.class);
        var updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(modelMapper.map(updateBook, BookDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/books/{book-id}")
    public int deleteBookByBookId(@PathVariable(value = "book-id") UUID bookId){
        bookService.deleteBookByBookId(bookId);
        return 1;
    }

    @GetMapping("/books/{book-id}")
    public ResponseEntity<BookDto> getBookByBookId(@PathVariable("book-id") UUID bookId){
        Optional<Book> book = bookService.getBookByBookId(bookId);
        return new ResponseEntity<>(modelMapper.map(book.get(), BookDto.class), HttpStatus.OK);

    }

    @PostMapping("/books/{book-id}/blinks")
    public ResponseEntity<String> addBlinksByBooksId(@PathVariable(value = "book-id") UUID bookId, @RequestBody BlinkDto blinkDto){
        var blink = modelMapper.map(blinkDto, Blink.class);
//        blink.setBookId(bookId);
        UUID blinkId = bookService.addBlinkByBookId(bookId, blink);
        return new ResponseEntity<>("New blink has been added. Blink Id: " + blinkId, HttpStatus.OK);
    }

//    @GetMapping("/books/{book-id}/blinks")
//    public List<Blink> findAllBlinksByBookId(@PathVariable(value = "book-id") UUID bookId){
//        return bookService.getAllBlinksByBookId(bookId);
//    }
//
//    @DeleteMapping("/books/{book-id}/blinks")
//    public ResponseEntity<String> deleteBlinksByBookId(@PathVariable(value = "book-id") UUID bookId){
//        bookService.deleteBlinksByBookId(bookId);
//        return new ResponseEntity<>("All blinks have been deleted.", HttpStatus.OK);
//    }
}
