use infinite_august23;
create table student
(
sno int primary key,
name varchar(30),
sub1 int,
sub2 int,
sub3 int,
total int,
aveg numeric(9,2)
);

insert into student(sno,name,sub1,sub2,sub3)
values(1,'ansal',88,64,64),
(2,'ariz',86,67,77),
(3,'sagar',88,46,62),
(4,'smruti',76,67,74);

