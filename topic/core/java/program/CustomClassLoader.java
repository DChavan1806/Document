package topic.core.java.program;

import path_to_classes.MyClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    private String classPath;
    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        // Replace '.' with '/' to match file path convention
        String classFilePath = classPath + className.replace('.', '/') + ".class";
        try {
            byte[] byteCodeOfClass = Files.readAllBytes(Paths.get(classFilePath));
            int startOffset = 0;
            return defineClass(className, byteCodeOfClass, startOffset, byteCodeOfClass.length);
        } catch (IOException e) {
            // If class is not found or other errors, throw ClassNotFoundException
            throw new ClassNotFoundException("Could not find class: " + className, e);
        }
    }

    public static void main(String[] args) {
        try {
            CustomClassLoader loader = new CustomClassLoader("path_to_classes/");
            Class<?> clazz = loader.loadClass("path_to_classes.MyClass");
            System.out.println("Loaded class: " + clazz.getName());
            MyClass instance = (MyClass) clazz.getDeclaredConstructor().newInstance();
            System.out.println("Instance created: " + instance);
            instance.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
