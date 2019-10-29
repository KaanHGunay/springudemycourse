package com.khg.springdemoapp.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request olarak alınacak olan bilgileri tutacak olan class
 * Veri tabanı işlemlerinde kuulanılır.
 * Converter {@link com.khg.springdemoapp.model.dao.PersonnelConverter} ile personnel classına dönüştürülür
 */
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