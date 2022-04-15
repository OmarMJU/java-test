package com.omju.movies.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private  String name;
    private int minutes;
    private Genere genere;

    public Movie(Integer id, String name, int minutes, Genere genere) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genere = genere;
    }

    public Movie(String name, int minutes, Genere genere) {
        this(null, name, minutes, genere);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genere == movie.genere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genere);
    }
}