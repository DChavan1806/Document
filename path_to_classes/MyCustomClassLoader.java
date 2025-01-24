package path_to_classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyCustomClassLoader extends ClassLoader {
    public String filePath;
    MyCustomClassLoader(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFilePath = filePath + name.replace(".", "/") + ".class";

        try {
            byte[] classByteCode = Files.readAllBytes(Paths.get(classFilePath));
            return defineClass(name, classByteCode, 0, classByteCode.length);
        } catch (IOException e)
        {
            throw new ClassNotFoundException("Could not find class: " + name, e);
        }
    }

    public static void main(String[] args)  {
        try {
            MyCustomClassLoader loader = new MyCustomClassLoader("path_to_classes/");
            Class<?> clazz = loader.loadClass("path_to_classes.MyClass");
            System.out.println(clazz.getName());
            MyClass myClass = (MyClass) clazz.getDeclaredConstructor().newInstance();
            myClass.test();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
