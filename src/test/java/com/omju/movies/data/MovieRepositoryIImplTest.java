package com.omju.movies.data;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.omju.movies.model.ConstantsMovies;
import org.junit.runners.MethodSorters;
import com.omju.movies.model.Movie;
import java.sql.SQLException;
import java.util.Collection;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import org.junit.*;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieRepositoryIImplTest {
    private static final String DROP_DB_OBJECTS = "drop all objects delete files";
    private static final String SCRIPT_RESOURCE = "sql-scripts/test-data.sql";
    private static final String URL_DB = "jdbc:h2:mem:test;MODE=MYSQL";
    private static MovieRepositoryIImpl movieRepositoryI;
    private static DataSource dataSource;
    private List<Movie> moviesMock;

    @BeforeClass
    public static void setUpCalss() throws SQLException {
        dataSource = new DriverManagerDataSource(URL_DB);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource(SCRIPT_RESOURCE));
        movieRepositoryI = new MovieRepositoryIImpl(jdbcTemplate);
    }

    @Before
    public void setUp() {
        moviesMock = new ArrayList<>();
        moviesMock.add(new Movie(1, "Dark Knight", 152, ConstantsMovies.ACTION));
        moviesMock.add(new Movie(2, "Memento", 113, ConstantsMovies.THRILLER));
        moviesMock.add(new Movie(3, "Theres Something About Mary", 119, ConstantsMovies.COMEDY));
        moviesMock.add(new Movie(4, "Super 8", 112, ConstantsMovies.THRILLER));
        moviesMock.add(new Movie(5, "Scream", 111, ConstantsMovies.HORROR));
        moviesMock.add(new Movie(6, "Home Alon", 103, ConstantsMovies.COMEDY));
        moviesMock.add(new Movie(7, "Matrix", 112, ConstantsMovies.ACTION));
    }

    @Test
    public void loadAllMovies() {
        Collection<Movie> movies = movieRepositoryI.findAll();
        assertEquals(moviesMock, movies);
    }

    @Test
    public void loadMovieById() {
        Movie movie = movieRepositoryI.findById(4);
        assertEquals(moviesMock.get(3), movie);
    }

    @Test
    public void updateInsertMovie() {
        Movie movieExpected = new Movie("A Serbian Film", 105, "HORROR");
        movieRepositoryI.saveOrUpdate(movieExpected);
        assertEquals(movieExpected.getName(), movieRepositoryI.findById(8).getName());
    }

    @Test
    public void loadMovieByName() {
        String movieName = "Dark Knight";
        Movie movieExpected = new Movie(1, movieName, 152, ConstantsMovies.ACTION);
        assertEquals(movieExpected.getName(), movieRepositoryI.findByName(movieName).getName());
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute(DROP_DB_OBJECTS);
    }
}