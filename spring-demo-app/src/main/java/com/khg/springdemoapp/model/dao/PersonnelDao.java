package com.khg.springdemoapp.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class PersonnelDao {
    private Long id;
    private String batchNumber;
    private String name;
    private String surname;
    private String placeOfBirth;
    private String rutbe;
    private Boolean isActive;
}