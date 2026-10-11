# Java Development Environment Setup

## 1. JDK Download & Installation

1. **Download JDK:**
 * Go to the official [Oracle JDK Download Page](https://www.oracle.com/java/technologies/downloads/) or use an open-source distribution like [Eclipse Temurin (Adoptium)](https://adoptium.net/).
 * Select **JDK 17 (LTS)** or **JDK 21 (LTS)** matching your operating system (Windows, macOS, or Linux).
 * Download and run the installer executable (`.msi` / `.pkg`).

2. **Default Installation Paths:**
 * **Windows:** `C:\Program Files\Java\jdk-17`
 * **macOS:** `/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home`
 * **Linux:** `/usr/lib/jvm/jdk-17`

---

## 2. Setting Environment Variables

Setting `JAVA_HOME` and updating `PATH` ensures that the Java compiler (`javac`) and runtime (`java`) can be executed from any terminal directory.

### Windows Configuration
1. Open **System Properties** (`Win + R`, type `sysdm.cpl`, press Enter).
2. Navigate to the **Advanced** tab and click **Environment Variables**.
3. Under **System variables**, click **New**:
 * **Variable name:** `JAVA_HOME`
 * **Variable value:** `C:\Program Files\Java\jdk-17`
4. Under **System variables**, select **Path** and click **Edit**.
5. Click **New** and add: `%JAVA_HOME%\bin`
6. Click **OK** to save and close all dialogs.

### macOS / Linux Configuration
1. Open your terminal shell profile (`~/.zshrc` or `~/.bashrc`).
2. Add the following lines:
   ```bash
   export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
   export PATH=$JAVA_HOME/bin:$PATH
   

java version :  "21.0.12.1" 2026-08-18 LTS
**Environment Verification**
   javac -version
   java version

## **About "Hello World" program run::**

`public class HelloWorld {
public static void main(String[] args){

        System.out.println("Hello World - Welcome to my world");
    }
}`

### 1.Compilation :
     Compile the source code into platform-independent bytecode using the Java compiler (javac)

 **javac HelloWorld.java**

   **This creates a _HelloWorld.class_ file in the current working directory**

### 2.Execution :
     Execute the compiled .class file using the java launcher (java)

 **java HelloWorld**

## OUTPUT: 
      Hello World - Welcome to my world
