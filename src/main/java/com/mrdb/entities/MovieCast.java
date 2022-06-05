package com.mrdb.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_cast")
@SuppressWarnings("JpaAttributeTypeInspection")

public class MovieCast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String movieName;
    private String directors;
    private String assistantDirectors;
    private String starring;

    public MovieCast(String movieName, String directors, String assistantDirectors, String starring) {
        this.movieName = movieName;
        this.directors = directors;
        this.assistantDirectors = assistantDirectors;
        this.starring = starring;
    }

    public MovieCast() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getAssistantDirectors() {
        return assistantDirectors;
    }

    public void setAssistantDirectors(String assistantDirectors) {
        this.assistantDirectors = assistantDirectors;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }
}
