package com.omju.movies.service;

import com.omju.movies.data.MovieRepositoryI;
import com.omju.movies.model.Genere;
import com.omju.movies.model.Movie;
import java.util.stream.Collectors;
import java.util.Collection;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void setUp() {
        MovieRepositoryI movieRepositoryMock = Mockito.mock(MovieRepositoryI.class);
        movieService = new MovieService(movieRepositoryMock);

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Dark Knight", 152, Genere.ACTION));
        movies.add(new Movie(2, "Memento", 113, Genere.THRILLER));
        movies.add(new Movie(3, "There's Something About Mary", 119, Genere.COMEDY));
        movies.add(new Movie(4, "Super 8", 112, Genere.THRILLER));
        movies.add(new Movie(5, "Scream", 111, Genere.HORROR));
        movies.add(new Movie(6, "Home Alon", 103, Genere.COMEDY));
        movies.add(new Movie(7, "Matrix", 112, Genere.ACTION));

        // Create behavior to method findAll from MovieRepositoryI.
        Mockito.when(movieRepositoryMock.findAll()).thenReturn(movies);
    }

    @Test
    public void returnMoviesByeGenere() {
        Collection<Movie> moviesByGenere = movieService.findMoviesByGenere(Genere.COMEDY);
        assertEquals(Arrays.asList(3, 6), this.getMoviesIds(moviesByGenere));
    }

    @Test
    public void returnMoviesByLength() {
        Collection<Movie> moviesByLength = movieService.findMoviesByLength(119);
        assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7), this.getMoviesIds(moviesByLength));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}