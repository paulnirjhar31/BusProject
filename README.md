# BusProject
this is just a project which I built in one day.. needs improvement, 

clone the project using below: 
git clone https://github.com/paulnirjhar31/BusProject.git

Import this project as a existing project in eclipse,


set up my sql below command

Login to mysql using root or admin account
CREATE USER 'nirjhar'@'localhost' IDENTIFIED BY 'password';

Create a new db: 
create database testconfig;

GRANT ALL PRIVILEGES ON * . * TO 'nirjhar'@'localhost';
FLUSH PRIVILEGES;
USE testconfig

run the dump file upload DUMP20190503.sql
varify db, table should get created

run it in tomcat 8.5 or hiher using java 1.8

update the connection details 
DatabaseServiceImpl class : 
DriverManager.getConnection("jdbc:mysql://localhost/testconfig?" + "user=nirjhar&password=password");

