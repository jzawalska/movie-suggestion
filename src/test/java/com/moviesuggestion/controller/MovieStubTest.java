package com.moviesuggestion.controller;

import com.moviesuggestion.model.Movie;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MovieStubTest {

    @Test
    public void whenCreateMethodIsCalled_thenAMovieIndexIsIncremented() {
        Movie movie = new Movie(1L, "Title", "Description");
        int movieAmountBefore = MovieStub.list().size();
        MovieStub.create(movie);
        int movieAmountAfter = MovieStub.list().size();
        assertEquals(movieAmountAfter, movieAmountBefore + 1);
    }

    @Test
    public void whenUpdateMethodIsCalled_thenTheDescriptionChanges() {
        long lastElementIndex = MovieStub.list().size() - 1;
        Movie lastAddedMovie = MovieStub.get(lastElementIndex);
        String descriptionBeforeUpdate = lastAddedMovie.getDescription();
        String descriptionAfterUpdate = "Updated description";
        lastAddedMovie.setDescription(descriptionAfterUpdate);
        MovieStub.update(lastElementIndex, lastAddedMovie);
        assertNotEquals(descriptionBeforeUpdate, descriptionAfterUpdate);
    }

    @Test
    public void whenDeleteMethodIsCalled_thenMovieIsRemoved() {
        long amountOfMoviesBeforeDeletion = MovieStub.list().size();
        MovieStub.delete(amountOfMoviesBeforeDeletion - 1); //assuming current number of movies >0
        int amountOfMoviesAfterDeletion = MovieStub.list().size();
        assertEquals(amountOfMoviesAfterDeletion, amountOfMoviesBeforeDeletion - 1);
    }


}
