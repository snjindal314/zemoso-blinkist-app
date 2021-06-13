package com.zemoso.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user_library")
public class UserLibrary {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "user_id", updatable = false, nullable = false)
//    private UUID userId;

    @EmbeddedId
    private UserLibraryId userLibraryId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "blink_number")
    private int blinkNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;
}
