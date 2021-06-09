package com.zemoso.training.repository;

import com.zemoso.training.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    @Modifying @Transactional
    @Query(value = "update Book b set b.isActive = false where b.bookId = :bookId")
    int disableBookByBookId(@Param("bookId") UUID bookId);

    @Query(value = "select b from Book b where b.numberOfReads > :numberOfReads")
    List<Book> findPopularBooks(@Param("numberOfReads") int numberOfReads);

    @Query(value = "select b from Book b where b.creationDate > current_date - :recentBooks order by b.creationDate desc")
    List<Book> findRecentlyAddedBooks(@Param("recentBooks") int recentBooks);

//    @Query(value = "select b from Book b where b.categoryId = :categoryId")
//    List<Book> findAllBooksByCategory(@Param("categoryId") UUID categoryId);
}
