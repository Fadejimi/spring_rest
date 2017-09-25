SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id   INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  email  VARCHAR(50) NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  beerkind VARCHAR(50) NOT NULL ,
  gender CHAR(1) NOT NULL ,
  interests TEXT NOT NULL
);

DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_username_role (role,username),
  FOREIGN KEY (username) REFERENCES users (username)
  ON DELETE CASCADE
  ON UPDATE CASCADE);

DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL,
  amount INT NOT NULL,
  pricePerKilo INT NOT NULL
);


DROP TABLE IF EXISTS ingredient_attributes;

CREATE TABLE ingredient_attributes (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  taste VARCHAR(100) NOT NULL,
  ingredient_id INT(11) NOT NULL,
  FOREIGN KEY(ingredient_id) REFERENCES ingredients(id)
);
