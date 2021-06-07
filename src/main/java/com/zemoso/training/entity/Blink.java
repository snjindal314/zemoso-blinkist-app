package com.zemoso.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "blink")
public class Blink {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blink_id", updatable = false, nullable = false)
    private UUID blinkId;

    @Column(name = "blink_title")
    @NotBlank(message = "Blink title can not be empty.")
    private String blinkTitle;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "blink_number", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int blinkNumber;

    @Column(name = "blink_text")
    @NotBlank(message = "Blink text can not be blank.")
    private String blinkText;

}
