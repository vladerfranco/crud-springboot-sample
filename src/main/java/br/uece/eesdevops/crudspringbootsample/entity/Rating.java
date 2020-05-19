package br.uece.eesdevops.crudspringbootsample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rater;

    @Column
    private String comment;

    @Column(nullable = false)
    private Double note;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Rating() {}

    public Rating(String rater, String comment, Double note, Movie movie) {
        this.rater = rater;
        this.comment = comment;
        this.note = note;
        this.movie = movie;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRater() { return rater; }
    public void setRater(String rater) { this.rater = rater; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rater='" + rater + '\'' +
                ", comment='" + comment + '\'' +
                ", note=" + note +
                ", movie=" + movie +
                '}';
    }
}
