package com.zemoso.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", updatable = false, nullable = false)
    private UUID categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

}
