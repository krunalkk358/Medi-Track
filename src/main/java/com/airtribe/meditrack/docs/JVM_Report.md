JVM Architecture Report
Introduction
Java Virtual Machine (JVM) is the core component of the Java platform that enables Java programs to run on any operating system. It executes compiled Java bytecode and manages memory and runtime operations.

The JVM follows the principle:

Write Once, Run Anywhere

JVM Architecture Components
1. Class Loader Subsystem
   The Class Loader loads .class files into the JVM memory.

Types of class loaders:

Bootstrap ClassLoader – Loads core Java libraries
Extension ClassLoader – Loads extension libraries
Application ClassLoader – Loads application classes

Steps in class loading:

Loading
Linking
Initialization
2. Runtime Data Areas
   The JVM uses several memory areas during execution.

Heap
Stores objects and class instances.

Features:

Shared among all threads
Garbage collected automatically
Stack
Stores method calls and local variables.

Each thread has its own stack.

Stack contains:

Local variables
Partial results
Method calls
Method Area
Stores:

Class metadata
Static variables
Runtime constant pool
Program Counter Register
Each thread has a PC register that stores the address of the currently executing instruction.

3. Execution Engine
   The execution engine executes the bytecode.

It includes:

Interpreter – Executes bytecode line by line
JIT Compiler – Converts bytecode into native machine code

Interpreter vs JIT Compiler
Interpreter:

Executes instructions line by line
Slower but flexible
JIT Compiler:

Compiles frequently used code into native machine code
Faster execution
Modern JVM uses both together.

Garbage Collection
Garbage Collection automatically removes unused objects from memory.

Benefits:

Prevents memory leaks
Automatic memory management
Improves application performance
Write Once Run Anywhere
Java programs compile into bytecode, which is platform independent.

The JVM translates this bytecode into machine-specific instructions, allowing the same program to run on any platform.

Example:

Windows
Linux
MacOS

All can run the same Java program.

Conclusion
The Java Virtual Machine provides:

Platform independence
Automatic memory management
High performance with JIT compilation
Secure execution environment
These features make Java one of the most reliable programming platforms.