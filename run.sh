#!/bin/bash

echo "=============================================="
echo "  Ocean View Resort - Hotel Reservation System"
echo "=============================================="
echo ""

cd src

# Check if compiled files exist
if [ ! -f "com/oceanview/resort/HotelReservationSystem.class" ]; then
    echo "Compiled files not found!"
    echo "Please compile first using: ./compile.sh"
    exit 1
fi

# Run the application
java com.oceanview.resort.HotelReservationSystem
