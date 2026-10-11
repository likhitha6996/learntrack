# JVM Basics & Architecture Overview

## What is JDK, JRE, JVM?

#**JVM (Java Virtual Machine):** The abstract virtual machine that executes Java bytecode line-by-line or via Just-In-Time (JIT) compilation into host machine code
* **JRE (Java Runtime Environment):** The runtime package containing the **JVM + core Java class libraries** (e.g., `java.util`, `java.io`) required to run existing Java software. It cannot compile code.
* **JDK (Java Development Kit):** The full developer kit that contains **JRE + JVM + developer tools** like `javac` (compiler), `javadoc`, and `jdb` (debugger)

> **Hierarchy:** `JDK` includes `JRE` + Development Tools (`javac`). `JRE` includes `JVM` + Core Libraries

## 2. What is Bytecode?

Bytecode is the intermediate, non-human-readable instruction set produced by the `javac` compiler when processing `.java` source code files. Unlike traditional languages (like C/C++) that compile directly into OS-specific machine instructions, Java source code is compiled into OS-agnostic bytecode (`.class` files).

## 3. "Write Once, Run Anywhere" (WORA)

The core strength of Java is its platform independence, encapsulated by the slogan **"Write Once, Run Anywhere." Because Java code compiles into universal bytecode rather than native machine code, a developer can write and compile code on one operating system (e.g., Windows) and run the exact same `.class` file on any other operating system (e.g., macOS or Linux) without re-compiling.

This is made possible by the Java Virtual Machine (JVM). While bytecode is completely platform-independent, the JVM implementation itself is tailored to each underlying OS, translating universal bytecode into host-specific machine code on the fly.