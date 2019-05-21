package com.moviesuggestion.controller;

import com.moviesuggestion.model.Movie;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MovieStubTest {
    @Test
    @DisplayName("When create method is called then amount of movies increases by one")
    public void whenCreateMethodIsCalled_thenAmountofMoviesIncreasesByOne() {
        int movieAmountBeforeInsertingElement = MovieStubMock.list().size();
        MovieStubMock.create(new Movie(MovieStubMock.getIdIndex() + 1, "Title", "Desc"));
        int movieAmounfAfterInsertingElement = MovieStubMock.list().size();
        int diffInMock = movieAmounfAfterInsertingElement - movieAmountBeforeInsertingElement;

        assertEquals(diffInMock, 1);
    }

    @Test
    @DisplayName("When update method is called then the description changes")
    public void whenUpdateMethodIsCalled_thenTheDescriptionChanges() {
        Movie newMovie = MovieStubMock.create(new Movie(MovieStubMock.getIdIndex(), "Title", "Desc"));
        String descriptionBeforeUpdate = newMovie.getDescription();
        newMovie.setDescription("Updated description");
        MovieStubMock.update(newMovie.getId(), newMovie);
        String descriptionAfterUpdate = newMovie.getDescription();
        assertNotEquals(descriptionBeforeUpdate, descriptionAfterUpdate);
    }

    @Test
    @DisplayName("When delete method is called then amount of movies decreases by one")
    public void whenDeleteMethodIsCalled_thenMovieIsRemoved() {
        Movie newMovie = MovieStubMock.create(new Movie(MovieStubMock.getIdIndex(), "Title", "Desc"));
        MovieStubMock.setIdIndex(MovieStubMock.getIdIndex() + 1);
        int amountOfMoviesBeforeDeletionInMock = MovieStubMock.list().size();
        MovieStubMock.delete(newMovie.getId());
        int amountOfMoviesAfterDeletionInMock = MovieStubMock.list().size();
        int diffInMock = amountOfMoviesBeforeDeletionInMock - amountOfMoviesAfterDeletionInMock;
        assertEquals(diffInMock, 1);
    }
}