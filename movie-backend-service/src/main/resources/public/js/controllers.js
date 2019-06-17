angular.module('app.controllers', []).controller('MovieListController', function($scope, $state, popupService, $window, Movie) {
  $scope.movies = Movie.query(); //fetch all movies. Issues a GET to /api/vi/movie

  $scope.deleteMovie = function(movie) { // Delete a Movie. Issues a DELETE to /api/v1/movie/:id
    if (popupService.showPopup('Really delete this?')) {
      movies.$delete(function() {
        $scope.movies = Movie.query(); 
        $state.go('movie');
      });
    }
  };
}).controller('MovieViewController', function($scope, $stateParams, Movie) {
  $scope.movies = Movie.get({ id: $stateParams.id }); //Get a single movie.Issues a GET to /api/v1/movie/:id
}).controller('MovieCreateController', function($scope, $state, $stateParams, Movie) {
  $scope.movies = new Movie();  //create new movie instance. Properties will be set via ng-model on UI

  $scope.addMovie = function() { //create a new movie. Issues a POST to /api/v1/movie
    $scope.movies.$save(function() {
      $state.go('movie'); // on success go back to the list i.e. movies state.
    });
  };
}).controller('MovieEditController', function($scope, $state, $stateParams, Movie) {
  $scope.updateMovie = function() { //Update the edited movie. Issues a PUT to /api/v1/movie/:id
    $scope.movies.$update(function() {
      $state.go('movie'); // on success go back to the list i.e. movies state.
    });
  };

  $scope.loadMovie = function() { //Issues a GET request to /api/v1/movie/:id to get a movie to update
    $scope.movies = Movie.get({ id: $stateParams.id });
  };

  $scope.loadMovie(); // Load a movie which can be edited on UI
});
