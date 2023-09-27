use infinite_august23;

create table employee
(
empid int primary key,
empname varchar(30) not null,
empemail varchar(30),
mobileno varchar(30),
dateofjoin date,
managerid int,
leaveavail int
);
