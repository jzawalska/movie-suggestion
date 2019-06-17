angular.module('app.services', []).factory('Movie', function($resource) {
  return $resource('/api/v1/movie/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
