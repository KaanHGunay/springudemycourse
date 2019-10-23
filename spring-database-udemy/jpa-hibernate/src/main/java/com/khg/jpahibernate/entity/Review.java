package com.khg.jpahibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)  // Enum kullanılacaktır
    private ReviewRating rating;

    @Column(name = "description")
    private String description;

    @ManyToOne  // Default fetch is eager
    private Course course;

    public Review() {}

    public Review(ReviewRating rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return getRating() + " " + getDescription();
    }
}
