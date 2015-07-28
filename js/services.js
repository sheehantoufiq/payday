'use strict';

var app = angular.module('PaydayApp.services', []);

app.value('version', '0.1');

// store currentUser
app.factory('Users', [function(){
	var currentUser = {};
	var users = {};

	var User = {
		currentUser: function() {
			return currentUser;
		},
		returnUsers: function() {
			return users;
		}
	};

	//return function user(){	
	//};
}]);

app.factory('Business', [function(){

	var businessName = "Your Business Name";

	var Business = {
		setBusinessName: function(bname) {
			businessName = bname;
			console.log(businessName);
		},
		getBusinessName: function() {
			return businessName;
		}
	};
	return Business;

}]);

app.factory('Auth', [function(){

	var users = [
		{
			username: "elonmusk@spacex.com",
			password: "bossman",
			is_admin: true
		},
		{
			username: "sheehantoufiq@gmail.com",
			password: "payday",
			is_admin: false
		},
		{
			username: "sheehantoufiq@gmail.com",
			password: "payday",
			is_admin: false
		}
	];

	//this logic should be serverside
	var Auth = {

		login: function(un, pw) {
			var errorMsg = "Error: no user";
	    for (var i=0; i < users.length; i++) {
	    	if (users[i].username === un) {
	    		if (users[i].password === pw) {
	    			return users[i];
	    		} else {
	    			errorMsg = "Error: wrong pass";
	    		}
	      }
	    }
	    return errorMsg;
    }
    
	};
	return Auth;

}]);


app.factory('Manager', [function(){
	//dummy employee data
	var employees = [
		{
			user_id: 1,
			first_name: "Employee",
			last_name: "1",
			wage: 7.90,
			phone_number: "555-5555",
			status: "active"
		},
		{
			user_id: 2,
			first_name: "Employee",
			last_name: "2",
			wage: 7.90,
			phone_number: "555-5555",
			status: "active"
		},
		{
			user_id: 3,
			first_name: "Employee",
			last_name: "3",
			wage: 7.90,
			phone_number: "555-5555",
			employee_status: "active"
		},
	];
	var employees2 = [];

	function employee(fn, ln, wg, pn, st) {
		function createId() {
			var num = employees2.length + 1;
			return num;
		};
		this.user_id = createId();
		this.first_name = fn;
		this.last_name = ln;
		this.wage = wg;
		this.phone_number = pn;
		this.employee_status = st;
	};

	var transactionsData = "Transactions Data";

	var Manager = {
		getEmployees: function() {
			return employees;
		},
		getEmployees2: function() {
			return employees2;
		},
		getEmployee: function(uid) {
			var uidInt = parseInt(uid) - 1;
			var currentEmployee = employees2[uidInt]

			return currentEmployee;
		},
		createEmployee: function(fn, ln, wg, pn, st) {
			var newEmployee = new employee(fn, ln, wg, pn, st);
			employees2.push(newEmployee);
		},
		getTransactions: function() {
			return transactionsData;
		}
	};
	return Manager;
}]);

app.factory('Transaction', [function(){

	var dailyBalance = 0;
	var transactions = [];
	var categories = [];

	function transaction(date, type, cat, des, amt) {
		this.trans_date = date;
		this.trans_type = type;
		this.trans_category = cat;
		this.trans_description = des;
		this.trans_amount = amt;
		this.trans_balance = getBalance(type, amt);

		function getBalance(type, amt) {
			var amtInt = parseInt(amt);
			if (type === "Debit") {
				dailyBalance -= amtInt; 
				return dailyBalance;
			} else {
				dailyBalance += amtInt;
				return dailyBalance;
			}
		}
	};

	function category(cat) {
		this.category = cat;
	};

	var Transaction = {
		getTransaction: function() {
			//return currentTransaction;
		},
		getTransactions: function() {
			return transactions;
		},
		getDailyBalance: function() {
			console.log(dailyBalance);
			return dailyBalance;
		},
		createTransaction: function(date, type, cat, des, amt) {
			var newTransaction = new transaction(date, type, cat, des, amt);
			dailyBalance = newTransaction.trans_balance;
			console.log(dailyBalance);
			transactions.push(newTransaction);
		},
		createCategory: function(cat) {
			var newCategory = new category(cat);
			categories.push(newCategory);
		},
		getCategories: function() {
			return categories;
		}
	};
	return Transaction;
}]);

app.factory('Employee', [function(){

/*

    var config = {
      url: Url.registerAPI,
      method: 'POST',
      data: JSON.stringify({
        email: $scope.email,
        password: $scope.password
      }),
      headers: {'Content-Type': 'application/json; charset=utf-8'}
    };

    $http(config)
      .success(function(data, status, headers, config) {
        if (data.msg !== 'Failure to create user') {
          $location.path('/login');
        } else {
          $scope.msg = 'Email already exists.';
        }
      })
      .error(function(data, status, headers, config) {

      });

*/

// getters and setters, need to dependency inject to controllers

var Business = $resource('/api/businesses/:id');
var Employee = $resource('/api/businesses/1/employees/:id');
var Eorktime  = $resource('/api/businesses/1/employees/:id/worktimes/:id');
var Transaction = $resource('/api/businesses/1/transactions/:id');
var Category = $resource('/api/businesses/1/categories/:id');


function updateBusiness(bID, bName, bAdd, bCity, bState, bZip, bPhone) {
	// get & update business
	var business = new Business.get({id: bID});
	business.name = bName;
	business.address = bAdd;
	business.city = bCity;
	business.state = bState;
	business.zip = bZip;
	business.phone = bPhone;
	business.$save();
}

function createEmployee(eID, eEmail, ePass, eFirst, eLast, eBio, eWage, eImg) {
	// create new employee
	var employee = new Employee();
	employee.email = eEmail;
	employee.pass = ePass;
	employee.fname = eFirst;
	employee.lname = eLast;
	employee.bio = eBio;
	employee.wage = eWage;
	employee.img = eImg;
	employee.$save();
}

function updateEmployee(eID, eEmail, ePass, eFirst, eLast, eBio, eWage, eImg) {
	// get and update an employee
	var employee = new Employee({id: eID});
	employee.email = eEmail;
	employee.pass = ePass;
	employee.fname = eFirst;
	employee.lname = eLast;
	employee.bio = eBio;
	employee.wage = eWage;
	employee.img = eImg;
	employee.$save();
}

function getEmployee(eID) {
	var employee = new Employee({id: eID});
	return employee;
}

function deleteEmployee(eID) {
	var employee = new Employee({id: eID});
	return "Employee deleted.";
}

function getBusiness(bID) {
	var business = new Business({id: eID});
	return business;
}

function getTransaction(tID) {
	var transaction = new Transaction({id: eID});
	return transaction;
}

function deleteTransaction(eID) {
	var transaction = new Transaction({id: eID});
	return "Transaction deleted.";
}

function getWorktime(wID) {
	var worktime = new Worktime({id: eID});
	return worktime;
}

function deleteWorktime(eID) {
	var employee = new Employee({id: eID});
	return "Employee deleted.";
}



/* psuedo code
//get and update a todo
var todo2 = Todo.get({id: 123});
todo2.foo += '!';
todo2.$save();

//which is basically the same as...
Todo.get({id: 123}, function(todo) {
   todo.foo += '!';
   todo.$save();
});

//get a list of todos
Todo.query(function(todos) {
  //do something with todos
  angular.forEach(todos, function(todo) {
     todo.foo += ' something';
     todo.$save();
  });
});

//delete a todo
Todo.$delete({id: 123});

*/

}]);