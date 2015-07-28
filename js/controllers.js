'use strict';

/* Controllers */

var app = angular.module('PaydayApp.controllers', []);

app.controller('AuthController', ['$scope', '$location', 'Auth', function($scope, $location, Auth){

	$scope.errorMsg = "";

	$scope.user = {
		username: "",
		password: ""
	};
	
	var currentUser = "";

	$scope.login = function() {

		var un = $scope.user.username;
		var pw = $scope.user.password;

		console.log(un + " " + pw);

		currentUser = Auth.login(un, pw);
		console.log(currentUser);

		if (currentUser === "Error: no user" || currentUser === "Error: wrong pass") {
			$scope.errorMsg = currentUser;
			$scope.user = {
				username: "",
				password: ""
			};
		} else {
			if (currentUser.is_admin === false) {
				$location.path('/employee/dashboard');
			} else {
				$location.path('/manager/dashboard');
			}
		}
	};

	$scope.logout = function() {
		$scope.user = {
			username: "",
			password: ""
		};
		currentUser = "";
		$location.path('/');
	};

}]);

app.controller('MainController', ['$scope', '$routeParams', 'Manager', 'Transaction', 'Business', function($scope, $routeParams, Manager, Transaction, Business) {

	$scope.employees = Manager.getEmployees();
	$scope.employees2 = Manager.getEmployees2();

	$scope.newEmployee = {
		first_name: "",
		last_name: "",
		wage: "",
		phone_number: "",
		employee_status: "active"
	};	

	$scope.transactions = Manager.getTransactions();
	$scope.transactions2 = Transaction.getTransactions();


	var d = new Date();
	var curr_date = d.getDate();
	var curr_month = d.getMonth() + 1;
	var curr_year = d.getFullYear();
	var today = curr_month + "/" + curr_date + "/" + curr_year;

	$scope.newTransaction = {
		trans_date: today,
		trans_type: "",
		trans_category: "",
		trans_description: "",
		trans_amount: ""
	};

	$scope.currentEmployee = Manager.getEmployee($routeParams.user_id);

	/*
		*	createEmployee()
		*	
	*/
	$scope.createEmployee = function() {
		var fn = $scope.newEmployee.first_name;
		var ln = $scope.newEmployee.last_name;
		var wg = $scope.newEmployee.wage;
		var pn = $scope.newEmployee.phone_number;
		var st = $scope.newEmployee.employee_status;

		Manager.createEmployee(fn, ln, wg, pn, st);

		$scope.newEmployee = {
			first_name: "",
			last_name: "",
			wage: "",
			phone_number: "",
			employee_status: "active"
		};

		$('.add-employee-modal-lg').modal('hide');

	};

	$scope.dailyBalance = Transaction.getDailyBalance();

	/*
		*	createTransaction()
		*	
	*/
	$scope.createTransaction = function() {

		var date = $scope.newTransaction.trans_date;
		var type = $scope.newTransaction.trans_type;
		var cat = $scope.newTransaction.trans_category;
		var des = $scope.newTransaction.trans_description;
		var amt = $scope.newTransaction.trans_amount;

		Transaction.createTransaction(date, type, cat, des, amt);

		$scope.newTransaction = {
			trans_date: today,
			trans_type: "",
			trans_category: "",
			trans_description: "",
			trans_amount: ""
		};
		$scope.dailyBalance = Transaction.getDailyBalance();

	};

	$scope.category = "";
	$scope.categories = Transaction.getCategories();

	$scope.createCategory = function() {
		var cat = $scope.category;
		Transaction.createCategory(cat);
		$scope.category = "";

		$('.add-category-modal-lg').modal('hide');
	};

	$scope.business = {
		bus_name: Business.getBusinessName()
	};

	$scope.setBusinessName = function() {
		var bname = $scope.business.bus_name

		Business.setBusinessName(bname);

		$scope.business = {
			bus_name: Business.getBusinessName()
		};
	};

}]);