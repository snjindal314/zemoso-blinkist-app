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

    @EmbeddedId
    private UserLibraryId userLibraryId;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "blink_number")
    private int blinkNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;
}
