package com.moviesuggestion.api;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.methods.TmdbMovies;
import com.omertron.themoviedbapi.model.movie.MovieInfo;

import com.omertron.themoviedbapi.tools.HttpTools;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

import java.util.List;

public class Connection {

    private static final String API_KEY = "d5888934e6e9f7110a53f43734597ee6";
//    private static HttpTools httpTools;

    public static void main(String[] args) {
        TmdbMovies movies = new TmdbMovies(API_KEY, new HttpTools(new SimpleHttpClientBuilder().build()));
        try {
            List<MovieInfo> topRatedMovies = getTopRatedMoviesEnglish(movies);
            System.out.println(topRatedMovies);
        } catch (MovieDbException e) {
            e.printStackTrace();
        }
    }

    public static List<MovieInfo> getTopRatedMoviesEnglish(TmdbMovies movies) throws MovieDbException {
        List<MovieInfo> topRatedMovies = movies.getTopRatedMovies(0, "en").getResults();
        return topRatedMovies;
    }
}
