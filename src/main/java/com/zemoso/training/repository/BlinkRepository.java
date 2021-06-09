package com.zemoso.training.repository;

import com.zemoso.training.entity.Blink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlinkRepository extends JpaRepository<Blink, UUID> {

    //Method to fetch all blinks for a book by book id.
//    @Query("Select blink from Blink blink where bookId = ?1")
//    List<Blink> findAllBlinksByBooksId(UUID bookId);

//    @Modifying
//    @Transactional
//    @Query(value = "Delete from Blink b where b.bookId = :bookId")
//    void deleteAllBlinksByBookId(@Param("bookId") UUID bookId);
}