#!/bin/bash
# Create docs directory if it doesn't exist
mkdir -p docs

# Generate Javadoc
javadoc -d docs -windowtitle "Grocery Management System" GroceryManagementSystem.java

echo "Javadoc successfully generated in the docs/ folder."
