package com.mrdb.controller;

import com.mrdb.entities.MovieCast;
import com.mrdb.entities.Movies;
import com.mrdb.entities.UserEntity;
import com.mrdb.model.AddMovieService;
import com.mrdb.repositories.MovieCastRepository;
import com.mrdb.repositories.MoviesRepository;
import com.mrdb.repositories.UserEntityRepository;
import com.mrdb.model.GetAndSetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MainController {

    @Autowired
    private UserEntityRepository userRepo;

    @Autowired
    private MoviesRepository moviesRepo;

    @Autowired
    private MovieCastRepository movieCastRepo;

    private GetAndSetData getAndSetData;
    private AddMovieService addMoviesService;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity userDetails) {
        getAndSetData = new GetAndSetData(userRepo);
        if(getAndSetData.login(userDetails)) {
            return "Success";
        }
        return "fail";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity userDetails) {
        getAndSetData = new GetAndSetData(userRepo);
        return getAndSetData.saveToDb(userDetails);
    }

    @GetMapping("/getMovies")
    public List<Movies> getMovies(@RequestBody String userName) {
        addMoviesService = new AddMovieService(moviesRepo);
        return addMoviesService.getMovies(userName);
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@RequestBody Movies movie) {
        addMoviesService = new AddMovieService(moviesRepo);
        System.out.println("Name--"+movie.getMovieName());
        System.out.println("Desc--"+movie.getMovieDesc());
        System.out.println("genre--"+movie.getGenre());
        System.out.println("UserName--"+movie.getUserName());
        return addMoviesService.saveMovieToDb(movie);
    }

    @GetMapping("/getMovieCast")
    public List<MovieCast> getMovieCast(@RequestBody String movieName) {
        addMoviesService = new AddMovieService(movieCastRepo);
        return addMoviesService.getMoviecast(movieName);
    }

    @PostMapping("/saveMovieCast")
    public String saveMovieCast(@RequestBody MovieCast movieCast) {
        addMoviesService = new AddMovieService(movieCastRepo);
        System.out.println("Name--"+movieCast.getMovieName());
        System.out.println("Directors--"+movieCast.getDirectors());
        System.out.println("AssDirectors--"+movieCast.getAssistantDirectors());
        System.out.println("Staring--"+movieCast.getStarring());
        return addMoviesService.saveMovieCastToDb(movieCast);
    }
}
