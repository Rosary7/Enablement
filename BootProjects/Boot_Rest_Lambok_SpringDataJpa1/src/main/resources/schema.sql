DROP TABLE IF EXISTS EMPLOYEES;
  
CREATE TABLE TEST_EMPLOYEE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);

CREATE TABLE TEST_USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);