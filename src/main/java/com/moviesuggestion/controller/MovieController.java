package com.moviesuggestion.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.moviesuggestion.model.Movie;


@RestController
@RequestMapping("api/v1/")
public class MovieController {

    @RequestMapping(value = "movies", method = RequestMethod.GET)
    public List<Movie> list() {
        return MovieStub.list();
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.GET)
    public Movie get(@PathVariable Long id) {
        return MovieStub.get(id);
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.PUT)
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        return MovieStub.update(id, movie);
    }

    @RequestMapping(value = "movie/{id}", method = RequestMethod.DELETE)
    public Movie delete(@PathVariable Long id) {
        return MovieStub.delete(id);
    }

}
