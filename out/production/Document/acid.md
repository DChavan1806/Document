- ACID is a set of properties that guarantee the reliable processing of database transactions.
- These properties ensure data integrity, consistency, and isolation during transactions, 
- particularly in systems with concurrent access or when failures occur.
  - Let's break down each property in detail:
      1. Atomicity : 
           - Atomicity ensures that each transaction is treated as a single "atomic" unit, 
           - meaning either all the operations in a transaction are completed successfully, or none of them are.
           - Explanation: 
                - A transaction may consist of several operations (e.g., updating multiple rows, deleting records). 
                - Atomicity ensures that the transaction either fully succeeds or fully fails. There are no partial changes left in the database.
                - If any part of the transaction fails (due to power failure, system crash, etc.), the entire transaction is rolled back, 
                - and the database is restored to its previous state, as if the transaction never happened.
           - Example:

                  Imagine a bank transaction where $100 is being transferred from Account A to Account B:
                  Subtract $100 from Account A.
                  Add $100 to Account B.
           - If the subtraction from Account A succeeds but adding to Account B fails (e.g., due to a system crash), atomicity ensures that the deduction from Account A is rolled back.
           - Real-world Scenario: In a flight booking system, if a user books a ticket, the payment must be processed, and the seat must be reserved. If the payment is successful but the seat reservation fails, the entire transaction (including payment) is rolled back.

      2. Consistency
            - Consistency ensures that a transaction brings the database from one valid state to another, 
            - maintaining all predefined rules, constraints, and triggers. 
            - In other words, the database should remain in a consistent state before and after the transaction.
            - Explanation: 
              - Before and after a transaction, the database must meet all integrity constraints (e.g., foreign keys, unique keys, NOT NULL constraints). 
              - If a transaction violates any constraints or integrity rules, it is aborted, and the database is rolled back to the state before the transaction started.
            - Example:
              - Suppose a table has a constraint that requires a salary column to have only positive values.
              - If a transaction tries to insert or update a record with a negative salary, the transaction will fail and be rolled back, maintaining the consistency of the data.
            - Real-world Scenario: In an e-commerce platform, suppose a rule exists that the total quantity of items in an order must be positive. 
            - If a transaction attempts to deduct an item, leaving a negative stock quantity, 
            - the consistency property will reject the transaction and revert the system to the previous state.

      3. Isolation :
            - Isolation ensures that transactions are executed independently, without interference from other concurrent transactions. 
            - Even if multiple transactions are happening simultaneously, each transaction should appear as if it's running alone.
            - Explanation:
                - When multiple transactions are running concurrently, isolation ensures that intermediate states of a transaction are invisible to others. 
                - It avoids dirty reads, non-repeatable reads, and phantom reads (common concurrency issues).
                - The degree of isolation can vary based on isolation levels (e.g., READ UNCOMMITTED, READ COMMITTED, REPEATABLE READ, and SERIALIZABLE).
            - Example: 
                - Suppose Transaction 1 is updating the salary of an employee, and at the same time, 
                - Transaction 2 is reading the salary of the same employee.
                - Isolation ensures that Transaction 2 either sees the old salary (before the update) or the new salary (after the update is committed), but not an intermediate value.
            - Real-world Scenario: In an online shopping system, two users (transactions) might try to purchase the last item in stock at the same time. Isolation ensures that only one transaction is allowed to complete, and the stock count will be consistent and not oversold.

      4. Durability
            - Durability guarantees that once a transaction has been committed, 
            - the changes made by the transaction are permanent, 
            - even in the event of a system crash, power failure, or any other failure.
            - Explanation: 
                - After a transaction is committed, the data is written to persistent storage (e.g., disk). 
                - Even if the database or server crashes after the transaction is committed, 
                - the changes will remain intact once the system is restored.
                - This is often achieved through techniques like write-ahead logging (WAL), 
                - where changes are first written to a log, and then applied to the database.
            - Example:
                - After a user transfers $100 from Account A to Account B and the transaction is committed, 
                - the change (both the deduction from Account A and the addition to Account B) will persist, 
                - even if the database server crashes immediately afterward.
            - Real-world Scenario: In an airline reservation system, once a booking is confirmed (i.e., transaction committed), i
            - t is stored durably so that, even if there is a server failure, the booking will not be lost, and the seat remains reserved.

