package com.omju.movies.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.omju.movies.model.Movie;
import java.util.Collection;
import java.sql.ResultSet;

public class MovieRepositoryIImpl implements MovieRepositoryI {
    private final static String INSERT_ONE_MOVIE = "insert into movies (name, minutes, genre) values (?, ?, ?)";
    private final static String SELECT_ONE_MOVIE = "select * from movies where id = ?";
    private final static String SELECT_ALL_MOVIES = "select * from movies";
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryIImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object args[] = { id };
        return jdbcTemplate.queryForObject(SELECT_ONE_MOVIE, args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query(SELECT_ALL_MOVIES, movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update(INSERT_ONE_MOVIE, movie.getName(), movie.getMinutes(), movie.getGenre());
    }

    private static RowMapper<Movie> movieMapper = (ResultSet rs, int rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            rs.getString("genre")
    );
}
