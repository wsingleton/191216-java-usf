# Reflection

The Java Reflection API, gives Java classes the ability to perform dynamic reflection, or the ability to look inside classes that are already loaded.
	
Fundamentally, the Reflection API consists of two components: objects that represent the various parts of a class file, and a means for extracting those objects in a safe and secure way. The latter is very important, as Java provides many security safeguards, and it would not make sense to provide a set of classes that invalidated those safeguards.
	
The first component of the Reflection API is the mechanism used to fetch information about a class. This mechanism is built into the class named Class. The special class, Class, is the universal type for the meta information that describes objects within the Java system. Class loaders in the Java system return objects of type Class. Up until Java 1.5 the three most interesting methods in this class were:

- `forName`
	- which would load a class of a given name, using the current class loader
- `getName`
	- which would return the name of the class as a String object - useful for identifying object references by their class name
- `newInstance`
	- which would invoke the null constructor on the class (if it exists) and return you an object instance of that class of object
		
To these three useful methods the Reflection API adds some additional methods to class `Class`. These are as follows:
	
- `getConstructor`, `getConstructors`, `getDeclaredConstructor`
- `getMethod`, `getMethods`, `getDeclaredMethods`
- `getField, getFields`, `getDeclaredFields`
- `getSuperclass`
- `getInterfaces`
- `getDeclaredClasses`
			
In addition to these methods, many new classes were added to represent the objects that these methods would return. The new classes mostly are part of the java.lang.reflect package, but some of the new basic type classes (Void, Byte, and so on) are in the java.lang package. The decision was made to put the new classes where they are by putting classes that represented meta-data in the reflection package and classes that represented types in the language package.
	
Thus, the Reflection API represents a number of changes to class Class that let you ask questions about the internals of the class, and a bunch of classes that represent the answers that these new methods give you.
	
---
## Uses of Reflection
	
Reflection is commonly used by programs which require the ability to examine or modify the runtime behavior of applications running in the Java virtual machine. This is a relatively advanced feature and should be used only by developers who have a strong grasp of the fundamentals of the language. With that caveat in mind, reflection is a powerful technique and can enable applications to perform operations which would otherwise be impossible.
		
- Extensibility Features
	- An application may make use of external, user-defined classes by creating instances of extensibility objects using their fully-qualified names.

- Class Browsers and Visual Development Environments
    - A class browser needs to be able to enumerate the members of classes. Visual development environments can benefit from making use of type information available in reflection to aid the developer in writing correct code.

- Debuggers and Test Tools
    - Debuggers need to be able to examine private members on classes. Test harnesses can make use of reflection to systematically call a discoverable set APIs defined on a class, to insure a high level of code coverage in a test suite.

---
## Drawbacks of Reflection
	
Reflection is powerful, but should not be used indiscriminately. If it is possible to perform an operation without using reflection, then it is preferable to avoid using it. The following concerns should be kept in mind when accessing code via reflection.
		
- Performance Overhead
	- Because reflection involves types that are dynamically resolved, certain Java virtual machine optimizations cannot be performed. Consequently, reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.
			
- Security Restrictions
    - Reflection requires a runtime permission which may not be present when running under a security manager. This is in an important consideration for code which has to run in a restricted security context, such as in an Applet.
	
- Exposure of Internals
	- Since reflection allows code to perform operations that would be illegal in non-reflective code, such as accessing private fields and methods, the use of reflection can result in unexpected side-effects, which may render code dysfunctional and may destroy portability. Reflective code breaks abstractions and therefore may change behavior with upgrades of the platform.
		
