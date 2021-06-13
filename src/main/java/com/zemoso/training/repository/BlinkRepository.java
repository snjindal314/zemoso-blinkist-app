package com.zemoso.training.repository;

import com.zemoso.training.entity.Blink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlinkRepository extends JpaRepository<Blink, UUID> {

    //Method to fetch all blinks for a book by book id.
//    @Query("Select blink from Blink blink where bookId = ?1")
    List<Blink> findBlinksByBookBookId(UUID bookId);

    List<Blink> deleteBlinksByBookBookId(UUID bookId);

}