package com.zemoso.training.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LanguageDto {
    private UUID languageId;
    private String languageName;
    private String languageCode;
    @JsonProperty
    private boolean isActive;

}
