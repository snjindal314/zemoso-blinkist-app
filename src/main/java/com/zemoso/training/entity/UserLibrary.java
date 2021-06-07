package com.zemoso.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "user_library")
public class UserLibrary {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;


}
