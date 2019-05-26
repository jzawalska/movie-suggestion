package com.moviesuggestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    todo come back here!
//    @RequestMapping(value = "movie/{id}", method = RequestMethod.GET)
//    public Movie get(@PathVariable Optional<String> id) {
//        return movieRepository.findById(id);
//    }

//    todo
//    @RequestMapping(value = "movie/{id}", method = RequestMethod.PUT)
//    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
//
//    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        movieRepository.deleteById(id);
    }

}
