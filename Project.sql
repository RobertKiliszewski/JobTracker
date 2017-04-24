create database myDB;

use myDB;

CREATE TABLE Users (
	id INT NOT NULL AUTO_INCREMENT,
	work_place varchar(128) NOT NULL,
	username varchar(128) NOT NULL,
	password varchar(20) NOT NULL,
	name varchar(20) NOT NULL,
	surname varchar(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Earnings (
	id INT NOT NULL AUTO_INCREMENT,
	week_no INT NOT NULL,
	earnings FLOAT NOT NULL,
	user_ID INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Hours (
	id INT NOT NULL AUTO_INCREMENT,
	date_day INT NOT NULL,
	date_month INT NOT NULL,
	date_year INT NOT NULL,
	earned FLOAT NOT NULL,
	user_ID INT NOT NULL,
	PRIMARY KEY (id)
);


ALTER TABLE Earnings ADD CONSTRAINT Shifts_fk0 FOREIGN KEY (user_ID) REFERENCES Users(id);
ALTER TABLE Hours ADD CONSTRAINT Hours_fk1 FOREIGN KEY (user_ID) REFERENCES Users(id);
