package com.omju.movies.data;

import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.omju.movies.model.Genere;
import com.omju.movies.model.Movie;
import java.sql.SQLException;
import java.util.Collection;
import javax.sql.DataSource;
import java.util.ArrayList;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MovieRepositoryIImplTest {
    private static final String SCRIPT_RESOURCE = "sql-scripts/test-data.sql";
    private static final String URL_DB = "jdbc:h2:mem:test;MODE=MYSQL";
    private static MovieRepositoryIImpl movieRepositoryI;

    @BeforeClass
    public static void setUpCalss() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource(URL_DB);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource(SCRIPT_RESOURCE));
        movieRepositoryI = new MovieRepositoryIImpl(jdbcTemplate);
    }

    @Test
    public void loadAllMovies() {
        List<Movie> moviesMock = new ArrayList<>();
        moviesMock.add(new Movie(1, "Dark Knight", 152, Genere.ACTION));
        moviesMock.add(new Movie(2, "Memento", 113, Genere.THRILLER));
        moviesMock.add(new Movie(3, "Theres Something About Mary", 119, Genere.COMEDY));
        moviesMock.add(new Movie(4, "Super 8", 112, Genere.THRILLER));
        moviesMock.add(new Movie(5, "Scream", 111, Genere.HORROR));
        moviesMock.add(new Movie(6, "Home Alon", 103, Genere.COMEDY));
        moviesMock.add(new Movie(7, "Matrix", 112, Genere.ACTION));

        Collection<Movie> movies = movieRepositoryI.findAll();
        assertEquals(moviesMock, movies);
    }
}