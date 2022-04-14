package com.omju.movies.data;

import com.omju.movies.model.Movie;
import java.util.Collection;

public interface MovireRepositoryI {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
