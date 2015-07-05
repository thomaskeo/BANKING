'use strict';

var app = angular.module('bankingApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/Accounts', {templateUrl:'features/account/accounts.html'})
    .when('/Operations', {templateUrl:'features/operation/operations.html'})
    .when('/NouvelleOperation', {templateUrl:'features/nouvelleOperation/nouvelleOperation.html'})
    .when('/Customers', {templateUrl:'features/customer/customers.html'})
    .when('/Accounts/:customerId/:accountId', {templateUrl:'features/account/accounts.html',controller:'AccountsController'})
    .when('/login', {templateUrl:'features/login/login.html'})
    
    ;
}]);