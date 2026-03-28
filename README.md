# LearnTrack - Student & Course Management System

## Project Description
LearnTrack is a console-based Student and Course
Management System built using Core Java. It allows
admins to manage Students, Courses and Enrollments
through a simple menu-driven interface.

## Features
- Student Management (Add, View, Search,
  Activate/Deactivate)
- Course Management (Add, View,
  Activate/Deactivate)
- Enrollment Management (Enroll, View,
  Mark Complete/Cancelled)

## Project Structure
src/
└── com/
    └── airtribe/
        └── learntrack/
                ├── Main.java
                ├── entity/
                ├── repository/
                ├── service/
                ├── exception/
                ├── util/
                ├── constants/
                └── enums/ 
docs/
├── JVM_Basics.md
├── Setup_Instructions.md
└── Design_Notes.md

README.md

## How to Compile and Run

### Using IntelliJ IDEA:
1. Open project in IntelliJ
2. Right click Main.java
3. Click Run 'Main.main()'

### Using Terminal:
cd src
javac -sourcepath . com/airtribe/learntrack/Main.java
java com.airtribe.learntrack.Main

## Class Diagram

```mermaid
classDiagram
    %% Exception Classes
    class RuntimeException {
        <<built-in>>
    }
    
    class EntityNotFoundException {
        -String message
    }
    
    class InvalidInputException {
        -String message
    }
    
    RuntimeException <|-- EntityNotFoundException
    RuntimeException <|-- InvalidInputException
    
    %% Entity Classes
    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getId()
        +setId()
        +getFirstName()
        +setFirstName()
        +getLastName()
        +setLastName()
        +getEmail()
        +setEmail()
    }
    
    class Student {
        -int batch
        -boolean active
        +getBatch()
        +setBatch()
        +isActive()
        +setActive()
    }
    
    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -CourseStatus status
        +getId()
        +setId()
        +getCourseName()
        +setCourseName()
        +getDescription()
        +setDescription()
        +getDurationInWeeks()
        +setDurationInWeeks()
        +getStatus()
        +setStatus()
    }
    
    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -String enrollmentDate
        -EnrollmentStatus status
        +getEnrollmentDate()
        +setEnrollmentDate()
        +getStatus()
        +setStatus()
    }
    
    Person <|-- Student
    
    %% Enum Classes
    class CourseStatus {
        <<enumeration>>
        ACTIVE
        INACTIVE
    }
    
    class EnrollmentStatus {
        <<enumeration>>
        ACTIVE
        COMPLETED
        CANCELLED
    }
    
    Course --> CourseStatus
    Enrollment --> EnrollmentStatus
    
    %% Repository Classes
    class StudentRepository {
        -ArrayList~Student~ students
        +addStudent(Student)
        +getAllStudents()
        +getStudentById(int)
        +updateStudent(Student)
        +deleteStudent(int)
    }
    
    class CourseRepository {
        -ArrayList~Course~ courses
        +addCourse(Course)
        +getAllCourses()
        +getCourseById(int)
        +updateCourse(Course)
        +deleteCourse(int)
    }
    
    class EnrollmentRepository {
        -ArrayList~Enrollment~ enrollments
        +addEnrollment(Enrollment)
        +getAllEnrollments()
        +getEnrollmentById(int)
        +updateEnrollment(Enrollment)
        +deleteEnrollment(int)
    }
    
    StudentRepository --> Student
    CourseRepository --> Course
    EnrollmentRepository --> Enrollment
    
    %% Service Classes
    class StudentService {
        -StudentRepository studentRepository
        +addStudent(Student)
        +getAllStudents()
        +getStudentById(int)
        +updateStudent(Student)
        +deleteStudent(int)
    }
    
    class CourseService {
        -CourseRepository courseRepository
        +addCourse(Course)
        +getAllCourses()
        +getCourseById(int)
        +updateCourse(Course)
        +deleteCourse(int)
    }
    
    class EnrollmentService {
        -EnrollmentRepository enrollmentRepository
        -StudentService studentService
        -CourseService courseService
        +enrollStudent(int, int)
        +getAllEnrollments()
        +getEnrollmentById(int)
        +updateEnrollment(Enrollment)
        +deleteEnrollment(int)
    }
    
    StudentService --> StudentRepository
    CourseService --> CourseRepository
    EnrollmentService --> EnrollmentRepository
    EnrollmentService --> StudentService
    EnrollmentService --> CourseService
    
    %% Utility Classes
    class IdGenerator {
        -static int studentId
        -static int courseId
        -static int enrollmentId
        +static generateStudentId() int
        +static generateCourseId() int
        +static generateEnrollmentId() int
    }
    
    class InputValidator {
        +static isValidEmail(String) boolean
        +static isValidName(String) boolean
        +static isValidBatch(String) boolean
        +static isNotEmpty(String) boolean
    }
    
    %% Main Application
    class Main {
        +main(String[])
    }
    
    Main --> StudentService
    Main --> CourseService
    Main --> EnrollmentService
```

### Diagram Legend:
- Inheritance (is-a): 
  - Student extends Person
  - EntityNotFoundException, InvalidInputException extend RuntimeException
  
- Association (uses/has-a): 
  - Services use Repositories
  - EnrollmentService depends on StudentService and CourseService
  - Main class uses all Service classes

## Technologies Used
- Java 23
- Core Java
- Collections (ArrayList)
- OOP Principles (Inheritance, Polymorphism, Encapsulation)
- Design Patterns (Repository, Service, Utility)
