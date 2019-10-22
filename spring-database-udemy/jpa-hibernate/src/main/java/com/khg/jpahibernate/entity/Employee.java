package com.khg.jpahibernate.entity;

import javax.persistence.*;

/**
 * Inheritance strategy
 * Def -> SINGLE_TABLE -> tüm alt classlar aynı tabloya kayıt olur
 * TABLE_PER_CLASS -> her class için tablo oluşturulur.
 * JOINED -> abstract class dahil tüm classlar için tablo oluşturulur. Ortak fieldler abstract için oluşturulan tabloda
 * diğer bilgiler kendi tablolarında tutulur.
 * @MappedSuperclass -> Entity olamaz, queryde entity olmaması nedeniyle kullanılamaz. Bu şekilde yapıldığında alt
 * classlar tam bağımsızn olarak oluşturulmaktadıKr.
 */
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
//@DiscriminatorColumn(name = "EmployeeType")  // Tip kolonuna verilecek isim belirlenebilir.
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
