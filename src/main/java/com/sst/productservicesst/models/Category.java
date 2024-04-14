package com.sst.productservicesst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Category {
    @Id
    private Long id;
    private String title;
    private String description;
}
