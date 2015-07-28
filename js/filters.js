'use strict';

/* Filters */

var app = angular.module('PaydayApp.filters', []);


app.filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    };
}]);

app.filter('reverse', [function() {
  return function(items) {
    return items.slice().reverse();
  };
}]);
