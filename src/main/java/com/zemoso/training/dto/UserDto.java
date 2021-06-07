package com.zemoso.training.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID userId;
    private String name;
    private String email;
    private String password;
    private String username;
    private long phone;
    @JsonProperty
    private boolean isActive;
    @JsonIgnore
    private Date creationDate;
    @JsonProperty
    private boolean isAdmin;
}
