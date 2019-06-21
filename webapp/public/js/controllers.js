angular.module('app.controllers', []).controller('MoviekListController', function($scope, $state, popupService, $window, Movie) {
  $scope.movies = Movie.query(); //fetch all movies. Issues a GET to /api/vi/movies

  $scope.deleteShipwreck = function(movie) { // Delete a Movie. Issues a DELETE to /api/v1/movies/:id
    if (popupService.showPopup('Really delete this?')) {
      movie.$delete(function() {
        $scope.movies = Movie.query(); 
        $state.go('movies');
      });
    }
  };
}).controller('MovieViewController', function($scope, $stateParams, Movie) {
  $scope.movie = Movie.get({ id: $stateParams.id }); //Get a single movie.Issues a GET to /api/v1/movies/:id
}).controller('MovieCreateController', function($scope, $state, $stateParams, Movie) {
  $scope.movie = new Movie();  //create new movie instance. Properties will be set via ng-model on UI

  $scope.addShipwreck = function() { //create a new movie. Issues a POST to /api/v1/movies
    $scope.movie.$save(function() {
      $state.go('movies'); // on success go back to the list i.e. movies state.
    });
  };
}).controller('MovieEditController', function($scope, $state, $stateParams, Movie) {
  $scope.updateShipwreck = function() { //Update the edited movie. Issues a PUT to /api/v1/movies/:id
    $scope.movie.$update(function() {
      $state.go('movies'); // on success go back to the list i.e. movies state.
    });
  };

  $scope.loadShipwreck = function() { //Issues a GET request to /api/v1/movies/:id to get a movie to update
    $scope.movie = Movie.get({ id: $stateParams.id });
  };

  $scope.loadShipwreck(); // Load a movie which can be edited on UI
});
