package program;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExceptionHandling {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create a Callable task
        Callable<Integer> callableTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Simulating some work with a chance of failure
                int number = 42;
                if (number == 42) {
                    throw new Exception("Something went wrong! Number can't be 42.");
                }
                return number;
            }
        };

        // Submit the task to the executor service and receive a Future object
        Future<Integer> future = executor.submit(callableTask);

        // Attempt to get the result from the Future and handle exceptions
        try {
            // This will trigger the execution of the Callable's call() method
            Integer result = future.get();
            System.out.println("Callable result: " + result);
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted.");
        } catch (ExecutionException e) {
            // This will catch any exceptions thrown inside the call() method
            System.err.println("Exception in callable: " + e.getCause().getMessage());
        } finally {
            // Shut down the executor service
            executor.shutdown();
        }
    }
}
