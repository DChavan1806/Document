package program;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }

        // Step 2: Find the maximum frequency
        int maxCount = 0;
        for (int count : taskCount.values()) {
            maxCount = Math.max(maxCount, count);
        }

        // Step 3: Count how many tasks have the maximum frequency
        int maxCountTasks = 0;
        for (int count : taskCount.values()) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }

        // Step 4: Calculate the total intervals required
        int intervals = (maxCount - 1) * (n + 1) + maxCountTasks;

        // Step 5: Return the maximum between the calculated intervals and the number of tasks
        return Math.max(intervals, tasks.length);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        // Example usage
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // Output: 8
        System.out.println(scheduler.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1)); // Output: 6
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3)); // Output: 10
    }
}
