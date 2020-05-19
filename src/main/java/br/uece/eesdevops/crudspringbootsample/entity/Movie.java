package br.uece.eesdevops.crudspringbootsample.entity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String synopsis;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "protagonist_name")
    private String protagonistName;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @Transient
    private Double average;

    public Movie() {}

    public Movie(String title, String synopsis, Integer releaseYear, String producerName, List<Rating> ratings) {
        this.title = title;
        this.synopsis = synopsis;
        this.releaseYear = releaseYear;
        this.producerName = producerName;
        this.ratings = ratings;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getSynopsis() { return synopsis; }
    public Integer getReleaseYear() { return releaseYear; }
    public String getProducerName() { return producerName; }
    public String getProtagonistName() { return protagonistName; }
    public List<Rating> getRatings() { return ratings; }
    public Double getAverage(){ return average; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public void setProducerName(String producerName) { this.producerName = producerName; }
    public void setProtagonistName(String protagonistName) { this.protagonistName = protagonistName; }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }

    @PostLoad
    public void calculateAverage() {
        average = ratings.parallelStream().mapToDouble(Rating::getNote).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseYear=" + releaseYear +
                ", producerName='" + producerName + '\'' +
                ", protagonistName='" + protagonistName + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
