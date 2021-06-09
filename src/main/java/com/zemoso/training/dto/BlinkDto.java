package com.zemoso.training.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BlinkDto {
    private UUID blinkId;
    private String blinkTitle;
    private int blinkNumber;
    private String blinkText;
    private BookDto bookDto;
}
