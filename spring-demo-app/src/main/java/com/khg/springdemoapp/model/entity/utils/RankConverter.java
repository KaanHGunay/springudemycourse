package com.khg.springdemoapp.model.entity.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RankConverter implements AttributeConverter<Rank, String> {
    @Override
    public String convertToDatabaseColumn(Rank rank) {
        if(rank == null) return null;

        switch (rank){
            case POLIS_MEMURU:
                return "Polis Memuru";
            case BASPOLIS_MEMURU:
                return "Başpolis Memuru";
            case KIDEMLI_BASPOLIS_MEMURU:
                return "Kıdemli Başpolis Memuru";
            case KOMISER_YARDIMCISI:
                return "Komiser Yardımcısı";
            case KOMISER:
                return "Komiser";
            case BASKOMISER:
                return "Başkomiser";
            case EMNIYET_AMIRI:
                return "Emniyet Amiri";
            case EMNIYET_MUDURU_4:
                return "4. Sınıf Emniyet Müdürü";
            case EMNIYET_MUDURU_3:
                return "3. Sınıf Emniyet Müdürü";
            case EMNIYET_MUDURU_2:
                return "2. Sınıf Emniyet Müdürü";
            case EMNIYET_MUDURU_1:
                return "1. Sınıf Emniyet Müdürü";
            default:
                throw new IllegalArgumentException(rank + " not supported.");
        }
    }

    @Override
    public Rank convertToEntityAttribute(String rank) {
        switch (rank){
            case "Polis Memuru":
                return Rank.POLIS_MEMURU;
            case "Başpolis Memuru":
                return Rank.BASPOLIS_MEMURU;
            case "Kıdemli Başpolis Memuru":
                return Rank.KIDEMLI_BASPOLIS_MEMURU;
            case "Komiser Yardımcısı":
                return Rank.KOMISER_YARDIMCISI;
            case "Komiser":
                return Rank.KOMISER;
            case "Başkomiser":
                return Rank.BASKOMISER;
            case "Emniyet Amiri":
                return Rank.EMNIYET_AMIRI;
            case "4. Sınıf Emniyet Müdürü":
                return Rank.EMNIYET_MUDURU_4;
            case "3. Sınıf Emniyet Müdürü":
                return Rank.EMNIYET_MUDURU_3;
            case "2. Sınıf Emniyet Müdürü":
                return Rank.EMNIYET_MUDURU_2;
            case "1. Sınıf Emniyet Müdürü":
                return Rank.EMNIYET_MUDURU_1;
            default:
                throw new IllegalArgumentException(rank + " not supported.");
        }
    }
}
