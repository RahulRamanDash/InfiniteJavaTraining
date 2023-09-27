use infinite_august23;

insert into Employee(empid,empname, empemail,mobileno,dateofjoin,managerid,leaveavail)
values(1000,'sagar', 'sagar@gmail.com', 7654987654,'2023-08-17',null,12),
(1001,'abhishak', 'abhishak@gmail.com', 7654998765,'2023-08-17',1000,11),
(1002,'kaushik', 'kaushik@gmail.com', 7654967876,'2023-08-17',1000,12),
(1003,'prakash', 'prakash@gmail.com', 7654987385,'2023-08-17',1001,13),
(1004,'harsh', 'harsh@gmail.com', 7654981985,'2023-08-17',1001,11),
(1005,'shivangi', 'shivangi@gmail.com', 7654987656,'2023-08-17',1002,12),
(1006,'rajesh', 'rajesh@gmail.com', 7654987659,'2023-08-17',1002,12);

drop table if exists leavedetails;
create table leavedetails
(
leaveid int primary key auto_increment,
empid int,
leavestartdate date,
leaveenddate date,
noofdays int,
leavetype enum('EL','PL','ML'),
leavestatus ENUM('pending','accepted','rejected') default 'pending',
leavereason varchar(30),
APPLIEDON timestamp DEFAULT CURRENT_TIMESTAMP,
foreign KEY(EMPID) REFERENCES EMPLOYEE(EMPID)
);

INSERT INTO leavedetails(empid,leavestartdate,leaveenddate,leavetype,leavereason)
VALUES(1000,'2023-10-10','2023-10-10','EL','GOING HOME'),
(1005,'2023-12-12','2023-12-25','EL','FUNCTION'),
(1006,'2023-12-25','2023-12-31','ML','MY MARRIGE');
