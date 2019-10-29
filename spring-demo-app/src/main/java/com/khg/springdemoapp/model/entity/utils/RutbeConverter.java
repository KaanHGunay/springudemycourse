package com.khg.springdemoapp.model.entity.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RutbeConverter implements AttributeConverter<Rutbe, String> {
    @Override
    public String convertToDatabaseColumn(Rutbe rutbe) {
        if(rutbe == null) return null;

        switch (rutbe){
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
                throw new IllegalArgumentException(rutbe + " not supported.");
        }
    }

    @Override
    public Rutbe convertToEntityAttribute(String rank) {
        switch (rank){
            case "Polis Memuru":
                return Rutbe.POLIS_MEMURU;
            case "Başpolis Memuru":
                return Rutbe.BASPOLIS_MEMURU;
            case "Kıdemli Başpolis Memuru":
                return Rutbe.KIDEMLI_BASPOLIS_MEMURU;
            case "Komiser Yardımcısı":
                return Rutbe.KOMISER_YARDIMCISI;
            case "Komiser":
                return Rutbe.KOMISER;
            case "Başkomiser":
                return Rutbe.BASKOMISER;
            case "Emniyet Amiri":
                return Rutbe.EMNIYET_AMIRI;
            case "4. Sınıf Emniyet Müdürü":
                return Rutbe.EMNIYET_MUDURU_4;
            case "3. Sınıf Emniyet Müdürü":
                return Rutbe.EMNIYET_MUDURU_3;
            case "2. Sınıf Emniyet Müdürü":
                return Rutbe.EMNIYET_MUDURU_2;
            case "1. Sınıf Emniyet Müdürü":
                return Rutbe.EMNIYET_MUDURU_1;
            default:
                throw new IllegalArgumentException(rank + " not supported.");
        }
    }
}
