package com.mrdb.model;

import com.mrdb.entities.MovieCast;
import com.mrdb.entities.Movies;
import com.mrdb.repositories.MovieCastRepository;
import com.mrdb.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AddMovieService {

    @Autowired
    private MoviesRepository moviesRepo;

    @Autowired
    private MovieCastRepository movieCastRepo;

    public AddMovieService(MoviesRepository moviesRepo) {
        this.moviesRepo = moviesRepo;
    }
    public AddMovieService(MovieCastRepository movieCastRepo) {
        this.movieCastRepo = movieCastRepo;
    }

    public String saveMovieToDb(Movies movie) {
        if(null == movie) {
            return "problem";
        }
        String result = "Success";
        try {
            moviesRepo.save(movie);
        } catch (Exception e) {
            result = "problem";
            e.printStackTrace();
        }
        return result;
    }

    public List<Movies> getMovies(String userName) {
        if(null == userName) {
            return null;
        }
        return moviesRepo.findAllByUserName(userName);
    }

    public List<MovieCast> getMoviecast(String movieName) {
        if(null == movieName) {
            return null;
        }
        return movieCastRepo.findAllByMovieName(movieName);
    }

    public String saveMovieCastToDb(MovieCast movieCast) {
        if(movieCast == null) {
            return "Problem";
        }
        String result = "Success";
        try {
            movieCastRepo.save(movieCast);
        } catch (Exception e) {
            result = "problem";
            e.printStackTrace();
        }
        return result;
    }
}
