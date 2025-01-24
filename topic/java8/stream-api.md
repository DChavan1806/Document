- Intermediate and Terminal Operations :  https://chatgpt.com/share/678486c7-d634-8002-8d7a-7f6aca4879a5
- Stream Core Stream Operations :
  1. filter(Predicate<T>)

          List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
          List<Integer> evenNumbers = numbers.stream() //Stream<Interger>
             .filter(n -> n % 2 == 0) //filter number -> Stream<Interge> 
             .collect(Collectors.toList()); //terminal operation
          Output: [2, 4, 6]

  2. map(Function<T, R>) : Transforms each element by applying a function to them.

          List<String> names = Arrays.asList("Dnyaneshwar", "Anurag");
          List<Integer> nameLengths = names.stream() // Stream<String>
                .map(String::length) // Stream<Interger>
                .collect(Collectors.toList());
          Output: [11, 6]

  3. flatMap(Function<T, Stream<R>>) : Flattens streams of streams into a single stream.

            List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));
            List<Integer> flatList = listOfLists.stream() //Stream<Stream<Interger>>
                .flatMap(List::stream) //Stream<Integer>
                .collect(Collectors.toList()); //List<Interger>
            Output: [1, 2, 3, 4, 5]
  
  4. reduce(BinaryOperator<T> accumulator) : Reduces the elements of a stream into a single result.

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
            int sum = numbers.stream() //Stream<Interger>
               .reduce(0, Integer::sum); //Integer
            Output: 10

  5. forEach(Consumer<T>) : Performs an action for each element of the stream.

            List<String> names = Arrays.asList("Dnyaneshwar", "Anurag");
            names.stream().forEach(System.out::println);
            Output:
            Dnyaneshwar
            Anurag

  6. collect(Collector<T, A, R>) : Collects the stream result into a collection or other types like a list, set, or string.

            List<String> names = Arrays.asList("Dnyaneshwar", "Anurag");
            String joinedNames = names.stream() //Stream<String>
               .collect(Collectors.joining(", ")); String
            Output: "Dnyaneshwar, Anurag"

  7. sorted(Comparator<T>) : Sorts the elements of the stream.

            List<String> names = Arrays.asList("Dnyaneshwar", "Anurag");
            List<String> sortedNames = names.stream()
              .sorted()
              .collect(Collectors.toList());
            Output: [Anurag, Dnyaneshwar]

- Coding Questions Related to Stream API
  1. Find all even numbers from a list of integers
   
         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
         List<Integer> evenNumbers = numbers.stream()
         .filter(n -> n % 2 == 0)
         .collect(Collectors.toList());
         Output: [2, 4, 6]
  2. Convert a list of strings to uppercase
   
         List<String> names = Arrays.asList("Dnyaneshwar", "Anurag");
         List<String> upperCaseNames = names.stream()
           .map(String::toUpperCase)
           .collect(Collectors.toList());
         Output: [DNYANESHWAR, ANURAG]
  3. Find the sum of all numbers in a list
  
         List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
         int sum = numbers.stream()
           .reduce(0, Integer::sum);
         Output: 10
  4. Count the number of occurrences of each word in a list
   
         List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana");
         Map<String, Long> wordCount = words.stream()
             .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
         Output: {"apple"=2, "banana"=2, "orange"=1}
  5. Find the maximum number in a list
   
           List<Integer> numbers = Arrays.asList(1, 3, 7, 2, 5);
           int maxNumber = numbers.stream()
             .max(Integer::compareTo)
             .orElseThrow(NoSuchElementException::new);
           Output: 7
  
  6. Find the first non-repeated character in a string using streams
  
           String str = "swiss";
           Character nonRepeatedChar = str.chars()
              .mapToObj(c -> (char) c)
              .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
           .entrySet().stream()
              .filter(entry -> entry.getValue() == 1)
              .map(Map.Entry::getKey)
              .findFirst()
              .orElse(null);
           Output: 'w'
  7. Find all distinct elements in a list
   
           List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
           List<Integer> distinctNumbers = numbers.stream()
           .distinct()
           .collect(Collectors.toList());
           Output: [1, 2, 3, 4, 5]
  8. Sort a list of objects by a field using streams
   
         class Person {
         String name;
         int age;
        
         // constructor, getters, and setters
         }
                    
          List<Person> people = Arrays.asList(new Person("Dnyaneshwar", 30), new Person("Anurag", 25));
          List<Person> sortedByAge = people.stream()
          .sorted(Comparator.comparing(Person::getAge))
          .collect(Collectors.toList());
