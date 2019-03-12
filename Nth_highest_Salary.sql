CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE myvar int;
  SELECT count(distinct(salary)) INTO myvar FROM employee;
  if myvar >= N then set myvar := N;
  else set N :=0;
  end if;
  RETURN (
      select A.salary 
      from 
      (
       select  distinct(Salary) from Employee  
          Order by  Salary desc limit N) as A
           order by A.salary asc limit 1
      
  );
END
