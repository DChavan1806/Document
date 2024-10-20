

        WITH LowSalaries AS (
        SELECT department_id, MIN(salary) As low_salary
        from employees
        group by department_id
        )  
        SELECT * from employees e
        JOIN departments d ON e.department_id = d.department_id
        JOIN LowSalaries ls on e.department_id = ls.department_id
        AND e.salary = ls.low_salary
        ORDER BY ls.low_salary;


    employee_id	name	department_id	salary	manager_id
    1	       Alice	101	            5000	NULL
    2	       Bob	    101	            4000	1
    3	       Charlie	102	            4500	1
    4	       David	103	            4200	3
    5	       Eve	    103	            3900	3
    6	       Frank	102	            3700	1

    1. SQL Query to Find How Many Employees Work Under Each Manager:

    SELECT 
        e.name AS manager_name,
        COUNT(emp.employee_id) AS number_of_employees
    FROM
        employees e
    LEFT JOIN
        employees emp ON e.employee_id = emp.manager_id
    WHERE
        emp.manager_id IS NOT NULL
    GROUP BY
        e.name;


    


