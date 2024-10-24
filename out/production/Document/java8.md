- Java 8 introduced several significant features and enhancements to the Java programming language and the Java platform. 
- Here’s a summary of the most notable features:
1. Lambda Expressions : 
   - Description: Allows you to write concise and expressive code using function-like syntax.
   - Advantages of Lambda Expressions
       1. **Concise and readable**: Reduce the boilerplate code associated with anonymous inner classes.
       2. **Enables functional programming**: Java becomes more functional and can handle operations like filtering, mapping, and reducing in a declarative way.
       3. **Better support for parallel operations**: Lambda expressions work well with the Streams API, which supports parallel processing easily.

         list.forEach(item -> System.out.println(item));
   -  Limitations
      Complexity in debugging: Since lambdas are anonymous and don't have a name or location, debugging complex lambdas can sometimes be difficult.
      Performance: In some cases, lambdas might introduce performance overhead, especially if used in highly performance-sensitive applications, though in general, they are efficiently handled by the JVM.
   - Lambda expressions are most commonly used in:
     1. **Event handling**: Instead of anonymous classes in GUI programming.
     2. **Collection processing**: Simplified operations like filter, map, and reduce on collections.
     3. **Asynchronous programming**: Passing lambda expressions to callbacks or event listeners

2. Functional Interfaces
   Description: An interface with a single abstract method, which can be represented as a lambda expression.
   Common Functional Interfaces: java.util.function -> @functionalInterface -> single abstract api
   - q1. Can we use lambda expressions with any interface?
   - q2. Differance between runnable and callable

           Runnable           : void run() - not input - no output -> only handled unchecked exception -> not result -> used with tread and Excuter service
           Callable.          : V call() - throws the exception - > handle both checked and unchecked exception -> use Future<V> to retrive result -> used with excuter service only
           Consumer<T>        : Represents an operation that takes an argument and returns no result (T -> void) : Consumer<String> print = System.out::println;
           Supplier<T>.       : Represents a function that takes no input and returns a result (no input -> T) : Supplier<Double> randomValue = () -> Math.random();
           Function<T, R>     : Takes an input and produces an output (T -> R) : Function<String, Integer> strLength = str -> str.length();
           Predicate<T>       : Represents a function that accepts one argument and returns a boolean : Predicate<Integer> isEven = num -> num % 2 == 0;
           UnaryOperator<T>   : A function that takes one argument and returns a result of the same type (T -> T) : UnaryOperator<Integer> square = x -> x * x;
           BiFunction<T, U, R>: Takes two arguments and returns a result (T, U -> R) : BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
           BinaryOperator<T>  : Takes two arguments of the same type and returns a result of the same type (T, T -> T) : BinaryOperator<Integer> multiply = (a, b) -> a * b;

3. Streams API: 
   [stream-api.md](stream-api.md)
   Description: Provides a way to process sequences of elements (collections) in a functional style, supporting operations such as filter, map, and reduce.

       List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
       names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

4. Default Methods in Interfaces
   Description: Allows interfaces to have method implementations (default methods), enabling the addition of new methods to interfaces without breaking existing implementations.
   
       interface MyInterface {
       default void myDefaultMethod() {
       System.out.println("Default method implementation");
       }
       }
   - q. how default with same name in differ interface work when concrete class implement both interface
     [DefaultMethod.java](program/DefaultMethod.java)

5. Method References
   Description: A shorthand notation of a lambda expression to call a method. They provide a way to refer to methods without invoking them.
   
       List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
       names.forEach(System.out::println); // Method reference instead of lambda
   - q. what purpose methode reference in java8 : 

6. Optional Class
   Description: A container object that may or may not contain a non-null value, used to avoid null references and NullPointerExceptions.

       Optional<String> optionalName = Optional.ofNullable(name);
       optionalName.ifPresent(System.out::println);

7. New Date and Time API
   Description: Introduces a new set of classes for date and time manipulation, 
   Providing better handling and more features than the old java.util.Date and java.util.Calendar.
   
       LocalDate date = LocalDate.now();
       LocalDate nextWeek = date.plusWeeks(1);
   - [New-Date-and-Time-API.md](New-Date-and-Time-API.md)

8. Nashorn JavaScript Engine
   Description: A new lightweight JavaScript engine that allows for executing JavaScript code within Java applications, replacing the older Rhino engine.
   
       ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
       engine.eval("print('Hello from JavaScript');");

9. CompletableFuture and Concurrency Enhancements
   Description: Introduces the CompletableFuture class for better asynchronous programming, allowing non-blocking and functional-style completion handling.
   
       CompletableFuture.supplyAsync(() -> {
       // some long-running task
       return "Result";
       }).thenAccept(result -> System.out.println(result));

10. Parallel Operations
    - Description: The Streams API supports parallel processing with the parallelStream() method, enabling easy parallelism for performance improvements.
    - Parallel operations in Java refer to the ability to execute multiple tasks concurrently, leveraging multicore processors to improve performance. 
    - The Java 8 Streams API introduced built-in support for parallel processing, enabling parallel operations on collections, arrays, or other data sources. 
    - This feature is particularly useful when you need to process large amounts of data and improve the throughput of applications.
    
           System.out.println("\nParallel Stream:");
           numbers.parallelStream().forEach(num -> System.out.println(num + " - " + Thread.currentThread().getName()));
            outbut: 
            1 - ForkJoinPool.commonPool-worker-1
            2 - ForkJoinPool.commonPool-worker-3
            3 - ForkJoinPool.commonPool-worker-2
    - Key Concepts
      1. Sequential Stream: Processes elements one at a time, in a single thread.
         `stream()`
      2. Parallel Stream: Splits the stream into multiple parts, processes each part in a separate thread, and combines the results. It enables parallelism with minimal effort.
         `parallelStream()`
      3. Fork/Join Framework: Used internally by parallel streams for splitting and merging tasks. It is part of the java.util.concurrent package and allows for work-stealing algorithms to optimize thread usage.
    - When to use Parallel Streams:
      1. Large data sets: Parallel streams are efficient when working with large collections or arrays.
      2. Multi-core processors: They leverage multiple cores to improve performance.
      3. CPU-bound tasks: Best suited for CPU-intensive operations like mathematical computations, transformations, etc.
    - When to avoid Parallel Streams:
      1. Small data sets: The overhead of managing threads can outweigh the benefits for small collections.
      2. I/O-bound tasks: Parallel streams may not significantly improve I/O-bound operations (e.g., network requests, file I/O).
      3. Shared mutable state: Parallel streams can lead to thread-safety issues if working with shared mutable data.
    - q1. How do you control the size of the ForkJoinPool used by parallel streams?
    - Answer: By default, parallel streams use the common ForkJoinPool, which is determined by the number of available processors (usually Runtime.getRuntime().availableProcessors()). 
       
          You can set the size of the pool using the system property:
          System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
11. file related changes : 
     [java8withfile.md](java8withfile.md)


- Summary
    Java 8 brought substantial improvements to the Java programming language, 
    making it more functional and expressive. The introduction of lambda expressions, 
    the Streams API, and the new Date and Time API are some of the most significant features that greatly enhance the way Java developers write and maintain code.