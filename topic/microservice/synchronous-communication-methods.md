Synchronous Communication Methods:
1. REST (Representational State Transfer):
   - Based on HTTP/HTTPS
   - Widely used for communication between microservices due to its simplicity and statelessness.
   - Typically, involves JSON data exchanged over HTTP.
   - Example: Service A calls Service B via a REST API to get user data.
   - Pros: Easy to implement, widely supported, platform-independent.
   - Cons: Latency due to waiting for responses, network reliability issues may cause failures.

2. gRPC (Google Remote Procedure Call): 
   - Uses HTTP/2 for transport and Protocol Buffers (protobuf) for efficient serialization.
   - Faster and more efficient than REST, especially for real-time, low-latency communication.
   - Supports bidirectional streaming (both client and server can send/receive data simultaneously).
   - Example: Service A calls Service B using gRPC to stream data for real-time updates.
   - Pros: Low latency, supports streaming, language-agnostic.
   - Cons: More complex, requires more setup compared to REST.
   
3. GraphQL: 
   - Allows clients to specify exactly what data they need, reducing over-fetching or under-fetching data.
   - Useful for querying multiple microservices and aggregating data from different sources.
   - Example: A service may request specific data (e.g. username and email) from a GraphQL endpoint that fetches data from multiple microservices.
   - Pros: Efficient data fetching, flexibility in queries.
   - Cons: Can become complex with multiple services involved.

