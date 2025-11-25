<!-- ...existing code... -->
# Library System Demo

A simple library system developed to showcase the basics of Object Oriented concepts such as inheritance, polymorphism, and interfaces in the Java programming language. Developed as a part of an assignment for BSCH-OOP Object Oriented Programming. Achieved a 99% grade.

## Features
- Demonstrates inheritance and polymorphism with a base `Book` type and concrete subclasses:
  - `PrintedBook` — printed book details (pages, cover)
  - `EBook` — ebook details (format, size)
  - `AudioBook` — audiobook details (narrator, length, size)
- `Library` implements a `Catalogue` interface to add, borrow, return, and filter books.
- Console-based interactive demo in `Main`.

## Project structure
- src/
  - Book.java — abstract base class
  - PrintedBook.java — printed book subclass
  - EBook.java — ebook subclass
  - AudioBook.java — audiobook subclass
  - Catalogue.java — interface implemented by Library
  - Library.java — catalogue implementation and book management
  - Main.java — simple console UI to exercise the system

## Compile & run
From the project root:

```sh
javac src/*.java
java -cp src src.Main
