    public class InvalidEmployeeIdException extends RuntimeException {
        public InvalidEmployeeIdException(String message) {
            super(message);
        }
    }

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(InvalidEmployeeIdException.class)
        public ResponseEntity<String> handleInvalidEmployeeIdException(InvalidEmployeeIdException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // Handle other exceptions if needed 
    }
    
       @RestController
       @RequestMapping("/api/employees")
       public class EmployeeController {
           @PostMapping
           public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
               if (employee.getId() < 1 || employee.getId() > 9999) {
                   throw new InvalidEmployeeIdException("Employee ID must be between 1 and 9999.");
               }
               // Simulate saving employee logic
               // employeeService.save(employee);
               return new ResponseEntity<>(employee, HttpStatus.CREATED);
           }
       }

         @RestControllerAdvice
         public class GlobalExceptionHandler {
             // Handle specific exception (InvalidEmployeeIdException)
             @ExceptionHandler(InvalidEmployeeIdException.class)
             public ResponseEntity<String> handleInvalidEmployeeIdException(InvalidEmployeeIdException ex) {
                 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
             }
             // Handle a general exception (e.g., IllegalArgumentException)
             @ExceptionHandler(IllegalArgumentException.class)
             public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
                 return new ResponseEntity<>("Invalid argument: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
             }
             // Handle all other exceptions (generic)
             @ExceptionHandler(Exception.class)
             public ResponseEntity<String> handleGeneralException(Exception ex) {
                 return new ResponseEntity<>("Internal server error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }

  -  customize

          @RestControllerAdvice
          public class GlobalExceptionHandler {
            @ExceptionHandler(InvalidEmployeeIdException.class)
            public ResponseEntity<Map<String, Object>> handleInvalidEmployeeIdException(InvalidEmployeeIdException ex) {
               Map<String, Object> errorResponse = new HashMap<>();
               errorResponse.put("error", ex.getMessage());
               errorResponse.put("timestamp", LocalDateTime.now());
               errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
               return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }
          }

