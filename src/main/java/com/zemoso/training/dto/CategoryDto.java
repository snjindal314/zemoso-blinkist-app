package com.zemoso.training.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDto {

    private UUID categoryId;
    private String categoryName;
    private String description;

}
