- The UNION operation in SQL is used to combine the results of two or more SELECT queries into a single result set.
- It returns distinct rows from the combined results of the queries. 
- If you want to include duplicate rows, you can use UNION ALL.

  - Key Points about UNION:
    1. Column Count and Order: 
        - Each SELECT statement within the UNION must have the same number of columns in the result sets. 
        - The columns also need to have compatible data types, and their order must be the same across all queries.

    2. Distinct Rows: By default, UNION removes duplicate rows. To keep duplicates, use UNION ALL.
       - Performance: UNION ALL is generally faster than UNION because it doesn’t have to eliminate duplicates.
       - Order of Execution: The ORDER BY clause can only be applied at the end of the entire UNION operation.

             SELECT column1, column2, ...
             FROM table1
             UNION
             SELECT column1, column2, ...
             FROM table2;
       - Example
           - Assume you have two tables: employees and contractors, with the following structures:

                 1. Table: employees
                     id	name	department
                     1	    Alice	 HR
                     2	    Bob	     IT
                     3	    Charlie	 IT
      
                 2. Table: contractors
                     id	name	department
                     4	    David	IT
                     5	    Eve	    HR
             - Using UNION
               - To retrieve a combined list of names from both tables, you can write:

                     SELECT name, department
                       FROM employees
                     UNION
                     SELECT name, department
                       FROM contractors;

                       name	   department
                       Alice	       HR
                       Bob	       IT
                       Charlie	   IT
                       David	       IT
                       Eve	       HR
               - Notice that all names are distinct in the result set.
             - Using UNION ALL
               - If you want to include duplicates (if any), you can use UNION ALL:


                            SELECT name, department
                            FROM employees
                            UNION ALL
                            SELECT name, department
                            FROM contractors;
               - Ordering the Result
                - To sort the combined results, use ORDER BY at the end:


                    SELECT name, department
                    FROM employees
                    UNION
                    SELECT name, department
                    FROM contractors
                    ORDER BY name;

- The UNION operation is a powerful way to combine the results of multiple SELECT queries into a single result set, allowing you to effectively aggregate and analyze data from different sources.