package com.omju.movies.data;

import com.omju.movies.model.Movie;
import java.util.Collection;

public interface MovieRepositoryI {
    Movie findById(long id);
    Collection<Movie> findAll();
    Movie findByName(String name);
    void saveOrUpdate(Movie movie);
}
