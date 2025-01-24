1. Java 8 (Released March 2014)
   - Java 8 was a landmark release that introduced several major features:
        - **Lambda Expressions:** Allow you to treat functionality as a method argument, enabling functional style programming, write cleaner code , increase readability.
            - lambda can be used with functional interface.
            - Scope: A lambda can access variables from its enclosing scope, but these variables must be effectively final.
            - significantly reduce boilerplate code
        - **Stream API:** Introduces a new abstraction for processing sequences of elements, facilitating functional-style operations on collections (e.g., filter, map, reduce).
            - It provides a clean, concise, and flexible way to perform bulk operations like filtering, mapping, and reducing on data collections.
            - Stream APIs promote functional programming.
        - **Default and Static Methods in Interfaces:** You can now provide method implementations in interfaces using default and static keywords, promoting better API design.
        - **Optional Class:** A new type that represents a value that may or may not be present, reducing the risk of NullPointerException.
        - **New Date and Time API:** Provides a comprehensive and standardized API for date and time manipulation.

2. Java 17 (Released September 2021)
   - Java 17 is a Long-Term Support (LTS) release that includes numerous features and enhancements:
        - Sealed Classes: Allows you to control which classes can extend or implement a particular class or interface. 
        - Pattern Matching for instanceof: Simplifies the common pattern of casting an object after checking its type.
        - JEP 382: New macOS Rendering Pipeline: Provides a new rendering pipeline for macOS to enhance performance.
        - JEP 411: Deprecate the Security Manager for Removal: Marks the Security Manager for potential future removal.
        - JEP 393: Foreign Function & Memory API (Incubator): Allows Java programs to interact with code and data outside the Java runtime.
        - JEP 384: Context-Specific Deserialization Filters: Enhances security around deserialization.
     
3. Java 19 (Released September 2022)
   - Java 19 introduced several new features and enhancements, focusing on preview features:
        - Record Patterns (Preview): Allows destructuring of record types in patterns, improving the way records are used.
        - Pattern Matching for Switch (Preview): Extends the switch statement to allow pattern matching, improving control flow and readability.
        - Virtual Threads (Preview): Introduces lightweight threads, which can significantly simplify concurrent programming by allowing more threads to be created with less overhead.
        - Foreign Function & Memory API (Second Incubator): Continues to evolve the ability to interface with native code.
