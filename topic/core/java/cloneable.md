**Cloning** in Java refers to creating a duplicate object of an existing object. 
- The Cloneable interface is used to indicate that a class permits cloning. 
- To achieve cloning, the class must:
   1. Implement the Cloneable interface (a marker interface without any methods).
   2. Override the clone() method from the Object class.
   3. Ensure proper handling of deep copying for mutable fields (e.g., Date, List, or custom objects) to avoid shared references.
**- Types of Cloning:**
      1. Shallow Cloning:
         - Creates a copy of the object, but fields referencing other objects (e.g., List, Date) are not copied deeply.
         - Changes to the referenced objects will reflect in both the original and cloned objects.
      2. Deep Cloning:
         - Creates a copy of the object and all objects referenced by it.
         - Ensures that changes in the original object's referenced fields do not affect the cloned object.

- [CloneableDemo.java](program/CloneableDemo.java)
