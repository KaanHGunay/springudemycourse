package com.khg.springdemoapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khg.springdemoapp.model.entity.utils.Rutbe;
import com.khg.springdemoapp.model.entity.utils.RutbeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Personelin bilgileri tutulan class
 */
@Entity
@Table(name = "personnel")
@NoArgsConstructor
public @Data class Personnel {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Personelin sicil bilgisi
     */
    @Column(nullable = false)
    private String batchNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private City placeOfBirth;

    @Convert(converter = RutbeConverter.class)
    @Column(nullable = false)
    private Rutbe rutbe;

    private Boolean isActive;

    public Personnel(String batchNumber, String name, String surname, City placeOfBirth, Rutbe rutbe, Boolean isActive) {
        this.batchNumber = batchNumber;
        this.name = name;
        this.surname = surname;
        this.placeOfBirth = placeOfBirth;
        this.rutbe = rutbe;
        this.isActive = isActive;
    }
}
