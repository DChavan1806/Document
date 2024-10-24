package program;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final String classPath;
    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = classPath + File.separator + name.replace('.', File.separatorChar) + ".class";
        try (InputStream inputStream = Files.newInputStream(Paths.get(fileName))) {
            byte[] classData = new byte[inputStream.available()];
            inputStream.read(classData);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class: " + name, e);
        }
    }

    public static void main(String[] args) {
        String classPath = System.getProperty("user.dir"); // Current directory

        MyClassLoader classLoader = new MyClassLoader(classPath);
        try {
            Class<?> helloWorldClass = classLoader.loadClass("HelloWorld");

            Object helloWorldInstance = helloWorldClass.getDeclaredConstructor().newInstance();

            helloWorldClass.getMethod("sayHello").invoke(helloWorldInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
