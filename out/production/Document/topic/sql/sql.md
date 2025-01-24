- ACID : [acid.md](acid.md)
- Database Normalization : 
    - [database-normalization.md](database-normalization.md)
    - https://chatgpt.com/share/6719082d-45e8-8002-a990-ac79ac9ef227

- JOIN : [join-sql.md](join-sql.md)
- UNION : [union-operation.md](union-operation.md)

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


        CREATE TABLE Employee_details(  
        Emp_Id NUMBER(4) NOT NULL,  
        First_name VARCHAR(30),  
        Last_name VARCHAR(30),  
        Salary Money,  
        City VARCHAR(30),  
        PRIMARY KEY (Emp_Id)  
        );
        
        ALTER TABLE Employee_details   
        ADD Designation VARCHAR(18);  

        ALTER TABLE table_name DROP COLUMN column_name;  

        ALTER TABLE table_name MODIFY column_name column_datatype[(size)];  
      
        DROP TABLE Employee_details;   

        CREATE DATABASE Company;  

        INSERT INTO Employee_details 
          ( Emp_ID, First_name, Last_name, Salary,City)  
        VALUES
         (101,Akhil,Sharma,40000,Bangalore),
         (102,Sagar,Sharma,40000,Bangalore);  


          TRUNCATE TABLE Employee_details; - delete all record from table
           DESCRIBE Employee_details; 
                
                CREATE INDEX idx_First_Name  
                ON employee_details (First_Name);

  - LEFT JOIN  union all -> :
  - PlSQL -> function and trigger:
  - how increase performance of queue: https://chatgpt.com/c/67835ce9-63cc-8002-8f6b-9e6801d3cda9
  - 1 box and small boxes -> 5 child 





    


