--this does not pass, with subquery returns more than one row error
select d.Name Department, e.Name Employee, e.Salary from Employee e join Department d on e.DepartmentId = d.id where e.Salary >= (select salary from Employee ee where ee.DepartmentId = e.DepartmentId order by Salary desc LIMIT 1, 2) order by d.Name asc, e.Salary desc;
--use count(distinct) to get the index
SELECT D.Name AS Department, E.Name AS Employee, E.Salary AS Salary 
FROM Employee E, Department D
WHERE (SELECT COUNT(DISTINCT(Salary)) FROM Employee 
       WHERE DepartmentId = E.DepartmentId AND Salary > E.Salary) < 3
AND E.DepartmentId = D.Id 
ORDER by E.DepartmentId, E.Salary DESC;