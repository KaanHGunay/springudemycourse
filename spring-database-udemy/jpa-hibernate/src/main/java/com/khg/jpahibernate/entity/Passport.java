package com.khg.jpahibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    /**
     * Mapped By veritabanında verinin iki tabloda da tutularak fazladan veri tutulmasının önüne geçmek için kullanılır
     * Mapped By olacak değişken birebir bağlı olduğu diğer sınıfın isimlendirmesini alır
     * Mapped By Owner olmayan tarafa uygulanmalı
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport() {}

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return getNumber();
    }
}
