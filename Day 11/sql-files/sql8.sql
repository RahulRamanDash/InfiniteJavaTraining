
select * from employee;

select empname from employee where empid=(select managerid from employee where empid=1004);

select empname from employee where managerid=(select empid from employee where empid=1001);


select * from leavedetails where empid in(select empid from employee where managerid=1001);
select * from leavedetails where empid =any(select empid from employee where managerid=1001);
