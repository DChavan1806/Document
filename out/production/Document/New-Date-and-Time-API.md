- java.time package 
- to overcome the shortcomings of the older java.util.Date and java.util.Calendar classes. 
- The new API is designed to be immutable, thread-safe, and much more intuitive than its predecessors.
  - The key classes introduced in the java.time package include:

          1. LocalDate: Represents a date without time (e.g., 2024-10-20).
              LocalDate today = LocalDate.now();  // Current date
              LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);  // Specific date
              LocalDate nextWeek = today.plusDays(7);  // Adding days
              boolean isLeapYear = today.isLeapYear();  // Check leap year
          2. LocalTime: Represents a time without a date (e.g., 10:15:30).
              LocalTime timeNow = LocalTime.now();  // Current time
              LocalTime specificTime = LocalTime.of(14, 30, 45);  // 2:30:45 PM
              LocalTime oneHourLater = timeNow.plusHours(1);  // Adding one hour
          3. LocalDateTime: Represents both date and time (e.g., 2024-10-20T10:15:30).
              LocalDateTime dateTime = LocalDateTime.now();  // Current date and time
              LocalDateTime meeting = LocalDateTime.of(2024, Month.OCTOBER, 20, 14, 30);  // Specific date and time
         4. ZonedDateTime: Represents a complete date-time with a time zone (e.g., 2024-10-20T10:15:30+05:30[Asia/Kolkata]).
              ZonedDateTime zonedNow = ZonedDateTime.now();  // Current date-time with zone
              ZonedDateTime specificZonedDateTime = ZonedDateTime.of(
              LocalDate.of(2024, 10, 20),
              LocalTime.of(14, 30),
              ZoneId.of("Asia/Kolkata"));  // Date and time with zone
         5. Instant: Represents a timestamp (e.g., the number of nanoseconds since 1970-01-01T00:00:00Z).
              Instant timestamp = Instant.now();  // Current timestamp in UTC
              Instant past = Instant.ofEpochSecond(1_000_000_000L);  // Specific instant

         6. Duration and Period: Used for measuring time or date differences.
               Period period = Period.between(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1));  // 4 years
               Duration duration = Duration.between(Instant.now(), Instant.now().plusSeconds(3600));  // 1 hour
         7. ZoneId and ZoneOffset: Represent time zones and their offsets.

1. Why was the new Date and Time API introduced in Java 8?
   - Answer: The old java.util.Date and java.util.Calendar classes had several design issues, such as:
    1. Mutability: Instances of Date and Calendar are mutable, making them thread-unsafe.
    2. Complexity: The API was difficult to use, with unintuitive methods.
    3. Poor timezone handling: Handling time zones was cumbersome.
    4. Month indexing: Months were zero-based, which was confusing. The new API is immutable, thread-safe, easier to understand, and includes strong support for time zones and periods.