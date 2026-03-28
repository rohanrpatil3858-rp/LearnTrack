# JVM Basics

## JDK, JRE and JVM

### JVM (Java Virtual Machine)
JVM is like a translator that runs Java programs.
It takes the compiled bytecode and executes it on
the host machine. Every operating system has its
own JVM (Windows, Mac, Linux), which is why Java
programs can run on any platform.

### JRE (Java Runtime Environment)
JRE is the environment required to RUN Java programs.
It contains the JVM and the libraries needed to
execute Java applications. If you only want to run
a Java program (not develop), you only need JRE.

### JDK (Java Development Kit)
JDK is the complete package for Java development.
It contains JRE + compiler (javac) + development
tools. Developers install this to write,
compile and run Java programs.

## Simple Diagram
JDK
└── JRE
    └── JVM

## What is Bytecode?
When we write Java code in .java files and compile
it using javac, it gets converted into bytecode
(.class files). Bytecode is not machine code, it
is an intermediate code that JVM can understand
and execute on any platform.

Example:
Source code  → Main.java   (human readable)
Bytecode     → Main.class  (JVM readable)
Machine code → 0101010...  (computer readable)

## Write Once, Run Anywhere
Java follows the principle of "Write Once, Run
Anywhere" . This means we write Java
code once and it can run on any operating system
without any changes.

This is possible because of bytecode and JVM. When
we compile Java code, it becomes bytecode. This
bytecode can run on any machine that has a JVM
installed. The JVM on each platform takes care of
converting bytecode to machine specific code.

For example, the LearnTrack application we built
can run on Windows, Mac or Linux without any
code changes as long as JVM is installed!