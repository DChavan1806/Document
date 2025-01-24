SELECT DISTINCT salary
FROM employees
ORDER BY salary
LIMIT 1 OFFSET 3; 


select * from employees;


WITH RankedSalaries AS (
    SELECT DISTINCT salary,
           dense_rank() OVER (ORDER BY salary) AS salary_rank
    FROM employees
)
SELECT *
FROM RankedSalaries
WHERE salary_rank = 3;

 SELECT a.employee_id, a.name, b.department_id
 FROM employees a
 right JOIN departments b ON a.department_id = b.department_id;
