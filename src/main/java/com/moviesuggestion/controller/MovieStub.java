package com.moviesuggestion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moviesuggestion.model.Movie;

public class MovieStub {
    private static Map<Long, Movie> movies = new HashMap();
    private static Long idIndex = 3L;

    //populate initial wrecks
    static {
        Movie a = new Movie(1L, "Shrek", "A mean lord exiles fairytale creatures to the swamp of a grumpy ogre, who must go on a quest and rescue a princess for the lord in order to get his land back.");
        movies.put(1L, a);
        Movie b = new Movie(2L, "Finding Nemo", "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.");
        movies.put(2L, b);
        Movie c = new Movie(3L, "Up!", "Seventy-eight year old Carl Fredricksen travels to Paradise Falls in his home equipped with balloons, inadvertently taking a young stowaway.");
        movies.put(3L, c);
    }

    public static List<Movie> list() {
        return new ArrayList<Movie>(movies.values());
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
}
