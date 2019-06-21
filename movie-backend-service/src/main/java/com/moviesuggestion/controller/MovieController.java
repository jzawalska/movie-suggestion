package com.moviesuggestion.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.moviesuggestion.model.MovieRepository;
import com.moviesuggestion.model.Movie;


@RestController
@RequestMapping("api/v1/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "movie", method = RequestMethod.GET)
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @RequestMapping(value="movie", method = RequestMethod.POST)
    @ResponseBody()
    public ResponseEntity<Movie> create(@RequestBody Movie movieRequest){
        Movie movie = movieRepository.save(movieRequest);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.GET)
    public Movie get(@PathVariable("id") ObjectId id) {
        return movieRepository.findBy_id(id);
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> update(@PathVariable ObjectId id, @RequestBody Movie movie) {
        Movie editedMovie = movieRepository.findBy_id(id);
        editedMovie.setMovieData(movie);
        movieRepository.save(editedMovie);
        return new ResponseEntity<>(editedMovie, HttpStatus.OK);
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId id) {
        movieRepository.deleteBy_id(id);
    }

}
