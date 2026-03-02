#!/bin/bash

echo "=============================================="
echo "  Ocean View Resort - Compilation Script"
echo "=============================================="
echo ""

# Check if javac is available
if ! command -v javac &> /dev/null; then
    echo "Error: Java compiler (javac) not found!"
    echo "Please install Java Development Kit (JDK)"
    echo ""
    echo "Installation instructions:"
    echo "  Ubuntu/Debian: sudo apt-get install default-jdk"
    echo "  CentOS/RHEL:   sudo yum install java-devel"
    echo "  macOS:         brew install openjdk"
    echo "  Windows:       Download from oracle.com/java"
    exit 1
fi

echo "Java version:"
java -version
echo ""
echo "Java compiler version:"
javac -version
echo ""

# Navigate to source directory
cd src

# Clean previous compiled files
echo "Cleaning previous compiled files..."
rm -rf com/oceanview/resort/*.class 2>/dev/null

# Compile all Java files
echo "Compiling Java files..."
javac com/oceanview/resort/*.java

if [ $? -eq 0 ]; then
    echo ""
    echo "=============================================="
    echo "  Compilation Successful!"
    echo "=============================================="
    echo ""
    echo "To run the application:"
    echo "  java com.oceanview.resort.HotelReservationSystem"
    echo ""
    echo "Or use the run script:"
    echo "  ./run.sh"
else
    echo ""
    echo "=============================================="
    echo "  Compilation Failed!"
    echo "=============================================="
    exit 1
fi
