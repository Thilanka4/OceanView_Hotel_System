@echo off
cls
echo ==============================================
echo   Ocean View Resort - Compilation Script
echo ==============================================
echo.

REM Check if javac is available
where javac >nul 2>nul
if %errorlevel% neq 0 (
    echo Error: Java compiler ^(javac^) not found!
    echo Please install Java Development Kit ^(JDK^)
    echo.
    echo Download from: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)

echo Java version:
java -version
echo.
echo Java compiler version:
javac -version
echo.

REM Navigate to source directory
cd src

REM Clean previous compiled files
echo Cleaning previous compiled files...
del /Q com\oceanview\resort\*.class 2>nul

REM Compile all Java files
echo Compiling Java files...
javac com\oceanview\resort\*.java

if %errorlevel% equ 0 (
    echo.
    echo ==============================================
    echo   Compilation Successful!
    echo ==============================================
    echo.
    echo To run the application:
    echo   java com.oceanview.resort.HotelReservationSystem
    echo.
    echo Or double-click run.bat
) else (
    echo.
    echo ==============================================
    echo   Compilation Failed!
    echo ==============================================
)

pause
