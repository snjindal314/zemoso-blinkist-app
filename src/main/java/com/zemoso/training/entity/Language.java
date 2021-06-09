package com.zemoso.training.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "language")
public class Language {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "language_id")
    private UUID languageId;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_code")
    private String languageCode;

    @JsonProperty
    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();

}
