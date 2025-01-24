package topic.java8.program;

interface InterfaceA {
    default void display() {
        System.out.println("Display from InterfaceA");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("Display from InterfaceB");
    }
}

class ConcreteClass implements InterfaceA, InterfaceB {
    // Must provide an implementation to resolve the ambiguity
    @Override
    public void display() {
        // Call the default method from InterfaceA
        InterfaceA.super.display(); // Calls InterfaceA's default method
        
        // Call the default method from InterfaceB
        InterfaceB.super.display(); // Calls InterfaceB's default method
        
        // Or provide a new implementation
        System.out.println("Display from ConcreteClass");
    }
}

public class DefaultMethod {
    public static void main(String[] args) {
        ConcreteClass obj = new ConcreteClass();
        obj.display(); // Calls the overridden display method in ConcreteClass
    }
}
