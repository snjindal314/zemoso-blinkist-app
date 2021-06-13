package com.zemoso.training.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserLibraryDto {
    private UUID userId;
    private UUID bookId;
//    private boolean isFinished;
//    private int blinkNumber;
//    private Date startDate;
//    private Date finishDate;
}
