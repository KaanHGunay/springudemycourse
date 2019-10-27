package com.khg.springdemoapp.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Cacheable
@NoArgsConstructor
public @Data class City {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public City(String name) {
        this.name = name;
    }
}
