package com.moviesuggestion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moviesuggestion.model.Movie;

//Arrange, Act, Assert
public class MovieStubMock {
    private static Map<Long, Movie> movies = new HashMap<>();
    private static Long idIndex = 0L;

    public static List<Movie> list() {
        return new ArrayList<>(movies.values());
    }

    public static Movie create(Movie movie) {
        idIndex += idIndex;
        movie.setId(idIndex);
        movies.put(idIndex, movie);
        return movie;
    }

    public static Movie get(Long id) {
        return movies.get(id);
    }

    public static Movie update(Long id, Movie movie) {
        movies.put(id, movie);
        return movie;
    }

    public static Movie delete(Long id) {
        return movies.remove(id);
    }

    public static void setIdIndex(Long idIndex) {
        MovieStubMock.idIndex = idIndex;
    }

    public static Long getIdIndex() {
        return idIndex;
    }
}
