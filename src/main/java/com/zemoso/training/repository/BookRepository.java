package com.zemoso.training.repository;

import com.zemoso.training.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    @Modifying @Transactional
    @Query(value = "update Book b set b.isActive = false where b.bookId = :bookId")
    int disableBookByBookId(@Param("bookId") UUID bookId);
}
