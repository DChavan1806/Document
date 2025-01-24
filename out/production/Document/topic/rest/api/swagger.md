- In Spring Boot, Swagger is used to automatically generate API documentation for RESTful web services. 
- Swagger simplifies API development by providing a way to describe the structure of your APIs, 
- and it allows developers and consumers to easily understand and interact with the API through a UI interface called Swagger UI.

- To integrate Swagger into a Spring Boot application, you can use SpringFox or OpenAPI 3.0 (now recommended). 
- Here’s how you can set it up using OpenAPI/Swagger 3.0:

- Steps to Set Up Swagger in Spring Boot:

`  implementation 'io.springfox:springfox-swagger2:2.9.2'
  implementation 'io.springfox:springfox-swagger-ui:2.9.2'`
  
- Access the Swagger UI After running your Spring Boot application, Swagger UI will be available at the default endpoint:
- http://localhost:8080/swagger-ui.html
- Customizing the OpenAPI Documentation You can use the @Operation and @ApiResponse annotations to add additional documentation for each API method:
    `@RestController
    @RequestMapping("/api")
    public class UserController {
    
        @Operation(summary = "Get a user by ID")
        @ApiResponse(responseCode = "200", description = "Found the user", 
            content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = User.class)) })
        @ApiResponse(responseCode = "404", description = "User not found")
        @GetMapping("/users/{id}")
        public User getUserById(@PathVariable Long id) {
            // Method implementation
        }
    }`

- Swagger 2 : [SwaggerConfig.java](../../java/com/sdc/config/SwaggerConfig.java) not supported in 3.3.4
- YAML or JSON Specification You can generate the API documentation in either JSON or YAML format by accessing:
- http://localhost:8080/v3/api-docs      (for JSON)
- http://localhost:8080/v3/api-docs.yaml (for YAML)
- Benefits of Using Swagger:
  1. Interactive API Documentation: Swagger UI provides a live documentation where you can test API endpoints.
  2. Client Code Generation: Swagger allows automatic generation of client SDKs in different programming languages using OpenAPI specifications.
  3. Clear Communication: It provides clear documentation for frontend and backend developers, making collaboration smoother.
  4. Would you like to explore advanced Swagger configuration or specific features?