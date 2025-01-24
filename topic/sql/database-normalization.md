- Database normalization is a systematic approach to organizing data in a database to reduce redundancy and improve data integrity. 
- The goal of normalization is to divide large tables into smaller, manageable pieces while establishing relationships between them. 
- This process follows a series of steps known as normal forms (NF), each with specific rules and requirements.

- Key Concepts of Normalization
  1. Redundancy: Storing the same data in multiple places can lead to inconsistency and wasted storage.
  2. Dependency: Normalization helps ensure that data dependencies make sense, i.e., the values of attributes in a table depend on the primary key.
  3. Relationships: Normalization facilitates establishing relationships among different entities (tables) in the database.
- Normal Forms
  - Normalization generally consists of several normal forms (NF), with the most common being:
    1. First Normal Form (1NF)
    2. Second Normal Form (2NF)
    3. Third Normal Form (3NF)
    4. Boyce-Codd Normal Form (BCNF)
    5. Fourth Normal Form (4NF)
    6. Fifth Normal Form (5NF)
    - Let's explore each normal form in detail with examples.

      - Example Scenario
         - Consider a database for a school that initially has a single table to store information about students, their courses, and instructors:

                  Initial Table: Student_Courses
                  ID	Student_Name	Course_ID	  Course_Name	Instructor_Name
                  1	       Alice	    C001	        Mathematics	    Dr. Smith
                  1        Alice	    C002	        Physics	        Dr. Johnson
                  2	       Bob	        C001	        Mathematics    	Dr. Smith
                  2	       Bob	        C003	        Chemistry	    Dr. Lee
                  3	       Charlie	    C002	        Physics	        Dr. Johnson
                  3	       Charlie	    C003	        Chemistry	    Dr. Lee
         1. First Normal Form (1NF)
            - Definition: A table is in 1NF if: All attributes contain only atomic (indivisible) values.
            - Each record is unique.
            - Issues: The initial table contains repeating groups (one student can have multiple courses).
            - Transformation to 1NF: 
              1. To convert to 1NF, we need to ensure that all values are atomic and that we remove any repeating groups. 
              2. In our case, the initial table already meets the 1NF criteria because it has no repeating groups, and each entry is unique.

         2. Second Normal Form (2NF)
            - Definition: A table is in 2NF if:
               1. It is in 1NF.
               2. All non-key attributes are fully functionally dependent on the primary key.
            - Issues:
               1. In the current table, Course_Name and Instructor_Name depend only on Course_ID, not on the combination of Student_ID and Course_ID.
            - Transformation to 2NF: 
               1. To convert to 2NF, we need to eliminate partial dependencies by creating separate tables.
            - New Tables for 2NF
           
                    1. Student Table
                        Student_ID	Student_Name
                        1	        Alice
                        2	        Bob
                        3	        Charlie
        
                    2. Course Table
                        Course_ID	Course_Name	Instructor_Name
                        C001	    Mathematics	 Dr. Smith
                        C002	    Physics	     Dr. Johnson
                        C003	    chemistry	 Dr. Lee
                
                    3. Student_Course Table
                        Student_ID	Course_ID
                        1	             C001
                        1	             C002
                        2	             C001
                        2	             C003
                        3	             C002
                        3	             C003

         3. Third Normal Form (3NF)
             - Definition: A table is in 3NF if:
             1. It is in 2NF.
             2. There are no transitive dependencies (non-key attributes should not depend on other non-key attributes).
             - Issues: In the Course table, Instructor_Name depends on Course_Name, which is a non-key attribute.
             - Transformation to 3NF: To eliminate transitive dependencies, we create a separate table for instructors.
             - New Tables for 3NF
           
                    1. Student Table (remains unchanged)
                        Student_ID	Student_Name
                        1	            Alice
                        2	            Bob
                        3	            Charlie
                      
                       2. Course Table (updated)
                           Course_ID	Course_Name
                           C001	     Mathematics
                           C002	     Physics
                           C003	     Chemistry
            
                       3. Instructor Table
                           Instructor_ID	Instructor_Name
                           1	             Dr. Smith
                           2	             Dr. Johnson
                           3	             Dr. Lee
            
                       4. Course_Instructor Table
                           Course_ID	Instructor_ID
                           C001	     1
                           C002	     2
                           C003	     3
            
                       5. Student_Course Table (updated)
                           Student_ID	Course_ID
                           1	             C001
                           1	             C002
                           2	             C001
                           2	             C003
                           3	             C002
                           3	             C003
            
         4. Boyce-Codd Normal Form (BCNF)
             - Definition: A table is in BCNF if:
               1. It is in 3NF.
               2. Every determinant is a candidate key.
             - In our case, all tables satisfy the BCNF condition, so no further changes are needed.

         5. Higher Normal Forms (4NF and 5NF)
             - Fourth Normal Form (4NF) deals with multivalued dependencies. If a table has multiple independent multivalued facts about an entity, it should be separated into different tables.
             - Fifth Normal Form (5NF) deals with cases where information can be reconstructed from smaller pieces of information. It ensures that data is decomposed to eliminate redundancy and maintain data integrity.
- In our school database scenario, the structure is sufficiently normalized to 3NF or BCNF, and higher normal forms are not necessary based on the provided data.

- Benefits of Normalization
1. Reduces Data Redundancy: Avoids duplicate data and inconsistency.
2. Improves Data Integrity: Ensures that data is accurate and consistent across the database.
3. Enhances Query Performance: Smaller tables can improve performance for certain queries.
4. Easier Maintenance: Simplifies updates and deletions, as changes are made in one place rather than multiple. 
- Drawbacks of Normalization
1. Complex Queries: May lead to more complex SQL queries due to the need for joins between multiple tables.
2. Performance Overhead: For read-heavy applications, normalization can lead to performance issues because of the additional joins required to retrieve data.
- Conclusion
1. Database normalization is a critical process in database design that helps create efficient, reliable, and consistent databases. 
2. By understanding the normal forms and their implications, you can design databases that are robust and well-structured, 
3. making them easier to maintain and scale in the long run.
4. In interviews, be prepared to discuss the different normal forms, their definitions, and real-world scenarios where you might apply them.