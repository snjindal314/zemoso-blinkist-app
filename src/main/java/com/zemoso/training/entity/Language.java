package com.zemoso.training.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "language_id", updatable = false, nullable = false)
    private UUID languageId;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_code")
    private String languageCode;

    @JsonProperty
    @Column(name = "is_active")
    private boolean isActive;

}
