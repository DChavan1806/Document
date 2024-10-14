- @SpringBootApplication (@Configuration, @EnableAutoConfiguration, @ComponentScan)
- SpringApplication.run():
  1. application context kickoff which turn searches for classes annotated with @configuration
  2. check application type (web, standalone)
  3. initialize all declared beans in those configuration classes and store those bean in jvm(IOC container)
  4. after creation of bean automatically configures the dispatcher servlet 
     and register the default handler mappings, message converts and all other basic things.
  5. create instance of TomcatEmbeddedServletContainer and  add the context (to run application locally)

- The main method in a Spring Boot application serves a dual purpose:
 1. Development and Local Testing:
    - During development, the main method allows developers to run the application locally. 
    - This enables quick testing and debugging of features before deployment. Developers can easily start and stop the application to see changes in real time.
 2. Production Execution:
 - In a production environment, the main method is also crucial. When deploying a Spring Boot application as a standalone JAR (Java Archive),
  the main method serves as the entry point for the Java Virtual Machine (JVM) to start the application. 
 - This means that whether you're running it locally or on a production server, the same main method is invoked.

- Key Points
1. Standalone Applications: Spring Boot applications are often packaged as executable JARs. The main method facilitates this by allowing the JAR to be executed directly with a command like java -jar your-application.jar.
2. Spring Boot Starter: The main method initializes the Spring application context, autoconfiguration, and other essential components of the application, making it ready for use in any environment.
3. Containerized Deployments: When deploying applications in a container (e.g., Docker), the main method remains the entry point, but it can be configured to run in various environments with different properties or profiles.
