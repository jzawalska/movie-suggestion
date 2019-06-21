package com.moviesuggestion.controller;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class MovieStubTest {
    @Test
    @DisplayName("When create method is called then amount of movies increases by one")
    public void whenCreateMethodIsCalled_thenAmountofMoviesIncreasesByOne() {

        // Arrange
        int movieAmountBeforeInsertingElement = MovieStubMock.list().size();
        MovieStubMock.create(new Movie(MovieStubMock.getIdIndex() + 1, "Title", "Desc"));

        // Act
        int movieAmounfAfterInsertingElement = MovieStubMock.list().size();
        int diffInMock = movieAmounfAfterInsertingElement - movieAmountBeforeInsertingElement;

        // Assert
        assertEquals(diffInMock, 1);
    }

    @Test
    @DisplayName("When update method is called then the description changes")
    public void whenUpdateMethodIsCalled_thenTheDescriptionChanges() {

        // Arrange
        Movie newMovie = MovieStubMock.create(new Movie(MovieStubMock.getIdIndex(), "Title", "Desc"));
        String descriptionBeforeUpdate = newMovie.getDescription();
        newMovie.setDescription("Updated description");

        // Act
        MovieStubMock.update(newMovie.getId(), newMovie);
        String descriptionAfterUpdate = newMovie.getDescription();

        // Assert
        assertNotEquals(descriptionBeforeUpdate, descriptionAfterUpdate);
    }

    @Test
    @DisplayName("When delete method is called then amount of movies decreases by one")
    public void whenDeleteMethodIsCalled_thenMovieIsRemoved() {

        // Arrange
        Movie newMovie = MovieStubMock.create(new Movie(MovieStubMock.getIdIndex(), "Title", "Desc"));
        MovieStubMock.setIdIndex(MovieStubMock.getIdIndex() + 1);
        int amountOfMoviesBeforeDeletionInMock = MovieStubMock.list().size();

        // Act
        MovieStubMock.delete(newMovie.getId());
        int amountOfMoviesAfterDeletionInMock = MovieStubMock.list().size();
        int diffInMock = amountOfMoviesBeforeDeletionInMock - amountOfMoviesAfterDeletionInMock;

        // Assert
        assertEquals(diffInMock, 1);
    }
}