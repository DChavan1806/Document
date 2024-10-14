1. **try-with-resources in Java**
   - The try-with-resources statement ensures that the resources (like files, network connections, etc.) are closed automatically after the program is done using them. 
   - It works with any resource that implements the AutoCloseable interface.
        - How it works:
          - When the try-with-resources block completes (whether normally or due to an exception), it automatically calls the close() method on each resource declared in the try block.
          - This feature was introduced in Java 7 and eliminates the need to explicitly close resources like files or streams in the finally block.
               `try (ResourceType resource = new ResourceType()) {
                 // Use the resource
               } catch (ExceptionType e) {
                 // Handle exception
               }`


            try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
       - Here, BufferedReader and FileReader are closed automatically at the end of the block, even if an exception occurs.
   - Advantages:
     1. Automatic resource management: No need for explicit closing, which makes the code cleaner and prevents resource leaks.
     2. Simplifies exception handling: The automatic closing of resources works even if exceptions are thrown within the try block.

2. catch with Multiple Exceptions
In Java 7, the ability to catch multiple exceptions in a single catch block was introduced. This feature is useful when multiple exceptions are handled in the same way. It helps reduce code duplication.

How it works:
Multiple exceptions can be caught using a single catch block by separating the exception types with the | (pipe) symbol.
The exceptions should not have a parent-child relationship, i.e., you can't catch IOException and FileNotFoundException together because FileNotFoundException is a subclass of IOException.
Syntax:
java
Copy code
try {
// Code that may throw exceptions
} catch (IOException | SQLException e) {
// Handle both IOException and SQLException
e.printStackTrace();
}
In this example, both IOException and SQLException are handled by the same catch block.

Key points:
The variable e in the catch block is implicitly final, meaning you can't reassign it within the block.
This feature reduces code duplication when multiple exceptions have the same handling logic.
Combining Both Concepts
Here’s an example combining try-with-resources and catching multiple exceptions:

java
Copy code
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
System.out.println(br.readLine());
} catch (FileNotFoundException | IOException e) {
e.printStackTrace();
}
In this code:

The BufferedReader is automatically closed when the block is done.
Both FileNotFoundException and IOException are handled in the same catch block.