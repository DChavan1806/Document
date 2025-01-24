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
- Spring Data JPA is a part of the larger Spring Data family, designed to simplify data access in Spring applications by reducing the amount of boilerplate code required for database operations. 
- It builds on top of JPA (Java Persistence API), making it easier to work with relational databases.
- Spring Data JPA allows developers to focus on the core business logic by abstracting data access layers and providing repository support for standard CRUD operations and complex queries.

- Key Features of Spring Data JPA:
  1. Repository Abstraction: Provides a repository model for data access with the CrudRepository, PagingAndSortingRepository, and JpaRepository interfaces.
  2. Automatic Query Generation: You can define method signatures in your repository interfaces, and Spring Data JPA will automatically generate the corresponding SQL queries.
  3. Custom Queries: It supports defining custom queries using the @Query annotation or JPQL (Java Persistence Query Language).
  4. Pagination and Sorting: Built-in support for pagination and sorting by extending PagingAndSortingRepository.
  5. Auditing: Automatically tracks entity changes like creation, updates, etc., using annotations like @CreatedDate and @LastModifiedDate.
  6. Specifications: Helps with dynamic queries by using the Specification interface.
  7. Transaction Management: Provides seamless integration with Spring's transaction management capabilities using @Transactional.
- Common Annotations:
  1. @Entity: Marks a class as a JPA entity.
  2. @Id: Defines the primary key of an entity.
  3. @GeneratedValue: Specifies how the primary key should be generated.
  4. @OneToMany, @ManyToMany, @ManyToOne, @OneToOne: Define relationships between entities.
  5. @Repository: Marks a class as a Data Access Object (DAO) that will be auto-wired by Spring.
  6. @Query: Allows for defining custom queries with JPQL or native SQL.
- Example Usage:

        @Entity
        public class User {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
                private String name;
                private String email;
                // Getters, Setters, Constructors, etc.
            }

      @Repository
      public interface UserRepository extends JpaRepository<User, Long> {
          // Automatically generates a query by parsing the method name
          List<User> findByName(String name);

          // Custom query with JPQL
          @Query("SELECT u FROM User u WHERE u.email = ?1")
          User findByEmail(String email);
      }
       
      @Service
      public class UserService {
          @Autowired
          private UserRepository userRepository;
          public List<User> getUsersByName(String name) {
              return userRepository.findByName(name);
          }
          public User getUserByEmail(String email) {
              return userRepository.findByEmail(email);
          }
      }
- Spring Data JPA significantly simplifies database interaction in Java applications, letting you focus more on business logic than data access boilerplate.
- How to configure 2 different database or same database with different ip?
- [FirstDataSourceConfig.java](../program/FirstDataSourceConfig.java)
- [SecondDataSourceConfig.java](../program/SecondDataSourceConfig.java)
    - [appliacation2datasource.yml](../program/appliacation2datasource.yml)

          @Configuration
          @EnableJpaRepositories(
              basePackages = "com.example.repository.postgresql", // Change to your PostgreSQL repository package
              entityManagerFactoryRef = "postgresqlEntityManagerFactory",
              transactionManagerRef = "postgresqlTransactionManager"
          )

           @Bean(name = "postgresqlDataSource")
          @ConfigurationProperties(prefix = "spring.datasource.postgresql")
          public DataSource postgresqlDataSource() {
              return DataSourceBuilder.create().build();
          }

          @Bean(name = "postgresqlEntityManagerFactory")
          public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("postgresqlDataSource") DataSource dataSource) {
          return builder
              .dataSource(dataSource)
              .packages("com.example.model.postgresql") // Change to your PostgreSQL model package
              .persistenceUnit("postgresql")
              .build();
          }

          @Bean(name = "postgresqlTransactionManager")
          public DataSourceTransactionManager postgresqlTransactionManager(
          @Qualifier("postgresqlDataSource") DataSource dataSource) {
              return new DataSourceTransactionManager(dataSource);
          }
- composite pk with jpa
  1. Using @IdClass : 
     The @IdClass annotation is used when you want to define a composite key class separately from the entity. This class should implement Serializable and contain the fields of the composite key.
             
            //setter
            //constructor
            //toString:tohash
            import java.io.Serializable;
            import java.util.Objects;
            public class OrderId implements Serializable {
                private Long orderId;
                private Long productId;
            }

            @Entity
            @IdClass(OrderId.class)
            public class Order {
                @Id
                private Long orderId;
                @Id
                private Long productId;
                private int quantity;
                // Getters, Setters
            }
  2. Using @EmbeddedId
            
            //setter
            //constructor
            //toString:tohash
            import java.io.Serializable;
            import java.util.Objects;
            @Embeddable
            public class OrderId implements Serializable {
               private Long orderId;
               private Long productId;
            }

            @Entity
            @IdClass(OrderId.class)
            public class Order {
                 @EmbeddedId
                 private OrderId id;
                 private int quantity;
                // Getters, Setters
            }
