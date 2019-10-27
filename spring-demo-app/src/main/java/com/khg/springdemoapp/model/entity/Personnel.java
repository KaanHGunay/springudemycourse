package com.khg.springdemoapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khg.springdemoapp.model.entity.utils.Rank;
import com.khg.springdemoapp.model.entity.utils.RankConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personnel")
@NoArgsConstructor
public @Data class Personnel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String batchNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private City placeOfBirth;

    @Convert(converter = RankConverter.class)
    @Column(nullable = false)
    private Rank rank;

    private Boolean isActive;

    public Personnel(String batchNumber, String name, String surname, City placeOfBirth, Rank rank, Boolean isActive) {
        this.batchNumber = batchNumber;
        this.name = name;
        this.surname = surname;
        this.placeOfBirth = placeOfBirth;
        this.rank = rank;
        this.isActive = isActive;
    }
}
