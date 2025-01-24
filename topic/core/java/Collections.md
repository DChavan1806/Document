- **Collections** : 
    1. HashMap internal 
       - use array as bucket(HashTable) and Linked list(key/value/hash/next) as to insert element of same hash value
       - initial capacity 16(0to15)
       - if element increase more than 8 element in linked list convert to Red-Black (self balance tree)
       - hash(k) - index = hash & (n-1)
       - default balance factor : 0.75 , 8 element O(n) -> log(n), 6 element to un-treefied 
       - two hashing mechanism used hashing plus key comparison for balance tree
           1. hashing collision - if hash value is same for two element and 1 element already present in    
              bucket called as hashing collision - will check if key is same using equal method then attached it the next node
           2. Hashing Value - Mapping object to Integer value 
           3. load factor in a HashMap is a measure of how full the HashMap can get before it needs to be resized. 
               It's defined as a ratio of the number of elements to the capacity (number of buckets). The default load factor is 0.75,
               which means the HashMap will be resized when the number of entries exceeds 75% of the bucket count.
               - Example: If the initial capacity of a HashMap is 16, with a load factor of 0.75, the HashMap will resize when it has 12 elements (i.e., 16 * 0.75 = 12).
               - Effect of Load Factor:
                   - A higher load factor decreases space overhead but increases the likelihood of collisions (and longer chains of linked entries), which can degrade performance.
                   - A lower load factor increases space usage but reduces collisions, leading to better performance in terms of retrieval.
    
    2. HashSET : 
        - internally used hashmap to store data
        - constant element PRESENT Object - dummy value to associate with object store in backing map

    3.  ArrayList and LinkedList are implementations of the List interface in Java, but they have different internal structures and performance characteristics.
        1. ArrayList
            - Data Structure: Uses a dynamic array to store the elements.
            - Access Time (Get): Fast access (O(1)) to elements using an index, as it provides direct access by array indexing.
            - Insertion/Deletion: Inserting or deleting an element in the middle of the list takes time (O(n)) because elements must be shifted to maintain the array structure.
            - Memory Overhead: Less overhead, but resizing the array when it becomes full can be expensive, as a new larger array needs to be created and elements copied.
        Use Case: Ideal for scenarios where read operations are more frequent than insertions or deletions.
        2. LinkedList
            - Data Structure: Doubly linked list where each element (node) stores references to the previous and next elements.
            - Access Time (Get): Slower access (O(n)) to elements because traversal from the head or tail is required to reach the desired index.
            - Insertion/Deletion: Fast insertions and deletions (O(1)) at the beginning, middle, or end, as no shifting of elements is required.
            - Memory Overhead: Higher overhead due to the storage of additional pointers (references) for the next and previous nodes.
        Use Case: Ideal for scenarios where frequent insertions and deletions are required, especially in the middle of the list.
    
    4. ConcurrentModificationException in Java
       
        - ConcurrentModificationException occurs when a collection (like an ArrayList, HashMap, etc.) is 
         structurally modified while iterating over it in a way that is not allowed. This exception is a fail-fast mechanism designed to prevent inconsistent behavior while a collection is being iterated and modified concurrently.
        1. Iterating over a collection using an iterator or enhanced for-loop and modifying the collection 
            (like adding or removing elements) during iteration without using the iterators remove() method. 
        2. Modifying a collection in one thread while another thread is iterating over it.
        3. How to avoid - using Iterator -> while iterator.hasNext - > iterator.remove() -> iterator.next
        4. using CopyOnWriteArrayList or ConcurrentHashMap, synchronized in multithreading 
    
    5. CopyOnWriteArrayList 
        - CopyOnWriteArrayList is a thread-safe variant of ArrayList provided in Java's 
            java.util.concurrent package. It is designed for use cases where the list is mostly read with infrequent updates.
        - use copy on write strategy to handle concurrent modification 
        - when modification occur it create new copy of underlying array 
        - does not lock list during read operation 
        - CopyOnWriteArrayList is a powerful tool for achieving thread safety in multithreaded environments, particularly when the list is read frequently and modified infrequently.
        - The list’s copy-on-write mechanism ensures that reads are fast and can happen concurrently, while writes (modifications) are more costly in terms of time and memory.
        - Its unique ability to allow safe iteration during modifications without throwing exceptions makes it a preferred choice in scenarios where iteration is common and thread safety is crucial. 
    
    6. concurrent hashmap internal working :
        A ConcurrentHashMap in Java is a thread-safe version of a regular HashMap designed for concurrent access in multithreaded environments. 
        It allows multiple threads to read from and write to the map without the need for external synchronization, such as using synchronized blocks. 
        This makes it highly efficient for concurrent use, while avoiding performance bottlenecks typical of full synchronization.
        - Thread Safety:
        - Segmented Locking (Java 7 and below)
        - CAS-based Operations (Java 8 and above)
        - No null keys or values
        - Iterators are weakly consistent
    
    7. Linked hashed Map and its internal
        -  (k,v, hash, next , before and after) (head and tail)
        - A LinkedHashMap in Java is a combination of a HashMap and a Doubly Linked List, providing a       
            predictable iteration order (based on insertion or access order) while maintaining the constant
        - A LinkedHashMap extends HashMap. The main structure is a hash table that stores entries 
            (key-value pairs) in an array of linked lists (buckets). This allows for O(1) time complexity on average for put(), get(), and remove() operations.
        - Each entry in the LinkedHashMap has a reference to the previous and next entry in the doubly  
            linked list. This ensures a predictable iteration order.
            - The doubly linked list allows the LinkedHashMap to preserve the insertion order or access     
                order, depending on how it is configured during construction.
       1. Entry:
            Each entry in a LinkedHashMap is an instance of a class called LinkedHashMap.Entry, 
            which extends HashMap.Node. In addition to the standard hash table fields (like key, value, hash), 
            it has two extra pointers: before (points to the previous entry) and after (points to the next entry).
       2. Insertion Order:
            By default, LinkedHashMap maintains the insertion order. When a new element is added, it is linked at the end of the doubly linked list, and iteration over the map will yield elements in the order they were inserted.
       3. Access Order:
            Optionally, LinkedHashMap can be configured to maintain the access order by passing true to the constructor:
                LinkedHashMap<K, V> map = new LinkedHashMap<>(initialCapacity, loadFactor, true);
            In this mode, whenever an element is accessed (via get() or put()), it is moved to the end of the doubly linked list. This makes it useful for implementing an LRU (Least Recently Used) cache, where older elements can be evicted when the cache reaches a size limit.
        4. Removal Order:
            The doubly linked list also helps in maintaining an efficient removal process. When an entry is removed, its before and after references are adjusted, linking the surrounding entries to each other. 
            - Iteration Order: LinkedHashMap maintains the order in which keys were inserted (or accessed,
               if configured).
            - Doubly Linked List: Supports constant-time reordering for access operations, making it ideal 
              for LRU caches.
            - HashMap Efficiency: Underneath, it retains the constant time complexity for basic operations, 
              similar to a HashMap.
- WORKING OF PRIORITY QUEUE
    - it does not flow the fifo rule as normal queue, it arranges the element based on their priorities
    - priority queue can store comparable object to arrange them in correct priority or comparator
    - for int , char , float jvm auto-box  to wrapper class which already hava comparable implemented

          PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
               @Override
               public int compare(Task t1, Task t2) {
               return Integer.compare(t1.priority, t2.priority);
            }
          });
    - add , remove and pool() - > to remove 1st element as per priority
    - max heap and min heap tech to add and remove data
    

        

