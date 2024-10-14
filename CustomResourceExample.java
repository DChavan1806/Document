class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("MyResource created");
    }

    public void doSomething() {
        System.out.println("Doing something with MyResource");
    }

    @Override
    public void close() {
        System.out.println("MyResource is being closed");
    }
}

public class CustomResourceExample {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
