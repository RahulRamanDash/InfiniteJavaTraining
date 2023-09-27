select max(accountNo) from bank; 


select amount From Bank where AccountNo=1;
select *from trans; 
Update Bank set status='active' where accountNo=1;
select *from bank; 
describe bank;
select case when max(accountNo) IS NULL THEN 1 else 
max(accountNo)+1 end accno from Bank;

truncate trans;

Update Bank set amount=amount + 1 where accountNo=1 and status='active';
