File Operations in Java 8: Changes and Enhancements
Java 8 introduced several enhancements to file operations, particularly in the java.nio.file package. These changes improved handling of files and directories by providing more efficient and flexible ways to perform file I/O operations. The java.nio.file package was introduced in Java 7, but Java 8 added enhancements such as the use of lambda expressions, streams, and other functional-style APIs to make file operations more expressive and easy to manage.

Here are the key changes and enhancements related to file operations in Java 8:

1. Files.walk() and Files.find()
   Files.walk(): This method generates a stream of Path objects by recursively walking the directory tree. It’s very useful for listing files and directories.

Syntax:

java
Copy code
Stream<Path> Files.walk(Path start, int maxDepth)
Example:

java
Copy code
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWalkExample {
public static void main(String[] args) throws IOException {
Path startPath = Paths.get("/path/to/directory");

        try (Stream<Path> stream = Files.walk(startPath, 2)) {
            stream.filter(Files::isRegularFile)
                  .forEach(System.out::println);
        }
    }
}
Explanation: This code walks the directory tree starting at /path/to/directory, with a maximum depth of 2. It filters for regular files (not directories), and then prints the file paths.

Files.find(): This method is used to search for files that match a certain condition. It provides more flexibility than Files.walk() as it allows searching for files using a predicate.

Syntax:

java
Copy code
Stream<Path> Files.find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher)
Example:

java
Copy code
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FileFindExample {
public static void main(String[] args) throws IOException {
Path startPath = Paths.get("/path/to/directory");

        try (Stream<Path> stream = Files.find(startPath, 3,
                (path, attrs) -> path.toString().endsWith(".txt") && attrs.isRegularFile())) {
            stream.forEach(System.out::println);
        }
    }
}
Explanation: This code searches for .txt files in the directory /path/to/directory with a maximum depth of 3.

2. Files.lines()
   Java 8 introduced Files.lines(), which allows you to read all lines from a file as a Stream<String>. This is particularly useful for processing large text files efficiently.

Syntax:

java
Copy code
Stream<String> Files.lines(Path path)
Example:

java
Copy code
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadLinesExample {
public static void main(String[] args) throws IOException {
Path filePath = Paths.get("file.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        }
    }
}
Explanation: This example reads all the lines from file.txt and prints them to the console using a stream.

3. Files.list()
   The Files.list() method returns a stream of files (i.e., Path objects) in a directory. Unlike Files.walk(), it does not traverse subdirectories by default.

Syntax:

java
Copy code
Stream<Path> Files.list(Path dir)
Example:

java
Copy code
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ListFilesExample {
public static void main(String[] args) throws IOException {
Path dir = Paths.get("/path/to/directory");

        try (Stream<Path> stream = Files.list(dir)) {
            stream.forEach(System.out::println);  // List all files and directories
        }
    }
}
Explanation: This code lists all the files and directories at the root of /path/to/directory.

4. Files.readAllLines() and Files.write()
   Although these methods were introduced in Java 7, they became more flexible with the integration of functional programming features in Java 8.

Files.readAllLines(): Reads all lines from a file and returns them as a list of strings.

java
Copy code
List<String> Files.readAllLines(Path path)
Files.write(): Writes the specified lines to a file.

java
Copy code
Files.write(Path path, List<String> lines, StandardOpenOption... options)
Example: Read and Write Using Lambda Expressions:

java
Copy code
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ReadWriteExample {
public static void main(String[] args) throws IOException {
Path filePath = Paths.get("file.txt");

        // Read all lines
        List<String> lines = Files.readAllLines(filePath);
        lines.forEach(System.out::println);

        // Write new lines
        Path outputPath = Paths.get("output.txt");
        Files.write(outputPath, lines);
    }
}
5. Files.copy() and Files.move()
   Files.copy(): Copies files or directories. The method has options to overwrite existing files or preserve file attributes.

java
Copy code
Files.copy(Path source, Path target, CopyOption... options)
Files.move(): Moves or renames files or directories.

java
Copy code
Files.move(Path source, Path target, CopyOption... options)
Example: Copy and Move Files:

java
Copy code
import java.io.IOException;
import java.nio.file.*;

public class CopyMoveExample {
public static void main(String[] args) throws IOException {
Path sourcePath = Paths.get("file.txt");
Path targetPath = Paths.get("backup.txt");

        // Copy file
        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        // Move file (rename)
        Path newFilePath = Paths.get("renamed.txt");
        Files.move(targetPath, newFilePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
Explanation: This code copies file.txt to backup.txt and then renames backup.txt to renamed.txt.

6. Try-With-Resources and File Handling
   Java 8 benefits from the try-with-resources statement, ensuring that file resources are automatically closed after operations. For instance, when using BufferedReader, you no longer need to explicitly close the resource.

Example:
java
Copy code
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcesExample {
public static void main(String[] args) {
Path filePath = Paths.get("file.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
7. Functional-Style File Operations
   With Java 8's functional features (like lambda expressions), file operations have become more streamlined and expressive. You can now use lambdas and streams to filter, map, and manipulate files easily.

Example: Filtering Files Using Streams:
java
Copy code
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FunctionalFileExample {
public static void main(String[] args) throws IOException {
Path dir = Paths.get("/path/to/directory");

        // Filter and print only ".txt" files
        try (Stream<Path> stream = Files.walk(dir)) {
            stream.filter(file -> file.toString().endsWith(".txt"))
                  .forEach(System.out::println);
        }
    }
}
Common Interview Questions on Java 8 File Operations
What are the key differences between Files.walk() and Files.list()?

Answer: Files.walk() recursively traverses the directory tree, returning a stream of all files and directories, while Files.list() only lists files in the root directory without going into subdirectories.
How does Files.lines() differ from Files.readAllLines()?

Answer: Files.lines() returns a stream of strings for each line in the file, which allows for lazy processing (on-demand reading), making it suitable for handling large files. Files.readAllLines(), on the other hand, reads all lines at once into a List<String>, which can lead to memory issues with very large files.
What is the purpose of the StandardCopyOption.REPLACE_EXISTING flag in Files.copy() and Files.move()?

Answer: This flag allows you to overwrite the