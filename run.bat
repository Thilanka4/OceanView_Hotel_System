@echo off
cls
echo ==============================================
echo   Ocean View Resort - Hotel Reservation System
echo ==============================================
echo.

cd src

REM Check if compiled files exist
if not exist "com\oceanview\resort\HotelReservationSystem.class" (
    echo Compiled files not found!
    echo Please compile first using: compile.bat
    pause
    exit /b 1
)

REM Run the application
java com.oceanview.resort.HotelReservationSystem

pause
