# Java MySQL Console App – Bookstore Management System

## Overview
A Java-based console application developed to manage bookstore records using **JDBC and MySQL**. It supports CRUD (Create, Read, Update, Delete) operations for efficient book management.

## Features
- Add new books
- View all books
- Update book details
- Delete book records
- MySQL database connectivity using JDBC

## Technologies Used
- Java
- MySQL
- JDBC
- MySQL Connector/J
- Git & GitHub

## Prerequisites
- Java JDK installed
- MySQL Server installed
- MySQL JDBC Connector
- Java IDE or terminal

## Database Setup
1. Create a database in MySQL.
2. Create the required books table.
3. Configure your MySQL database username and password in the Java source code.
4. Ensure the MySQL JDBC driver is available in the project.

## Installation & Execution

**1. Clone the repository**
```bash
git clone <your-repository-url>
```

**2. Navigate to the project folder**
```bash
cd <project-folder>
```

**3. Compile the Java application**
```bash
javac -cp ".;lib/*" BookstoreApp.java
```

**4. Run the application**
```bash
java -cp ".;lib/*" BookstoreApp
```

## CRUD Operations

| Operation | Description |
|---|---|
| Create | Add new book records |
| Read | View existing books |
| Update | Modify book details |
| Delete | Remove book records |

## Project Structure
```text
Bookstore-Management-System/
│
├── lib/                  # JDBC library
├── BookstoreApp.java     # Main Java application
└── README.md             # Project documentation
```

## Author
Developed using Java, JDBC, and MySQL.
