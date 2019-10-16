package com.khg.springdatabaseudemy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
// @Table(name = "person")  // Class ismiyle aynı olduğu için tanıma gerek yok
public class Person {
    @Id
    @GeneratedValue  // Otomatik id vermesi için
    private int id;
    // @Column  // Column ismiyle aynı olduğu için tanıma gerek yok
    private String name;
    private String location;
    private Date birthDate;

    public Person() {
        // BeanPropertyRowMapper kullanılacağı zaman boş bir constructor tanımlanmak zorundadur.
    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("\nPerson [id=%s, name=%s, location=%s, birthDate=%s]", id, name, location, birthDate);
    }
}
