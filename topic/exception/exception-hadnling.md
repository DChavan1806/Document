- an exception is an event that occurs during the execution of a program and disrupts its normal flow. Java provides a robust and object-oriented approach to handle such scenarios.
  - Use specific exceptions instead of generic ones like Exception or Throwable.
  - Always clean up resources (e.g., closing files, streams) using finally or try-with-resources.
  - Avoid empty catch blocks; always log or handle exceptions meaningfully.
  - Don't suppress exceptions unless necessary.
  - Ensure exception messages are clear and meaningful.

- Exception Hierarchy
   - Throwable: The parent class of all exceptions and errors.
      1. Error: Indicates serious problems that a program should not try to handle (e.g., OutOfMemoryError, StackOverflowError).
      2. Exception: Represents conditions that a program might want to catch (e.g., IOException, SQLException).
          - Checked Exceptions: Exceptions checked at compile-time (e.g., IOException, SQLException).
          - Unchecked Exceptions (Runtime Exceptions): Exceptions not checked at compile-time (e.g., NullPointerException, ArithmeticException).
         
- Common Types of Exceptions
     - Checked Exceptions : Must be declared in the throws clause or handled using a try-catch block.
       - Examples:
  
                  IOException
                  SQLException
                  FileNotFoundException
                  
     - Unchecked Exceptions : Can occur during the program's runtime and need not be explicitly handled.
     - Examples:
  
            NullPointerException
            ArithmeticException
            IndexOutOfBoundsException
     - Errors  : Represent fatal errors outside the application's control.
     - Examples:
  
           OutOfMemoryError
           StackOverflowError
           VirtualMachineError

- Handling Exceptions : Java provides several mechanisms for exception handling
  1. Try-Catch Block 

           try {
               int result = 10 / 0;  // May throw ArithmeticException
           } catch (ArithmeticException e) {
               System.out.println("Cannot divide by zero!");
           } finally {
               System.out.println("Execution complete.");
           } 
       - Catching Multiple Exceptions in a Single Catch Block
           - Java allows catching multiple exceptions in a single catch block using a pipe (|) operator. 
           - This is useful for reducing code duplication when handling multiple exception types similarly.

                 try {
                    // Code that may throw exceptions
                 } catch (IOException | SQLException e) {
                    // Handle IOException or SQLException
                    System.out.println("Exception occurred: " + e.getMessage());
                 }
           - Rules:
             1. The exceptions must not have a parent-child relationship (e.g., IOException and FileNotFoundException cannot be caught together because one is a subclass of the other).
             2. The variable e in the catch block is effectively final and cannot be reassigned.

  2. Finally block 
      - Always executed after try and catch, used for cleanup operations.
      - if return statement in try/catch, finally block will execute before return statement
  3. Throw Keyword
       - Throw Keyword `throw new IllegalArgumentException("Invalid input");`
  4. Throws Keyword : Declares exceptions that a method might throw. caller will be catch exception.

           public void readFile() throws IOException {
                 FileReader file = new FileReader("file.txt");
           }
  5. Custom Exceptions
        - You can create your own exceptions by extending the Exception class or RuntimeException class.

         class CustomException extends Exception {
           public CustomException(String message) {
             super(message);
           }
         }

         public class Main {
           public static void main(String[] args) {
             try {
               throw new CustomException("This is a custom exception");
             } catch (CustomException e) {
                System.out.println(e.getMessage());
             }
           }
         }
  6. Exception Propagation
        - Checked exceptions must be explicitly declared or caught.
        - Unchecked exceptions propagate automatically up the call stack if not caught.
     
         public void method1() {
           method2(); // Throws exception // can add try catch here
         }

         public void method2() {
           int result = 10 / 0; // ArithmeticException propagates
         }
  7. Try-With-Resources
        - Introduced in Java 7, this is used for resource management. 
        - Resources (e.g., streams, files) are automatically closed.
        - use AutoClosable or Closable interface to write custom resources for Try-With-Resources 
        - it simplifies resource management and avoids resource leaks by ensuring the close() method is called on the resource after the try block finishes execution.
        - [CustomResourceExample.java](program/CustomResourceExample.java)

               try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
                  System.out.println(br.readLine());
               } catch (IOException e) {
                  e.printStackTrace();
               }

