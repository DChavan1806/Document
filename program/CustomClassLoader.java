package program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {
    
    // Path where the .class files are located
    private String classPath;
    
    // Constructor accepting classpath
    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // Replace '.' with '/' to match file path convention
        String classFilePath = classPath + name.replace('.', '/') + ".class";
        
        try {
            // Read the class file as bytes
            byte[] classBytes = Files.readAllBytes(Paths.get(classFilePath));
            
            // Define the class with byte array
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            // If class is not found or other errors, throw ClassNotFoundException
            throw new ClassNotFoundException("Could not find class: " + name, e);
        }
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the custom class loader
            CustomClassLoader loader = new CustomClassLoader("path_to_classes/");

            // Load the class dynamically
            Class<?> clazz = loader.loadClass("com.example.MyClass");

            // Print the class name
            System.out.println("Loaded class: " + clazz.getName());
            
            // Optionally, you can create a new instance of the loaded class
            Object instance = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Instance created: " + instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
