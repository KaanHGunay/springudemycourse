package com.khg.jpahibernate.entity;

import javax.persistence.*;

/**
 * Inheritance strategy
 * Def -> SINGLE_TABLE tüm alt classlar aynı tabloya kayıt olur
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EmployeeType")  // Tip kolonuna verilecek isim belirlenebilir.
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
