DROP DATABASE payday_db;
CREATE DATABASE payday_db;
USE payday_db; 

CREATE TABLE business_table
(
	business_id int NOT NULL,
	business_name varchar(255),
	address varchar(255),
	city varchar(255),
	state varchar(255),
	zip varchar(255),
	phone varchar(255),
	PRIMARY KEY (business_id)
) ENGINE=InnoDB;

CREATE TABLE transaction_table
(
	transaction_id int NOT NULL,
	business_id int NOT NULL,
	date_created timestamp default now(),
	type TINYINT(1),
	category varchar(255),
	description varchar(255),
	amount FLOAT(22,2),
	transaction_date varchar(255),
	account_balance FLOAT(22,2),
	PRIMARY KEY (transaction_id),
	FOREIGN KEY (business_id) REFERENCES business_table(business_id)
) ENGINE=InnoDB;

CREATE TABLE category_table
(
	category_id int NOT NULL,
	business_id int NOT NULL,
	category_name varchar(255),
	PRIMARY KEY (category_id),
	FOREIGN KEY (business_id) REFERENCES business_table(business_id)
) ENGINE=InnoDB;

CREATE TABLE employee_table
(
	employee_id int NOT NULL,
	business_id int NOT NULL,
	email varchar(255),
	password varchar(255),
	first_name varchar(255),
	last_name varchar(255),
	bio varchar(255),
	wage FLOAT(22,2),
	is_manager tinyint(1),
	phone varchar(255),
	image LONGBLOB,
	PRIMARY KEY (employee_id),
	FOREIGN KEY (business_id) REFERENCES business_table(business_id)
) ENGINE=InnoDB;

CREATE TABLE worktime_table
(
	worktime_id int NOT NULL,
	employee_id int NOT NULL,
	time_in datetime,
	time_out datetime,
	PRIMARY KEY (worktime_id),
	FOREIGN KEY (employee_id) REFERENCES employee_table(employee_id)
) ENGINE=InnoDB;

INSERT INTO business_table(
	business_id, business_name, address, city, state, zip, phone)
	VALUES (1, 'Payday, Inc', '555 Main St', 'Atlanta', 'GA', '30303', '555-555-5555'
);

INSERT INTO employee_table(
	employee_id, business_id, email, password, first_name, last_name, bio, wage, is_manager, phone, image)
	VALUES (1, 1, 'elonmusk@spacex.com', 'bossman', 'Elon', 'Musk', 'I WILL make electric rockets.', 0.00, 1, '555-555-5555', null
);
