use infinite_august23;
select * from student;

update student set total=sub1+sub2+sub3, aveg = (sub1+sub2+sub3)/3;

select * from employee;

update employ set name='sonali sahu',dept='sql',desig='expert',basic='78999' where empno=3;

update employ set basic=basic+1000 where dept='sql';
update employee set empname = upper(empname) where empid in (select empid from leavedetails where empid=1003)

