# ContactManagementSystem
# Contact Management System (Java + MySQL)

A **console-based Contact Management System** built using **Java Core, Object-Oriented Programming (OOP), JDBC, and MySQL**. The application provides a menu-driven interface to manage personal and business contacts while storing data permanently in a MySQL database.

## Features

* Add Personal Contacts
* Add Business Contacts
* View All Contacts
* Search Contacts by Name
* Update Contact Details
* Delete Contacts
* Phone Number Validation
* Duplicate Contact Detection
* Persistent Data Storage using MySQL

## Tech Stack

| Technology   | Purpose                      |
| ------------ | ---------------------------- |
| Java         | Core application development |
| JDBC         | Database connectivity        |
| MySQL        | Data storage                 |
| Eclipse IDE  | Development environment      |
| Git & GitHub | Version control              |

## Project Structure

```text
ContactManagementSystem/
│
├── src/
│   └── contactmanagementsystem/
│       ├── Main.java
│       ├── Person.java
│       ├── Contact.java
│       ├── PersonalContact.java
│       ├── BusinessContact.java
│       ├── Address.java
│       ├── ContactOperations.java
│       ├── ContactManager.java
│       ├── DBConnection.java
│       ├── InvalidContactException.java
│       └── DuplicateContactException.java
│
├── ContactManagementSystem.sql
├── README.md
└── .gitignore
```

## Database Setup

### 1. Create the Database

Run the following SQL commands in MySQL Workbench.

```sql
CREATE DATABASE contact_management;

USE contact_management;
```

### 2. Create the Contacts Table

```sql
CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(10) UNIQUE NOT NULL,
    email VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    type VARCHAR(20),
    relation_name VARCHAR(50),
    company VARCHAR(100)
);
```

## JDBC Configuration

1. Download **MySQL Connector/J**.
2. Add the JDBC JAR to Eclipse:

   * Build Path → Configure Build Path → Libraries → Add External JARs.
3. Update `DBConnection.java` with your MySQL credentials.

```java
private static final String URL = "jdbc:mysql://localhost:3306/contact_management";
private static final String USER = "root";
private static final String PASSWORD = "YOUR_PASSWORD";
```

## How to Run

1. Clone or download this repository.
2. Import the project into Eclipse.
3. Add the MySQL JDBC Driver.
4. Create the database and table using the SQL script.
5. Update `DBConnection.java` with your MySQL password.
6. Run `Main.java` as a Java Application.

## Sample Menu

```text
===== Contact Management System =====

1. Add Personal Contact
2. Add Business Contact
3. View Contacts
4. Search Contact
5. Update Contact
6. Delete Contact
7. Exit
```

## OOP Concepts Implemented

| Concept            | Implementation                                          |
| ------------------ | ------------------------------------------------------- |
| Encapsulation      | Private fields with getters and setters                 |
| Abstraction        | `Person` abstract class                                 |
| Inheritance        | `Contact`, `PersonalContact`, `BusinessContact`         |
| Polymorphism       | Method overriding (`displayInfo()`, `toString()`)       |
| Interface          | `ContactOperations`                                     |
| Composition        | `Contact` has an `Address` object                       |
| Exception Handling | Custom exceptions for validation and duplicate contacts |

## Exception Handling

The project includes custom exception handling for improved reliability.

* `InvalidContactException` – Handles invalid phone numbers.
* `DuplicateContactException` – Prevents duplicate contacts from being added.

## Learning Outcomes

Through this project, I gained hands-on experience with:

* Java OOP principles
* JDBC database connectivity
* MySQL CRUD operations
* Exception handling
* Collections and object management
* Console-based application development
* GitHub project documentation

## Future Enhancements

* Login Authentication
* Contact Sorting (A–Z)
* Search by Phone Number
* Import/Export Contacts (CSV)
* Java Swing GUI Version
* Spring Boot REST API Version

## Author

**Akshitha Minumula**
