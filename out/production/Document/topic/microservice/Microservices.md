What is microservice : 
- A microservice is an architectural style that structures an application as a collection of loosely coupled services. 
- Each service is designed to perform a specific business function and can be developed, deployed, and scaled independently. 
- Microservices design pattern : [microservices-design-pattern.md](microservices-design-pattern.md)
- Here are some key characteristics of microservices:
     1. Independent Deployment: Each microservice can be deployed independently, allowing for more flexible and frequent releases without affecting the entire application.
     2. Decentralized Data Management: Microservices often manage their own database or data store, promoting data encapsulation and reducing dependencies between services.
     3. Technology Agnostic: Different microservices can be developed using different programming languages, frameworks, and technologies, allowing teams to choose the best tools for their specific requirements.
     4. Inter-Service Communication: Microservices communicate with each other over well-defined APIs, commonly using protocols like HTTP/REST, gRPC, or messaging queues.
     5. Scalability: Individual services can be scaled independently based on their specific demands, allowing for more efficient resource utilization.
     6. Resilience: The failure of one microservice does not necessarily lead to the failure of the entire application, as other services can continue to operate.
     7. DevOps and Continuous Delivery: Microservices are often associated with DevOps practices, enabling automated testing, continuous integration, and continuous delivery.
     8. Domain-Driven Design: Microservices often align with business capabilities or domains, making it easier to understand and develop them in terms of business needs.

- Microservices architecture is particularly useful for complex applications where rapid development, scalability, and maintainability are essential.
 However, it also introduces challenges such as managing distributed systems, ensuring data consistency, and handling inter-service communication.

- Problem with Monolithic Architecture :
  - single db(performance decreases)
  - single entry for all services(performance).
  - need deploy all service/modules as single package(difficult adopt new technology). 
  - overloaded web container 
  - Error Propagation will impact all Application
  - code maintenance and code readability 
  - Testing
- Pros of Microservices:
 1. Scalability: Individual services can be scaled independently, optimizing resource usage based on traffic. Helps handle varying loads for different components.
 2. Flexibility in Technology: Each microservice can use a different tech stack that best suits its requirements. You can leverage specialized tools and libraries for different services.
 3. Independent Development and Deployment: Teams can work on different microservices simultaneously without affecting others, leading to faster development.
    Services can be updated, deployed, and scaled independently without redeploying the whole application.
 4. Fault Isolation: Issues in one service don’t directly affect the others. This isolation improves the overall reliability and uptime of the system.
 5. Better Organization Around Business Capabilities: Services are aligned to business functions, making it easier to make changes that are scoped to business requirements.
 6. Continuous Delivery: You can deliver new features and updates more rapidly due to the modular nature of microservices, supporting continuous integration and delivery (CI/CD) pipelines.
 7. Resilience and Fault Tolerance: Microservices are often deployed with redundancy and can be designed for greater fault tolerance through techniques like circuit breaking, retries, and graceful degradation.
 8. Easy Maintenance and Updates: Small, focused services are easier to understand, maintain, and update over time compared to a monolithic application.

- Cons of Microservices:
  1. Complexity in Management: Managing multiple services can be complex. You'll need proper orchestration, monitoring, and management tools (like Kubernetes, ELK, or Prometheus).
  2. DevOps effort is higher, requiring containerization, orchestration, and network management.
  3. Communication Overhead: Microservices often rely on network communication (usually via APIs). This introduces latency and increases the likelihood of network failures.
  4. Additional security concerns arise from external communication.
  5. Data Consistency Challenges: Since microservices manage their own databases, maintaining data consistency across the system is harder compared to a monolithic system where everything uses a single database.
     You may need to employ eventual consistency models or distributed transactions, which are more complex.
  6. Distributed Systems Complexity: Microservices architecture introduces the complexities of distributed systems, such as handling distributed transactions, fault tolerance, and service discovery.
     Requires dealing with eventual consistency, retries, message queues, etc.
  7. Increased Resource Usage: Running many small services, each with its own memory footprint, requires more resources compared to running a single monolithic application.
     This could lead to higher operational costs, especially in terms of cloud infrastructure.
  8. Deployment Overhead: Managing and deploying multiple services (especially when dependencies exist) requires to be sophisticated CI/CD pipelines and deployment automation.
  9. Testing Challenges: Testing individual services is easier, but integration testing across multiple services is more complicated.
     You need to ensure proper coordination and consistency in the behavior of microservices during testing.
  10. Security Concerns: Microservices often communicate over public or private networks, making them vulnerable to attacks. This increases the need for robust security policies like authentication, encryption, and authorization between services.
  11. Latency: Service-to-service communication often happens over the network, which can add latency, especially in a highly interdependent architecture.

