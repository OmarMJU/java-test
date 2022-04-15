package com.omju.movies.service;

import com.omju.movies.data.MovieRepositoryI;
import com.omju.movies.model.Movie;
import java.util.stream.Collectors;
import java.util.Collection;

public class MovieService {
    private final MovieRepositoryI movieRepository;

    public MovieService(MovieRepositoryI movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenere(String genere) {
        return this.allMovies().stream().filter(movie -> movie.getGenre() == genere).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return this.allMovies().stream().filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    private Collection<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
