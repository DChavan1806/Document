- Types of SQL Joins
  1. INNER JOIN
     - Returns records that have matching values in both tables.
       - Example:

                SELECT a.id, a.name, b.department
                FROM employees a
                INNER JOIN departments b ON a.department_id = b.id;
                Tables:
                employees: Contains employee details (id, name, department_id).
                departments: Contains department details (id, department).
  2. LEFT JOIN (or LEFT OUTER JOIN)
     - Returns all records from the left table and matched records from the right table. 
       - If there is no match, NULL values are returned for columns from the right table.

              SELECT a.id, a.name, b.department
              FROM employees a
              LEFT JOIN departments b ON a.department_id = b.id;
              Result: All employees are listed, even those without a department.
  3. RIGHT JOIN (or RIGHT OUTER JOIN)
     - Returns all records from the right table and matched records from the left table. 
       - If there is no match, NULL values are returned for columns from the left table.

              SELECT a.id, a.name, b.department
              FROM employees a
              RIGHT JOIN departments b ON a.department_id = b.id;
              Result: All departments are listed, including those without employees.
  4. FULL JOIN (or FULL OUTER JOIN)
     - Returns all records when there is a match in either left or right table records. 
       - If there is no match, NULL values are returned for unmatched records from both tables.

              SELECT a.id, a.name, b.department
              FROM employees a
              FULL OUTER JOIN departments b ON a.department_id = b.id;
              Result: All employees and all departments are listed, with NULLs where there are no matches.
  5. CROSS JOIN
     - Returns the Cartesian product of the two tables, meaning it will return all possible combinations of rows.

            SELECT a.id, a.name, b.department
            FROM employees a
            CROSS JOIN departments b;
            Result: Every employee is paired with every department.

- Interview Questions Related to SQL Joins
1. What is the difference between INNER JOIN and LEFT JOIN?
   - **Answer**: INNER JOIN returns only the rows with matching values in both tables, while LEFT JOIN returns all rows from the left table, along with matched rows from the right table; unmatched rows from the right will have NULL values.

2. What are the performance implications of using JOINs?
   - **Answer**: Joins can lead to performance issues, especially with large datasets, due to the complexity of combining rows. Proper indexing, limiting result sets with WHERE clauses, and avoiding unnecessary joins can help improve performance.

3. Can you explain a scenario where a FULL JOIN is necessary?
   - **Answer**: A FULL JOIN is useful when you want to display all records from both tables, even if they don’t match. For instance, when analyzing sales data, you may want to see all sales representatives and all sales made, regardless of whether every representative made a sale.

4. What is a self-join, and when would you use it?
   - **Answer**: A self-join is when a table is joined with itself to compare rows within the same table. This can be useful in hierarchical data scenarios, such as an employee table where each employee might have a manager also listed in the same table.

5. How would you handle NULL values in joins?
   - **Answer**: NULL values can be handled using functions like COALESCE or ISNULL to provide default values. Additionally, you can use WHERE clauses to filter out NULLs if they’re not desired in the results.

6. What happens if you join two tables that do not have any matching records?
   - **Answer**: The result will depend on the type of join used. With INNER JOIN, there will be no results. With LEFT JOIN, all records from the left table will be returned, with NULLs for the right table. With RIGHT JOIN, all records from the right table will be returned, with NULLs for the left table.
