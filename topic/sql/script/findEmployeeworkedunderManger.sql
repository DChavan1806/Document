use test;
select * from employees;
select * from departments;

ALter table employees
add manager_id numeric(4);

-- number of empolyeed under each manager
select 
  m.name AS manager,
  count(emp.employee_id) as number_of_emp
from 
	employees m
join 
	employees emp on m.employee_id = emp.manager_id
group by 
	m.name;
    
    
    
    -- find manager of each emp 
    select 
		emp.name as EMPLOYEE_NAME,
        m.name as MANAGER_NAME
	from 
        employees emp 
	LEFT JOIN 
        employees m on m.employee_id = emp.manager_id
	where emp.manager_id is not null;
    
    
    -- Find All Employees Under a Specific Manager (Direct and Indirect Reporting)
    
    WITH RECURSIVE EmployeeHierarchy AS (
    -- Anchor query: Get the manager
    SELECT 
        employee_id, 
        name, 
        manager_id
    FROM 
        employees
    WHERE 
        employee_id = 3
    
    UNION ALL

    -- Recursive query: Get employees reporting to the above manager
    SELECT 
        e.employee_id, 
        e.name, 
        e.manager_id
    FROM 
        employees e
    INNER JOIN 
        EmployeeHierarchy eh 
        ON e.manager_id = eh.employee_id
)
SELECT * 
FROM EmployeeHierarchy;


-- top level manager 
WITH RECURSIVE TopManager AS (
    -- Start with employees
    SELECT 
        employee_id, 
        name, 
        manager_id
    FROM 
        employees
    
    UNION ALL

    -- Traverse up the hierarchy to find the top manager
    SELECT 
        e.employee_id, 
        e.name, 
        m.manager_id
    FROM 
        employees e
    INNER JOIN 
        TopManager m 
        ON e.employee_id = m.manager_id
    WHERE 
        m.manager_id IS NOT NULL
)
SELECT 
    employee_id, 
    name, 
    manager_id
FROM 
    TopManager
WHERE 
    manager_id IS NULL;
    




    
    

         