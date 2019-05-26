package com.moviesuggestion.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.Optional;

public abstract class MovieDao implements MovieRepository {
    @Autowired
    private Movie movie;

//    todo
//    @Override
//    public Optional<Movie> findById(Optional<Movie> s) {
//        return movie.getMovieById(s);
//    }

//    public Movie findmovieById(String id){
//        return
//    }


}
