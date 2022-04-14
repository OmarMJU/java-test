package com.omju.movies.model;

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
}
