package com.mrdb.repositories;

import com.mrdb.entities.Movies;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MoviesRepository extends CrudRepository<Movies, Integer> {
    List<Movies> findAllByUserName(String userName);
}
