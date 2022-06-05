package com.mrdb.repositories;

import com.mrdb.entities.MovieCast;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieCastRepository extends CrudRepository<MovieCast, Integer> {
    List<MovieCast> findAllByMovieName(String movieName);
}
