package com.zemoso.training.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class BookDto {

    private UUID bookId;
    private String bookTitle;
    private Date creationDate;
    private String author;
    private byte[] coverImage;
    @JsonProperty
    private boolean isActive;
    private UUID languageId;
    private UUID categoryId;
    private int numberOfReads;
    private int totalReadTime;

    private List<BlinkDto> blinkDtoList;
    private CategoryDto categoryDto;
    private LanguageDto languageDto;

}
