package com.moviesuggestion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Document(collection = "movies")
@Repository
public class Movie {
    @Id
    private Optional<String> id;
    private String title;
    private String description;

    public Movie() {
    }

    public Movie(Optional<String> id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Movie(Optional<String> id) {
        this.id = id;
    }

    public Movie createMovieWithId(Optional<String> id) {
        return new Movie(id);
    }

    public Optional<String> getId() {
        return id;
    }

    public void setId(Optional<String> id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Optional<Movie> getMovieById (Optional<String> movieId) {
        return Optional.ofNullable(createMovieWithId(movieId));
    }
}
