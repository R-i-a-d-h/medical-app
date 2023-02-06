create database medical2;
use medical2 ;
CREATE TABLE assistant (
assistantID INT(11) AUTO_INCREMENT not null,
firstname VARCHAR(32) NOT NULL,
lastname VARCHAR(32) NOT NULL,
birthday date NOT NULL,
address VARCHAR(64) ,
phone VARCHAR(32) ,
gender VARCHAR(10) ,
pass VARCHAR(10) NOT NULL,
 PRIMARY KEY(assistantID));
 CREATE TABLE waiting (
waitingID INT(11) AUTO_INCREMENT not null,
firstname VARCHAR(32) NOT NULL,
lastname VARCHAR(32) NOT NULL,
phone VARCHAR(32) ,
gender VARCHAR(10) ,
pstatus VARCHAR(10) NOT NULL,
 PRIMARY KEY(waitingID));
CREATE TABLE appointment  (
appointmentID INT(11) AUTO_INCREMENT not null,
firstname VARCHAR(32) NOT NULL,
lastname VARCHAR(32) NOT NULL,
phone VARCHAR(32) ,
gender VARCHAR(10) ,
pstatus VARCHAR(10) NOT NULL,
dateOne date NOT NULL,
dateTwo date NOT NULL,

 PRIMARY KEY(appointmentID));