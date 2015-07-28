'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('PaydayApp', [
  'ngRoute',
  'PaydayApp.filters',
  'PaydayApp.services',
  'PaydayApp.directives',
  'PaydayApp.controllers'
]);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/login.html', controller: 'AuthController'});

  $routeProvider.when('/manager/dashboard', {templateUrl: 'partials/manager_partials/manager_dashboard.html', controller: 'MainController'});
  $routeProvider.when('/manager/employees', {templateUrl: 'partials/manager_partials/manager_employees.html', controller: 'MainController'});
  $routeProvider.when('/manager/employees/:user_id', {templateUrl: 'partials/manager_partials/manager_employee_detail.html', controller: 'MainController'});
  $routeProvider.when('/manager/transactions', {templateUrl: 'partials/manager_partials/manager_transactions.html', controller: 'MainController'});
  $routeProvider.when('/manager/settings', {templateUrl: 'partials/manager_partials/manager_settings.html', controller: 'MainController'});

  $routeProvider.when('/employee/dashboard', {templateUrl: 'partials/employee_partials/employee_dashboard.html', controller: 'MainController'});
  $routeProvider.when('/employee/history', {templateUrl: 'partials/employee_partials/employee_history.html', controller: 'MainController'});
  $routeProvider.when('/employee/settings', {templateUrl: 'partials/employee_partials/employee_settings.html', controller: 'MainController'});

  $routeProvider.otherwise({redirectTo: '/'});
}]);