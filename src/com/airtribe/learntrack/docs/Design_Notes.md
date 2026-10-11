# LearnTrack - Architectural Design Notes

This document outlines the key architectural and object-oriented design decisions made during the development of the LearnTrack system.

## 1. Why `ArrayList` instead of a primitive array?
We chose `ArrayList` over standard fixed-size arrays (`Student[]`) for several key reasons:
- **Dynamic Sizing:** Standard arrays require a pre-defined fixed capacity. If a user adds an 11th student to a 10-slot array, it throws an error. `ArrayList` dynamically grows and shrinks in size as items are added or removed.
- **Built-in Convenience Methods:** `ArrayList` comes with powerful helper methods like `.add()`, `.size()`, and iteration support out-of-the-box, significantly reducing boilerplate code for searching and listing records.

## 2. Where did we use static members and why?
Static fields and methods were used exclusively inside the **`IdGenerator`** utility class (`studentIdCounter`, `courseIdCounter`, `enrollmentIdCounter`, and their corresponding `getNext...Id()` methods).
- **Why?** In a standard database system, auto-incrementing IDs are managed globally across all records. Since `static` variables belong to the class itself rather than individual object instances, they maintain a single, shared state across the entire application lifecycle. This ensures that every newly created entity receives a unique, sequential ID without duplicates.

## 3. Where did we use inheritance and what did we gained from it?
Inheritance was implemented by introducing a base **`Person`** class, which is extended by the **`Student`** class.
- **What we gained:**
    - **Code Reusability:** Core fields common to any human entity in the system (`id`, `firstName`, `lastName`, `email`) are defined once in `Person` and inherited automatically by `Student`, avoiding code duplication.
    - **Polymorphism:** Allowed us to override methods like `getDisplayName()` in subclasses to format specialized output cleanly, establishing a flexible foundation if instructors or staff entities are introduced later.