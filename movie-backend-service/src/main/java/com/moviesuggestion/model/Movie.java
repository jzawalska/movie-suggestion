package com.moviesuggestion.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Document(collection = "movies")
@Repository
public class Movie {
    @Id
    private ObjectId _id;
    private String title;
    private String description;

    public Movie() {
    }

    public Movie(ObjectId id, String title, String description) {
        this._id = id;
        this.title = title;
        this.description = description;
    }

    public Movie(ObjectId id) {
        this._id = id;
    }

    public Movie createMovieWithId(ObjectId id) {
        return new Movie(id);
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
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

    public Movie getMovieById (ObjectId movieId) {
        return createMovieWithId(movieId);
    }

    public void setMovieData(Movie movie){
        setTitle(movie.getTitle());
        setDescription(movie.getDescription());
    }
}
