1. **What is the Java Virtual Machine? What is Bytecode?**  
    Like the name says, the JVM is a virtual machine, a simulated computer that runs on your system.
    Bytecode is the compiled code, not bound to a special machine architecture.
    Java classes are compiled down to Java bytecode which in turn is interpreted by the Java Virtual Machine.
2. **What is the Java Classpath?**  
  The Java Classpath is a parameter in the JVM that specifies the location of user-defined classes and packages.
3. **How do you compile and run your java program without the help of an Integrated Development Environment (IDE) (e.g., an IDE like Eclipse)?**  
  You can compile a java program with the help of a command line and the command javac yourclass.java
4. **What is a JAR file?**
  JAR stands for Java Archive and is a package file format. It is used to package many java classes, resources etc into one file for distribution.
5. **How do you declare the starting point of a Java application?**  
  The starting point of a Java Application is a method called main. Example:
  ```java
  public class MyProgram {
    public static void main(String[] args) {
      // This is the entry point of the application
      MyApp app = new MyApp();
      app.run();
    }
  }
  ```

6. **What is a package? Why is important to declare classes inside packages?**  
  A package in Java is a namespace. It is used to organize related classes. This is important as a program might have hundreds of classes and organizing them is crucial for good software architecture.
7. **What is an interface? Why is it important to not change them?**  
  An interface could be seen as a public API describing what a class should do. A class implementing an interface needs to implement all methods declared in the interface. It is important not to change an interface because other classes or programs can depend on your interface, and changing it might result in breaking changes.
8. **Which visibility levels are available in Java? What is the default visibility for classes, methods, and fields?**  
  1. public - accessible everywhere
  2. protected - accessible in the same package and sub-classes
  3. no modifier - accessible only in the same package. This is the default behaviour
  4. private - accessible only in the same class.

9. **In the context of Java, what is an Exception? And what is an Error?**  
  An Error in Java indicates that a very serious problem occured in the program. Errors should not be catched by the program since they are abnormal conditions.
10. **What happened if your program terminates with an OutOfMemoryError, or NoClassDefFoundErroror NullPointerException?**  
  1. OutOfMemoryError - the JVM could not allocate an object because it is out of memory and the garbage collector could not make any more memory available.
  2. NoClassDefFoundErroror - thrown if the JVM or a ClassLoader instance tries to load in the definition of a class, but the definition could not be found anywhere.
  3. Thrown when an application tries to use null when an object is required, like calling an instance method on a null object.
11. **How do you handle Exceptions in your program?**  
  Exceptions are handled with the try/catch statement. One should hide the stack trace in production and present a user-friendly message that something went wrong.
12. **Why is it important to test your code/application/product, before you deliver it to your customer/boss/teacher?**  
  This is important to avoid bugs sneaking into production code.
13. **What is JavaDoc? How do you write documentation with it?**
  JavaDock is a tool to generate API documentation for your code in HTML. You document your classes and methods with
  special "doc comments", which are de facto standard for documenting Java code.
