package com.khg.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_start_with_t", query = "Select c from Course c where name like 'T%'")
})
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;  // Java 8 den önce java.util.time kullanılıyor.

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {}

    public Course(String name) {
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
        this.reviews.add(review);
    }

    public void removeReviews(Review review) {
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return getName();
    }
}
