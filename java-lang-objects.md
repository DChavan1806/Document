- The java.lang.Object class is the root class for all Java classes.
- Every class in Java either directly or indirectly inherits from Object. 
- It defines some core methods that are available in every Java object. 
- Here are the 11 methods of the Object class:

1. public final Class<?> getClass()
     - Description: Returns the runtime class of the object.
     - Usage: Used to get metadata about the object's class, such as its name or its declared methods and fields.
     `  Object obj = new String("Hello");
       System.out.println(obj.getClass().getName());`
2. public int hashCode()
    - Description: Returns a hash code value for the object. This is used in hashing-based collections like HashMap and HashSet. 
    - Usage: You can override this method in custom classes to provide meaningful hash codes.
    - `Object obj = new Object();
      System.out.println(obj.hashCode());`
3. public boolean equals(Object obj)
    - Description: Compares this object with the specified object for equality. The default implementation checks if the references are the same, but it is often overridden.
    - Usage: Override this in your custom classes to compare objects by their content rather than just by reference.
    - `Object obj1 = new Object();
      Object obj2 = new Object();
      System.out.println(obj1.equals(obj2)); ` // Output: false (by default)
4. protected Object clone() throws CloneNotSupportedException
    - Description: Creates and returns a copy (clone) of this object. The class needs to implement the Cloneable interface to be cloned.
    - Usage: Override this if you want objects of your class to be cloned.
    - `class MyClass implements Cloneable {
          public Object clone() throws CloneNotSupportedException {
          return super.clone();
          }
      }`
5. public String toString()
    - Description: Returns a string representation of the object. By default, it prints the class name followed by the object's hash code.
    - Usage: It's common to override this to provide a meaningful string representation of an object.
    - `Object obj = new Object();
      System.out.println(obj.toString());  // Output: java.lang.Object@hashcode`
6. public final void notify()
    - Description: Wakes up one thread that is waiting on this object's monitor (lock).
    - Usage: Typically used in multi-threading scenarios where one thread needs to notify another that a condition has been met. It must be called from within a synchronized context.
    - `synchronized(obj) {
          obj.notify();  // Wakes up one waiting thread
      }`
7. public final void notifyAll()
    - Description: Wakes up all threads that are waiting on this object's monitor.
    - Usage: Like notify(), but wakes up all waiting threads instead of just one.
    - `synchronized(obj) {
         obj.notifyAll();  // Wakes up all waiting threads
      }`
8. public final void wait() throws InterruptedException
   - Description: Causes the current thread to wait until it is notified or interrupted. It must be called within a synchronized context.
   - Usage: Used in multi-threading when a thread needs to pause until some condition is met.
      `synchronized(obj) {
          obj.wait();  // Current thread waits until notified
      }`
9. public final void wait(long timeout) throws InterruptedException
   - Description: Causes the current thread to wait until it is notified or until the specified timeout has elapsed.
   - Usage: Like wait(), but with a timeout in milliseconds.
      `synchronized(obj) {
          obj.wait(1000);  // Waits for 1 second or until notified
      }`
10. public final void wait(long timeout, int nanos) throws InterruptedException
    - Description: Similar to the previous method, but allows for greater precision with an additional nano-seconds parameter.
    - Usage: Waits until either the specified time has elapsed or until the thread is notified.
    - `synchronized(obj) {
         obj.wait(1000, 500);  // Waits for 1 second and 500 nanoseconds
      }`

11. protected void finalize() throws Throwable
    - Description: This method is called by the garbage collector before an object is destroyed. It's meant for cleanup operations before an object is reclaimed.
    - Usage: Typically not used because of unpredictability and the introduction of alternative cleanup mechanisms like try-with-resources and explicit finalization.
    - `protected void finalize() throws Throwable {
          System.out.println("Object is being garbage collected");
      }`
