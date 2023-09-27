use infinite_august23;
drop table if exists Employ;

create table Employ
(
	Empno int primary key,
    name varchar(30),
    gender enum('male','female'),
    dept varchar(30),
    desig varchar(20),
    basic numeric(9,2)
);


