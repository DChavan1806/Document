`WITH LowSalaries AS (
SELECT department_id, MIN(salary) As low_salary
from employees
group by department_id
)  
SELECT * from employees e
JOIN departments d ON e.department_id = d.department_id
JOIN LowSalaries ls on e.department_id = ls.department_id
AND e.salary = ls.low_salary
ORDER BY ls.low_salary;`