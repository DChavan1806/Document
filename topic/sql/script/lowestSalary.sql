use test;
select * from employees;
select * from departments;

With lowSalaries AS (
   select department_id, MIN(salary) as lowestSalary
   from employees 
   group by department_id
)
Select DISTINCT d.department_name, e.salary from employees e
JOIN departments d on e.department_id = d.department_id
JOIN lowSalaries ls on ls.department_id = d.department_id
where e.salary = ls.lowestSalary 
order by e.salary;