- How do microservice communicate each other 
  - Microservices communicate with each other through various mechanisms, 
  - depending on the architectural design, requirements, and the level of complexity in the system. 
  - Here are the common methods used for communication between microservices:
  1. Synchronous Communication:
     - Definition: In synchronous communication, a service sends a request to another service and waits for a response before proceeding. This type of communication is blocking; the sender is dependent on the receiver to complete its task.
     - Common Protocols: HTTP/HTTPS (usually via REST or GraphQL), gRPC, SOAP.
     - Use Cases: When the requesting service requires an immediate response to proceed, such as validating user input or fetching data from another service in real-time.
     - [synchronous-communication-methods.md](synchronous-communication-methods.md)
  2. Asynchronous Communication:
     - Definition: In asynchronous communication, the service sends a message to another service and continues processing without waiting for a response. This is non-blocking and more fault-tolerant.
     - Common Protocols: Message brokers like Kafka, RabbitMQ, AWS SQS, and AMQP, Event-driven patterns like WebSockets, and pub/sub (publish-subscribe) architectures.
     - Use Cases: When services don’t need an immediate response or when the request can be processed later (e.g., sending notifications, order processing, logging).
     - [asynchronous-communication-methods.md](asynchronous-communication-methods.md)
  3. Event-Driven Architecture:
     - Definition: Microservices communicate through events where services emit events, and other services subscribe to and respond to those events asynchronously.
     - Event Buses/Streams: Kafka, RabbitMQ, AWS EventBridge.
     - Use Cases: Distributed systems where changes in one service should trigger actions in other services, like in e-commerce (order processing, payment confirmation, etc.).
     - Event-Driven Methods:
       1. Event Notification: A service emits an event to notify others about a state change, such as "order placed" or "user registered".
          Other services that are interested in this event will consume it and perform their logic.
          - Example: When an order is placed, an "order created" event is emitted, and different services (like inventory, billing) act on it.
          - Pros: Highly scalable, loosely coupled services.
          - Cons: Requires careful event schema management, difficult to track events across multiple services.
        2. Event Sourcing: Instead of saving the current state, a service stores all the events that led to the current state. These events are then replayed by other services to derive the current state.
           - Example: Every action in a banking application is stored as an event (e.g., deposit, withdraw), and other services can process these events to calculate balances or generate statements.
           - Pros: Complete history of changes, can replay events to recover lost state.
           - Cons: More complex to implement and manage event stores.
  4. Service Discovery:
     - Definition: In microservices architecture, services may dynamically change (e.g., scaling up or down), so they need a way to discover each other’s locations.
     - Common Tools: Consul, Eureka, Kubernetes, Zookeeper.
     - Use Cases: When the microservices environment is dynamic, and services need to discover available instances without hardcoding addresses.
     - Service Discovery Methods:
       1. Client-Side Discovery: Services query a service registry to find the network locations of available instances. The client makes the request to a known service registry to get the addresses.
          - Example: Service A queries Eureka or Consul to find the address of Service B before making a call.
          - Pros: Simplifies load balancing, decentralized.
          - Cons: Adds complexity to the client.

       2. Server-Side Discovery: A load balancer queries the service registry to find instances and routes the requests to the appropriate service.
          - Example: A load balancer like AWS ELB or NGINX queries Consul or Eureka to route traffic to Service B.
          - Pros: Simplifies the client, better for legacy systems.
          - Cons: Adds a dependency on the load balancer.

  - Choosing Between Communication Methods:
  1. Synchronous (REST/gRPC) is best for simple, immediate request-response needs, but can cause high latency or bottlenecks if a dependent service fails or is slow.
  2. Asynchronous (Message Queues/Event Streams) allows for loose coupling, better resilience, and is preferred when services do not require an immediate response.
  3. Event-Driven architectures are ideal when multiple services need to act on certain state changes or events but do not need immediate acknowledgment.
  - Each method of communication has trade-offs in terms of latency, reliability, complexity, and scalability, so the choice depends on the specific requirements of your microservice architecture.    