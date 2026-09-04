@echo off
title AnimalDespawn Builder
echo.
echo ==========================================
echo   AnimalDespawn - Java 8 Maven Builder
echo ==========================================
echo.

where java >nul 2>&1
if errorlevel 1 (
  echo ERROR: Java was not found in PATH.
  echo Install Java 8 and make sure "java" works in Command Prompt.
  pause
  exit /b 1
)

where mvn >nul 2>&1
if errorlevel 1 (
  echo ERROR: Maven was not found in PATH.
  echo Install Maven 3.5.4 or another Maven version compatible with Java 8.
  echo Then reopen Command Prompt and run this file again.
  pause
  exit /b 1
)

echo Java:
java -version
echo.
echo Maven:
mvn -version
echo.
echo Building...
echo.

call mvn clean package
if errorlevel 1 (
  echo.
  echo ==========================================
  echo BUILD FAILED
  echo ==========================================
  echo.
  pause
  exit /b 1
)

echo.
echo ==========================================
echo BUILD SUCCEEDED
echo ==========================================
echo.
echo Your plugin JAR should be here:
echo   target\AnimalDespawn-0.1.0.jar
echo.
pause
