CREATE SCHEMA IF NOT EXISTS cupcakedb;
USE cupcakedb;

DROP TABLE IF EXISTS invoice_line;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS cupcake;
DROP TABLE IF EXISTS top;
DROP TABLE IF EXISTS base;

CREATE TABLE base (
  base_id int(11) NOT NULL,
  base_name varchar(45) NOT NULL,
  PRIMARY KEY (base_id)
);

CREATE TABLE top (
  top_id int(11) NOT NULL,
  top_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (top_id)
);

CREATE TABLE cupcake (
  cupcake_id int(11) NOT NULL,
  cupcake_name varchar(45) DEFAULT NULL,
  base_id int(11) NOT NULL,
  top_id int(11) NOT NULL,
  price decimal(7,2) NOT NULL,
  PRIMARY KEY (cupcake_id),
  FOREIGN KEY (base_id) REFERENCES base (base_id),
  FOREIGN KEY (top_id) REFERENCES top (top_id)
);

CREATE TABLE user (
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  isadmin tinyint(1) NOT NULL DEFAULT '0',
  balance decimal(9,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (username)
);

CREATE TABLE invoice (
  invoice_id INT NOT NULL,
  customer_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (invoice_id),
  FOREIGN KEY (customer_id)
    REFERENCES user (username)
);

CREATE TABLE invoice_line (
  invoice_id INT NOT NULL,
  cupcake_id INT NOT NULL,
  qty INT NULL,
  PRIMARY KEY (invoice_id, cupcake_id),
  FOREIGN KEY (invoice_id)
    REFERENCES invoice (invoice_id),
  FOREIGN KEY (cupcake_id)
    REFERENCES cupcake (cupcake_id)
);

INSERT INTO base (base_id, base_name) VALUES (0,'Vanilla');
INSERT INTO base (base_id, base_name) VALUES (1,'Chocolate');
INSERT INTO base (base_id, base_name) VALUES (2,'Pistacio');
INSERT INTO base (base_id, base_name) VALUES (3,'Almond');
INSERT INTO base (base_id, base_name) VALUES (4,'Nutmeg');

INSERT INTO top (top_id, top_name) VALUES (0,'Chocolate');
INSERT INTO top (top_id, top_name) VALUES (1,'lemon');
INSERT INTO top (top_id, top_name) VALUES (2,'Orange');
INSERT INTO top (top_id, top_name) VALUES (3,'Rum/raisin');
INSERT INTO top (top_id, top_name) VALUES (4,'Blue cheese');
INSERT INTO top (top_id, top_name) VALUES (5,'Strawberry');
INSERT INTO top (top_id, top_name) VALUES (6,'Rasberry');
INSERT INTO top (top_id, top_name) VALUES (7,'Blueberry');
INSERT INTO top (top_id, top_name) VALUES (8,'Crispy');

INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(0,'Choco dream',1,0, 10.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(1,'Vanilla-blueberry',0,7, 10.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(2,'Vanilla-rasberry',0,6, 10.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(3,'Choco-crisp',1,8, 12.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(4,'Strawberry special',4,5, 12.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(5,'Rum/raisin',0,3, 12.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(6,'Sunny day',1,2, 15.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(7,'Psycadelic',2,1, 15.00);
INSERT INTO cupcake (cupcake_id,cupcake_name,base_id,top_id,price) VALUES(8,'Delicate',3,4, 15.00);

INSERT INTO user(username,password,isadmin,balance) VALUES('admin',1234,1, 1000.00);
INSERT INTO user(username,password,isadmin,balance) VALUES('Anders And',1234,0, 500.00);
INSERT INTO user(username,password,isadmin,balance) VALUES('Fedtmule',1234,0, 250.00);
INSERT INTO user(username,password,isadmin,balance) VALUES('Mickey Mouse',1234,0, 50.00);

INSERT INTO invoice (invoice_id, customer_id) VALUES ('0', 'Anders And');
INSERT INTO invoice (invoice_id, customer_id) VALUES ('1', 'Fedtmule');

INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('0', '2', '10');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('0', '3', '20');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('0', '4', '20');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('1', '1', '15');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('1', '2', '10');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('1', '3', '5');
INSERT INTO invoice_line (invoice_id, cupcake_id, qty) VALUES ('1', '4', '5');

