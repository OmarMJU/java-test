package com.omju.movies.service;

import com.omju.movies.data.MovieRepositoryI;
import com.omju.movies.model.Genere;
import com.omju.movies.model.Movie;
import java.util.stream.Collectors;
import java.util.Collection;

public class MovieService {
    private final MovieRepositoryI movieRepository;

    public MovieService(MovieRepositoryI movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenere(Genere genere) {
        Collection<Movie> allMovies = movieRepository.findAll().stream().filter(movie -> movie.getGenere() == genere).collect(Collectors.toList());
        return  allMovies;
    }
}
