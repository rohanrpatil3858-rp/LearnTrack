# Setup Instructions

## JDK Version Used
JDK Version: 23

## Installation Steps

### Step 1 → Install JDK
1. Go to https://www.oracle.com/java/technologies/downloads/
2. Download JDK 23
3. Install and set JAVA_HOME environment variable

### Step 2 → Verify Installation
Open terminal and type:
java -version
javac -version

### Step 3 → Clone Repository
git clone <github repo link>

### Step 4 → Run the Project

#### Using Terminal:
cd src
javac com/airtribe/learntrack/Main.java
java com.airtribe.learntrack.Main

## Hello World Verification
To verify Java is installed correctly,
create a file HelloWorld.java:

public class HelloWorld {
public static void main(String[] args) {
System.out.println("Hello World");
}
}

Compile and run:
javac HelloWorld.java
java HelloWorld

Expected output → Hello World!