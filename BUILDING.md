# Building AnimalDespawn on Windows XP / Java 8

## Easiest method

1. Install a Java 8 JDK.
2. Install Maven 3.5.4.
3. Make sure both commands work in Command Prompt:
   `java -version`
   `mvn -version`
4. Extract this project.
5. Double-click `build.bat`.
6. If successful, the plugin will be:
   `target\\AnimalDespawn-0.1.0.jar`

## Why Maven 3.5.4?

This project is deliberately aimed at an old Java 8 development environment.
Maven 3.5.4 dates from 2018 and has Java 7-era runtime requirements, making it
a sensible conservative choice for Java 8u152.

Do not use Maven 4 on the XP machine.

## If Java is installed but not found

Add the JDK's `bin` directory to PATH, for example:

C:\Program Files\Java\jdk1.8.0_152\bin

Then close and reopen Command Prompt.

## If Maven is installed but not found

Add Maven's `bin` directory to PATH, for example:

C:\apache-maven-3.5.4\bin

Then close and reopen Command Prompt.

## Manual build

From the directory containing pom.xml:

    mvn clean package

The compiled JAR will be placed in `target\\`.

## Important

The plugin itself targets Java 8. Maven is only the build tool; it is not
installed on the Minecraft server.
