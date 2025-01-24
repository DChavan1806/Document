- Spring MVC (Model-View-Controller) is a powerful framework for building web applications in Java. 
- It separates the application into three interconnected components: Model, View, and Controller. 
- This separation helps organize code and promotes maintainability and testability. Below is a detailed explanation of the flow of a Spring MVC application:

- Flow of Spring MVC
  1. Client Request:
    - A client (usually a web browser) sends an HTTP request to the server. This request typically targets a specific URL that corresponds to a resource in the application.

  2. DispatcherServlet:
    - The request is received by the DispatcherServlet, which is the central component of Spring MVC. It acts as the front controller and is responsible for processing all incoming requests.
    - The DispatcherServlet is configured in the web application's web.xml file or through Java configuration using @EnableWebMvc.

  3. Handler Mapping: 
    - The DispatcherServlet uses handler mappings to determine which controller should handle the incoming request. It checks the request URL against the mappings defined in the application.
    - Each controller method is mapped to a specific URL using annotations like @RequestMapping.

  4. Controller: 
    - Once the appropriate controller is identified, the DispatcherServlet forwards the request to that controller.
    - The controller processes the request, often interacting with the service layer or retrieving data from the database through the model.

  5. Model and View:
    - The controller prepares a model (data) to be returned to the view. The model typically consists of data required for rendering the view.
   - The controller also determines which view should be rendered based on the request.

  6. View Resolver:
    - The DispatcherServlet uses a view resolver to map the logical view name returned by the controller to an actual view implementation (e.g., JSP, Thymeleaf).
   - The view resolver checks the configuration to find the appropriate view (like ViewResolver or ThymeleafViewResolver).

  7. Render the View:
    - The selected view is rendered with the model data provided by the controller. The view can access the model attributes using expression language (e.g., ${attributeName} in JSP or Thymeleaf).
    - The view generates the final HTML response.
  8. Send Response:
    - The generated HTML response is sent back to the client through the DispatcherServlet.
    - The client (web browser) receives the response and displays the rendered view to the user.

    Client   --> DispatcherServlet: HTTP Request
    DispatcherServlet --> Handler Mapping: Find Controller
    Handler Mapping --> DispatcherServlet: Controller
    DispatcherServlet --> Controller: Call Controller Method
    Controller --> Service/Model: Process Logic & Get Data
    Controller --> DispatcherServlet: Return Model & View
    DispatcherServlet --> View Resolver: Find View
    View Resolver --> DispatcherServlet: Return View
    DispatcherServlet --> View: Render View with Model
    View --> DispatcherServlet: HTML Response
    DispatcherServlet --> Client: Send HTML Response


- Client Request: The user navigates to /books to view the list of books.
- DispatcherServlet: Receives the request and forwards it to the appropriate controller.
- Handler Mapping: Matches the URL /books to the BookController.
- Controller: The BookController fetches the list of books from the service layer.
- Model and View: The controller adds the list of books to the model and returns the view name bookList.
- View Resolver: Resolves bookList to the corresponding JSP or Thymeleaf template.
- Render the View: The view template renders the list of books in HTML.
- Send Response: The rendered HTML is sent back to the client, which displays it in the browser.