- ACID Properties in a Practical Example:
     - Consider a banking system where a user is transferring money from one account to another. 
     - Let's see how each ACID property applies:
        1. Atomicity: The transfer of money involves two operations—debiting the sender’s account and crediting the recipient’s account. If either operation fails (say, crediting fails), the entire transaction is rolled back to ensure no partial debit or credit occurs.
        2. Consistency: The balance of the sender’s account must not go below zero (a rule in the system). If the transaction violates this rule, it is aborted, and the database returns to the consistent state where both accounts have valid balances.
        3. Isolation: If another transaction is running simultaneously (e.g., the user checks their balance while the transfer is occurring), the user should either see the balance before or after the transfer, but not during the transfer (to avoid seeing an intermediate or incorrect balance). 
        4. Durability: Once the transaction is committed, even if the banking server crashes right afterward, the transaction (transfer) is saved permanently, and both accounts will reflect the updated balances when the system is back online.

- ACID in Modern Databases
     - Relational databases like MySQL, PostgreSQL, Oracle, and SQL Server fully adhere to ACID properties.
     - NoSQL databases such as MongoDB, Cassandra, and others may relax some ACID properties (especially isolation and consistency) for the sake of scalability and performance in distributed environments. However, many NoSQL databases now offer ACID-compliant features for transactions across multiple documents/records.
- Conclusion
    - The ACID properties ensure that database transactions are processed reliably and maintain data integrity, even in systems with high concurrency or unexpected failures. In interviews, being able to explain and understand the importance of each ACID property is crucial for roles that involve database management, especially when dealing with transactional systems.

------ 
- The CAP theorem (also known as Brewer's theorem) is a fundamental principle that applies to distributed data systems. 
- It was formulated by Eric Brewer in 2000 and states that it is impossible for a distributed data store to simultaneously 
  - provide all three of the following guarantees:
    1. Consistency (C): 
        - Every read receives the most recent write or an error. 
        - In other words, all nodes in the distributed system have the same data at the same time. 
        - If a system is consistent, it ensures that once a write operation is acknowledged, all subsequent reads will reflect that write.
    2. Availability (A): 
        - Every request (read or write) receives a response, regardless of whether it was successful or not. 
        - This means the system is operational and responsive, even if some nodes are down. 
        - An available system ensures that all nodes respond to requests, but not necessarily with the latest data.
    3. Partition Tolerance (P): 
        - The system continues to operate despite arbitrary partitioning due to network failures. 
        - This means that even when communication between nodes is disrupted (e.g., due to network issues), 
        - the system remains functional.

- The CAP Trade-offs
- The CAP theorem states that a distributed system can only provide at most two of the three guarantees at the same time. 
- Here’s how it breaks down:
   1. CP (Consistency and Partition Tolerance): In a CP system, consistency is prioritized over availability. 
        - If there’s a partition in the network, some nodes may become unavailable to ensure that all remaining nodes have consistent data. 
        - An example of this is a database that won’t return data until it can ensure all nodes agree on the data.
   2. AP (Availability and Partition Tolerance): 
        - In an AP system, availability is prioritized over consistency. 
        - This means that even if there’s a network partition, the system will continue to respond to requests, 
        - but it may return stale or inconsistent data. Examples include distributed databases like Cassandra or DynamoDB that allow for eventual consistency.
   3. CA (Consistency and Availability): 
        - A system can achieve both consistency and availability only in a non-partitioned environment. 
        - However, in the real world, network partitions can and do occur, making this scenario impractical for distributed systems.

- Visual Representation

                |-- CP (Consistency + Partition Tolerance)
                |
                |                       |
                |                       |
           ---- C ----             ---- A ----
                |                       |
                |                       |
                |-- AP (Availability + Partition Tolerance)
- Real-World Implications
- Understanding the CAP theorem helps architects and developers make informed choices about database and system design, particularly regarding:
1. Choosing the right database based on application requirements. For example, if a system needs to handle high availability but can tolerate eventual consistency, an AP system might be preferred.
2. Designing for failure. Knowing that partitions will happen, developers can build systems that are resilient and can handle data inconsistencies gracefully.

Summary
The CAP theorem is a critical concept in distributed systems, emphasizing the trade-offs between consistency, availability, and partition tolerance. When designing distributed systems, understanding these trade-offs is essential for achieving the desired balance based on application needs.