- Spring Boot simplifies database interactions by providing a comprehensive and automatic configuration setup. 
- Dependencies
  - To use Spring Boot with a MySQL database, you typically need the following dependencies in your pom.xml (for Maven) or build.gradle (for Gradle)
    `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'mysql:mysql-connector-java'`
- Internal Working
   - When you run a Spring Boot application with the above configuration:
     1. Auto-Configuration: Spring Boot scans the classpath for the necessary dependencies and autoconfigures the application context based on the provided properties. 
        The presence of **spring-boot-starter-data-jpa** triggers the configuration of JPA-related beans.
     2. DataSource Creation: Spring Boot creates a DataSource bean using the database connection properties. 
        The **DriverManagerDataSource** is typically used, configured with the driver class name, URL, username, and password.
     3. EntityManagerFactory: Spring Boot sets up an **EntityManagerFactory** using the configured **DataSource** and **Hibernate** settings. 
        This factory is responsible for creating **EntityManager** instances, which are used for interacting with the database.
     4. Transaction Management: Spring Boot automatically configures transaction management using @**EnableTransactionManagement**, allowing for declarative transaction management using the @**Transactional** annotation.
     5. Repository Support: With the **spring-boot-starter-data-jpa** dependency, you can define JPA repositories by extending **JpaRepository**. 
        **Spring Data** JPA automatically implements the methods at runtime.
     6. Automatic Schema Updates: The ddl-auto=update configuration enables automatic schema generation and updates based on the entity classes. 
        When the application starts, Hibernate checks the current schema against the entity definitions and applies necessary changes.
- Entity [Ticket.java](../../java/com/sdc/model/Ticket.java)
- Repository [TicketDao.java](../../java/com/sdc/dao/TicketDao.java)

- How to configure 2 different database or same database with different ip?
  