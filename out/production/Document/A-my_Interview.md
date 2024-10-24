**Interview :**
1. Find the lowest salary by departments
   - [sql.md](sql.md) 
2. Find a number max from the array.
   - [findNumberMax.java](findNumberMax.java)
   - [LongestSubArrayZeroSum.java](LongestSubArrayZeroSum.java)
3. Google cloud :
   - [spring-cloud.md](spring-cloud.md)
4. After production deployment code broke, and you want to give quick solution since work around 
    or hotfix would take time;
   - [production-failure-deployment.md](production-failure-deployment.md)
5. Object Class methode; 
   - [java-lang-objects.md](java-lang-objects.md)
6. Interface with two implementation in java. How it will resolve @autowired service object.
   and @service allowed at interface or impl class
7. How the @Repository working with interface 
   - [interface-with-multiple-implementation.md](interface-with-multiple-implimentation.md)
8. Design controller with exception handling
   - [controller.md](controller.md)
9. Try with resource : How it is working and catch with multiple exception in single catch
   - [exception-handling.md](exception-handling.md)
10. In Java, when you have a child class (subclass) and a parent class (superclass) that both define a method with the same name and signature (i.e., the same parameters), 
    the method that gets called depends on the actual object type at runtime, not the type of the reference variable. This is known as method overriding
    
        Parent obj = new Child(); // Parent reference holding a Child object
        obj.display(); // Calls Child's display method

    - **Dynamic Method Dispatch:** 
         - When you call obj.display(), Java uses dynamic method dispatch (also known as late binding) to determine which display() method to invoke.
         - Since obj is actually referencing an instance of Child, the display() method from the Child class is called, even though obj is declared as type Parent.
    - **Compile-Time vs. Runtime:** 
         - The compiler checks the reference type at compile time and allows the method call (because obj is of type Parent), 
         - but the actual method execution is determined at runtime based on the actual object type (Child).
11. JVM working and memory :
12. where static variable store in jvm
     [jvm-working.md](jvm-working.md)
13. Implement jvm custom class loader : 
    [CustomClassLoader.java](program/CustomClassLoader.java)
14. How default with same name in differ interface work when concrete class implement both interface
15. Differance between runnable and callable
16. What purpose methode reference in java8 
17. Java 8 complete
     [java8.md](java8.md)
     [DefaultMethod.java](program/DefaultMethod.java)
18. WORKING OF PRIORITY QUEUE
    - it does not flow the fifo rule as normal queue, it arranges the element based on their priorities 
    - priority queue can store comparable object to arrange them in correct priority or comparator
    - for int , char , float jvm auto-box  to wrapper class which already hava comparable implemented 

          PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
               @Override
               public int compare(Task t1, Task t2) {
               return Integer.compare(t1.priority, t2.priority);
            }
          });
    - add , remove and pool() - > to remove 1st element as per priority 
    - max heap and min heap tech to add and remove data
19. Kafka : [kafka.md](kafka.md)