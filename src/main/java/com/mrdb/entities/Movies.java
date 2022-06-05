package com.mrdb.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movies_details")

public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String movieName;
    private String movieDesc;
    private String imgPath;
    private String genre;
    private Date releasedDate;
    private String userName;

    public Movies() {

    }

    public Movies(Integer id, String movieName, String movieDesc, String imgPath, String genre, Date currentDate, String userName) {
        this.id = id;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.imgPath = imgPath;
        this.genre = genre;
        this.releasedDate = currentDate;
        this.userName = userName;
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

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

