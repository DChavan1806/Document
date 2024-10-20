- Solid Priniciple And OOPS: 
    In Java, SOLID principles are an object-oriented approach that are applied to software structure design. It is conceptualized by Robert C. Martin (also known as Uncle Bob). 
    1. SOLID Priniciple.
        1. Single responsibility Priniciple(SRP)
            Every class must perform Single functionalaity 
            bank service - loan/notification/print service
        2. open and close Priniciple(OCPs) 
           according new requirement the module should be open for extension but
           close for modification.
           notification class - sent otp for email and mobile
           notification interface - only abstract class - email and mobile class will implement it and leter 
           whatsapp class.
        3. Leskov's Substitution Priniciple (LSP)
            inherite class such way that drived class/child class must be completely substitutable 
            for there base/parent class.
            Social media -
            chat/calls/post/sentmedia. break down to chat/sentmedia - Social media, post - post interface/Video call. 
        4. ISP : Interface segregation principle 
            larger interface split into smaller because implemention class could only use that are required
            we can not force client to use method which they dont not required
            It is similar to SRP.
            UPI payment : payMoney/sentMoney, getScratchCard, GetCashBackAsCreditBalnce. 
            Paytm : google pay : phone pay
            -> move GetCashBackAsCreditBalnce to cashBack interface
        5.  Dependency Interversion principle (DIP)
            We must use abstraction (abstract classes + interface) than concreate classes
            High level module should not depende on the low level module 
            but both should depend on the abstraction.
            Card payment -> debit/credit/ or any other card.

    2. OOPS : 
        1. Interfaces  : 
            - can only contain constant/abstract methode/default methode/nested types
            - provide a way to achive abstranction and multiple inheritence in java

        2. Serializable/Deserialization : 
            - conversion of a java object into static stream (squence) of byte , which we can save to database or tranfer over network. 
            - class will be eligible for serialization by using Marker interface serializable.
            - serial version UID is required to add in class to maintant the versioning of class
            - if dont provide , jvm provide one VersionUID
            - marked field as transient if you dont want to serialize that field
            - static field wont be serialized 
            - final/private are serializable
            - byte stream will be platfrom independent 
            - ObjectOutPutStream - writeObject -> convert object into byte stream 
            - ObjectInputStream - readObject -> convert byte stream -> object 
        
        3. Externalization : 
            - customize the serialization mechanium 
            - programmer will have full control over reading and writing object during serialization
            - writeExternal() for serialization - IOException 
            - readExternal() for deseriazation - IoException/ClassNotFoundException
       
        4. Cloning : 
            - clone() is a method in the Java used for object duplication.
            - Shallow Cloning :  Copy all the fields of a new instance of the same class to the new instance
            - Deep Cloning : The independent of original instance and making changes in clone should not affect original instance
            - need to implement clonable iterface : clone method object class
            - mutable vs immutable veribale 
        
        5. Genric : 
            - Java is type safe , type will be understand at compile time
            - without Gernic you can add any time of data to collection and need to handle it code,
              it could be lead to runtime exception  
            - In Java, generics are a powerful feature that allows you to define classes, interfaces, and methods with type parameters, providing type safety and code reusability. Generics enable the creation of classes, methods, and collections that can operate on any type (e.g., Integer, String, CustomObject), while still ensuring compile-time type safety.
            - Benefits of Generics:
                Type Safety: Generics ensure that you can only use objects of the specified type, avoiding ClassCastException at runtime.
                Code Reusability: Generic methods and classes can be written once and used with any type, making your code more flexible and reusable
        
        6.Internal libraries :
         - refer to libraries that are part of the Java Development Kit (JDK). 
         - These libraries provide core functionality that supports the language and runtime, offering a 
            wide range of tools for tasks like I/O, networking, data structures, concurrency, and more. 
         - Some of the key internal libraries in Java include:
            1. java.lang
                Purpose: Provides fundamental classes necessary for the language itself.
                Key Classes:
                    Object: The root class of all Java objects.
                    String: Immutable sequence of characters.
                    Math: Basic mathematical operations.
                    Thread: Used for creating and managing threads.
                    Throwable: Superclass for all exceptions and errors.
            
            2. java.util
                Purpose: Provides utility classes for collections, data manipulation, and more.
                Key Classes:
                    ArrayList, HashMap, HashSet: Implementations of collection interfaces.
                    Collections: Utility class for working with collections.
                    Date, Calendar: Date and time manipulation.
                    Optional: Handling nullable values in a more functional style.
            
            3. java.io
                Purpose: Input/output (I/O) functionality, dealing with files, streams, etc.
                Key Classes:
                    File: Represents file and directory pathnames.
                    InputStream, OutputStream: For byte-based I/O.
                    Reader, Writer: For character-based I/O.
                    BufferedReader, BufferedWriter: Buffered I/O for performance optimization.
            
            4. java.nio
                Purpose: Non-blocking I/O operations.
                Key Classes:
                    ByteBuffer: For efficient byte manipulations.
                    FileChannel: For file operations using channels.
                    Path, Files: Modern file handling utilities (from Java 7 onwards).
                    Selector: For multiplexing non-blocking I/O operations.
            
            5. java.net
                Purpose: Networking functionality.
                Key Classes:
                    Socket, ServerSocket: For TCP networking.
                    URL, URLConnection: For working with URLs and HTTP connections.
                    InetAddress: Handles IP addresses.
            
            6. java.sql
                Purpose: Provides JDBC APIs for database access.
                Key Classes:
                    Connection: Represents a connection to a database.
                    Statement, PreparedStatement: For executing SQL queries.
                    ResultSet: Represents the result set of a query.
            
            7. javax.*
                Purpose: Extensions to the core Java libraries.
                Key Libraries:
                    javax.swing: GUI components for desktop applications.
                    javax.servlet: Classes for creating web applications (in combination with Java EE).
            
            8. java.util.concurrent
                Purpose: Concurrency utilities for threading and parallel processing.
                Key Classes:
                    ExecutorService: Manages thread pools.
                    CompletableFuture: Used for handling asynchronous programming.
                    Lock: More flexible locking mechanisms than synchronized blocks.
                    ConcurrentHashMap: Thread-safe hash map implementation.
            
            9. java.security
                Purpose: Security and cryptography functionality.
                Key Classes:
                    MessageDigest: For generating hash digests like SHA-256.
                    KeyPair, PublicKey, PrivateKey: Public and private key encryption classes.
                    SecureRandom: Generates cryptographically strong random numbers.
            
            10. java.time
                Purpose: Date and time API introduced in Java 8.
                Key Classes:
                    LocalDate, LocalTime, LocalDateTime: Representing dates and times.
                    Duration, Period: For measuring time durations.

        7. Access Modifiers in Java
            - Access modifiers define the visibility and accessibility of classes, methods, and variables. Java has four main access levels:
                1. public: Accessible from anywhere (any class in any package).
                2. protected: Accessible within the same package and by subclasses (even in different   
                    packages).
                3. default (no keyword): Accessible only within the same package (also called 
                    package-private).
                4. private: Accessible only within the same class.
        
        8. Enums 
            - Enums are a special class type that represents a fixed set of constants. They are used when 
              you have a predefined list of values that don't change, such as days of the week or directions.
            - Enums can also have methods, constructors, and fields, making them more versatile than    
              just constant values.
            - Type-safe and compile-time validation.
                1. Readable, maintainable, and more meaningful than magic numbers or String constants.
                2. Built-in functionality (name(), ordinal(), etc.) and can be extended with methods and fields.
                3. Provides a clean alternative to groups of constants.
                4. Works seamlessly with switch statements.
                5. Enums offer a structured, clear, and robust way to represent fixed sets of related values, leading to safer and more maintainable code.




