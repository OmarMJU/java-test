package com.omju.movies.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.omju.movies.model.Genere;
import com.omju.movies.model.Movie;
import java.util.Collection;
import java.sql.ResultSet;

public class MovieRepositoryIImpl implements MovieRepositoryI {
    private JdbcTemplate jdbcTemplate;
    private final static String SELECT_ALL_MOVIES = "select * from movies";

    public MovieRepositoryIImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query(SELECT_ALL_MOVIES, movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }

    private static RowMapper<Movie> movieMapper = (ResultSet rs, int rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genere.valueOf(rs.getString("genre"))
    );
}
