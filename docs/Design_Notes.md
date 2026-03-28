# Design Notes

## Why ArrayList instead of Array?

We used ArrayList instead of regular arrays because:

1. Dynamic Size → ArrayList grows and shrinks
   automatically. We don't know how many students
   or courses will be added at runtime.

2. Built-in Methods → ArrayList provides useful
   methods like add(), remove(), get(), size()
   which make code cleaner and simpler.

3. Flexibility → Arrays have fixed size. If we
   used arrays, we would need to define maximum
   students/courses upfront which is not practical.

## Where We Used Static Members and Why?

### IdGenerator.java
We used static fields and methods in IdGenerator:
- studentIdCounter → static field
- courseIdCounter → static field
- enrollmentIdCounter → static field

Reason → ID counters should be shared across all
instances. If they were instance variables, each
new IdGenerator object would reset the counter
to 0, causing duplicate IDs.

### InputValidator.java
All methods are static because:
- They don't need any instance variables
- They are utility methods used everywhere
- No need to create object to use them

### MenuOptions.java and AppConstants.java
All constants are static final because:
- They never change
- They should be accessible without creating object

## Where We Used Inheritance and What We Gained?

### Person → Student hierarchy
Person is the base class with common fields:
- id, firstName, lastName, email

Student extends Person and adds:
- batch, active

What we gained:
1. Code reuse → Student inherits all Person fields
   and methods automatically.
2. No duplication → getters and setters written once
   in Person, used in Student.
3. Extensibility → If we add Trainer later, it
   can also extend Person and reuse same fields

## Separation of Concerns
We followed clean separation of concerns:
- entity/    → only data, no logic!
- repository/ → only storage, no logic!
- service/   → all business logic!
- ui/        → only menu and display!