package com.zemoso.training.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private UUID bookId;

    @Column(name = "book_title")
    @NotBlank(message = "Book title can not be empty.")
    private String bookTitle;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @Column(name = "author")
    @NotBlank(message = "Author can not be blank.")
    private String author;

    @Column(name = "cover_image")
    private byte[] coverImage;

    @JsonProperty
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "number_of_reads", nullable = false)
    private int numberOfReads;

    @Column(name = "total_read_time", nullable = false)
    private int totalReadTime;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Blink> blinkList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    private Language language;

}
