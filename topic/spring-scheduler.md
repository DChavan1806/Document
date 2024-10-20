- The Spring Framework provides a powerful way to schedule tasks using the `@Scheduled` annotation. 
  - This allows developers to execute tasks asynchronously at fixed intervals or specific times, 
     without the need for external task scheduling tools like cron jobs. 

    1. Enable Scheduling
        - To use scheduling, you need to enable it in your Spring application. This can be done by adding `@EnableScheduling `to your configuration class.
       
              import org.springframework.context.annotation.Configuration;
              import org.springframework.scheduling.annotation.EnableScheduling;
              @Configuration
              @EnableScheduling
              public class SchedulerConfig {
              }
    2. Creating a Scheduled Task
        - You can then create methods that you want to schedule by annotating them with @Scheduled. Here are a few scheduling options:
        - Fixed Rate: Runs the method at a fixed rate in milliseconds. 
        - Fixed Delay: Runs the method with a fixed delay between the end of the last execution and the start of the next. 
          - Cron Expressions: Allows for more complex scheduling using cron expressions.

                @Component
                public class MyScheduledTask {
                // Runs every 5 seconds
                @Scheduled(fixedRate = 5000)
                public void scheduleFixedRateTask() {
                    System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
                }
        
                // Runs with a delay of 5 seconds between the end of the last and the start of the next execution
                @Scheduled(fixedDelay = 5000)
                public void scheduleFixedDelayTask() {
                    System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
                }
        
                ┌───────────── second (0 - 59)
                │ ┌───────────── minute (0 - 59)
                │ │ ┌───────────── hour (0 - 23)
                │ │ │ ┌───────────── day of the month (1 - 31)
                │ │ │ │ ┌───────────── month (1 - 12 or JAN-DEC)
                │ │ │ │ │ ┌───────────── day of the week (0 - 7 or SUN-SAT, where 0 and 7 both represent Sunday)
                │ │ │ │ │ │
                * * * * * *
                // Runs according to a cron expression (Every minute)
                @Scheduled(cron = "0 * * * * *")
                public void scheduleCronTask() {
                    System.out.println("Cron task - " + System.currentTimeMillis() / 1000);
                }
            }`
        -  "0 0 12 * * ?"   // Every day at 12 PM
        -  "0 * * * * *"    // Every minute
        -  "0 15 10 ? * *"  // At 10:15 AM every day
      
    3. Asynchronous Scheduling (Optional):
       - If your scheduled tasks are computationally heavy or should not block the main thread, you can make them asynchronous using @Async.
       - import org.springframework.scheduling.annotation.Async;
        `@Async
        @Scheduled(fixedRate = 5000)
        public void asyncScheduledTask() {
        System.out.println("Async task - " + System.currentTimeMillis() / 1000);
        }`
    4. Thread Pool Configuration (Optional):
       -  By default, Spring uses a single thread to execute scheduled tasks. If you want to customize the thread pool, you can configure a TaskScheduler bean.
       - `import org.springframework.context.annotation.Bean;
         import org.springframework.context.annotation.Configuration;
         import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
         @Configuration
         public class SchedulerConfig {
        
            @Bean
            public ThreadPoolTaskScheduler taskScheduler() {
                ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
                scheduler.setPoolSize(10);
                scheduler.setThreadNamePrefix("my-scheduled-task-");
                return scheduler;
            }
         }`
    5. Error Handling:
       - If you want to handle exceptions that occur during the execution of scheduled tasks, you can use a ScheduledExecutorService.
       - `@Bean
         public ScheduledExecutorService scheduledExecutorService() {
         return Executors.newScheduledThreadPool(5);
         }`





