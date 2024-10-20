
1. Interface with Two Implementations
   - Suppose you have the following interface and two implementations:
                   
           public interface PaymentService {
                void processPayment();
           }

            @Service("creditCardPaymentService")
            public class CreditCardPaymentService implements PaymentService {
                @Override
                public void processPayment() {
                    System.out.println("Processing payment via Credit Card.");
                }
            }

            @Service("paypalPaymentService")
            public class PayPalPaymentService implements PaymentService {
                @Override
                public void processPayment() {
                    System.out.println("Processing payment via PayPal.");
                }
            }

2. Injecting @Autowired with Multiple Implementations
   - If you try to autowire the PaymentService without specifying which implementation to inject, 
     Spring will not know which one to choose and will throw an error (NoUniqueBeanDefinitionException). 
   - to resolve this, you have a few options:
      1. Use @Qualifier to Specify Which Implementation
          - You can use the @Qualifier annotation to explicitly indicate which implementation should be injected. 
         
                  @Service
                   public class PaymentProcessor {
                   private final PaymentService paymentService;
                       @Autowired
                       public PaymentProcessor(@Qualifier("creditCardPaymentService") PaymentService paymentService) {
                         this.paymentService = paymentService;
                       }
                       public void process() {
                         paymentService.processPayment();
                       }
                   }
           - In this example, we are telling Spring to inject the CreditCardPaymentService by using @Qualifier("creditCardPaymentService").
 
      2. Use @Primary to Define a Default Implementation
           - You can annotate one of the implementations with `@Primary` to make it the default bean if no specific qualifier is provided.
         
                   @Service
                   @Primary  // Marks this as the default implementation
                   public class CreditCardPaymentService implements PaymentService {
                        @Override
                        public void processPayment() {
                            System.out.println("Processing payment via Credit Card.");
                        }
                   }
           - With this setup, if no @Qualifier is used, Spring will inject the CreditCardPaymentService by default.

      3. Use List or Map to Inject All Implementations
            - You can inject all the available implementations and select the appropriate one based on your logic.
            - This approach gives you the flexibility to choose the implementation based on runtime conditions.


             @Service
              public class PaymentProcessor {
              private final List<PaymentService> paymentServices;
                  @Autowired
                  public PaymentProcessor(List<PaymentService> paymentServices) {
                      this.paymentServices = paymentServices;
                  }
            
                  public void process(String paymentMethod) {
                      for (PaymentService service : paymentServices) {
                          if (paymentMethod.equals("CreditCard") && service instanceof CreditCardPaymentService) {
                              service.processPayment();
                          } else if (paymentMethod.equals("PayPal") && service instanceof PayPalPaymentService) {
                              service.processPayment();
                          }
                      }
                  }
              }

3. Can @Service be Used on an Interface?
   - No, you cannot annotate an interface with @Service. 
   - The @Service annotation is meant to be used on implementation classes, not on interfaces. 
   - The purpose of @Service is to tell Spring that the class should be treated as a service component (a Spring-managed bean).

    - The correct usage:
    1. Interfaces: Should not have @Service.
    2. Implementation classes: Should have @Service.
    3. Why is this so?
    4. The reason is that the interface itself does not contain any business logic, so Spring cannot create a bean of the interface type. Only the implementation classes contain the actual business logic and can be instantiated by Spring as beans.

4. Summary
   - Resolving Multiple Implementations:
    1. Use @Qualifier to specify which implementation to inject.
    2. Use @Primary to set a default implementation.
    3. Use List<PaymentService> to inject all implementations and choose at runtime.
   - @Service:
     1. Not allowed on interfaces.
     2. Used on the implementation classes to make them Spring-managed beans.
     3. This way, Spring will be able to inject the correct implementation of the interface into your services and components.


-  @Repository can be applied to an interface that extends JpaRepository. However, this is a special case in Spring, and it works differently from how @Service and other stereotype annotations like @Component are used on regular classes or interfaces.
  1. Why @Repository Works on JpaRepository Interfaces?
     - In Spring Data JPA, when you create an interface that extends JpaRepository or another Spring Data repository interface
       Spring automatically provides an implementation of that interface at runtime. 
       This implementation is created dynamically by Spring, using proxy-based techniques, 
       which allows you to use the repository interface directly.

            import org.springframework.data.jpa.repository.JpaRepository;
            public interface UserRepository extends JpaRepository<User, Long> {
            // Custom query methods can be defined here
              User findByUsername(String username);
            }
     - In this case, even though UserRepository is just an interface, 
     - spring will automatically create a proxy class that implements 
       it and inject that proxy wherever needed. You don't have to provide an implementation yourself.

  2. Spring allows @Repository on interfaces in this case because:
      - Dynamic Proxy Creation: Spring Data JPA uses dynamic proxies to create an implementation at runtime. The repository interfaces are just a contract that Spring can fulfill at runtime. 
      - Exception Translation: By using @Repository on these interfaces, Spring can automatically apply its exception translation mechanism, converting JPA-specific exceptions into Spring's data access exceptions (like DataAccessException).

                        @Repository
                        public interface UserRepository extends JpaRepository<User, Long> {
                         User findByUsername(String username);
                        }
   3. Why @Service Doesn't Work the Same Way on Interfaces
      - The @Service annotation is a Spring stereotype annotation, just like @Repository and @Component. 
      - However, @Service and @Component are typically applied to concrete classes and not interfaces,
      - because Spring doesn't generate a dynamic implementation for service interfaces the way it does for JpaRepository.
      - Here’s why: 
          - @Service is for Class-Level Beans: The @Service annotation is used to mark a class as a service layer component. 
          - It tells Spring that this class should be instantiated as a bean. 
          - Spring doesn't dynamically create an implementation for interfaces annotated with @Service unless you explicitly provide one.
      - No Automatic Implementation: For @Service-annotated classes, you must write the actual implementation. 
        Spring doesn’t automatically generate a proxy or an implementation for service interfaces like it does for repository interfaces.
