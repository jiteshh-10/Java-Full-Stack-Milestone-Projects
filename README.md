# Java Full-Stack Milestone Projects

Welcome to my collection of hands-on projects completed as part of a comprehensive full-stack Java training program. This repository showcases my skills and understanding of various Java technologies, from core concepts to advanced enterprise frameworks, structured by learning milestones.

## 👨‍💻 Author

-   **Name:** Jitesh Sen
-   **Enrollment Number:** 0176CS221094
-   **PBL ID:** J_251120142

---

## 🚀 Technologies Covered

This repository includes projects built with a wide range of technologies, including:

-   **Core Java:** Java Fundamentals, OOPS, Collections, I/O Streams, Multithreading, Exception Handling.
-   **Database:** SQL, JDBC, RDBMS concepts.
-   **Web Frontend:** HTML, CSS, JavaScript.
-   **Web Backend:** Servlets, JSP, AJAX, XML (DTD, XSD, XSLT).
-   **Frameworks:** Hibernate, Spring, Spring Boot.
-   **Build Tools:** Maven.

---

## 📂 Project Modules

The projects are organized into folders corresponding to the technical modules and milestones of the training curriculum.

### Milestone 1: Core Java Foundations

-   **[01-java-fundamentals-employee-search](./01-java-fundamentals-employee-search/)**: A simple console application to search for employee details by ID from a predefined array, calculating salary based on various components.
-   **[02-oops-video-rental-system](./02-oops-video-rental-system/)**: A menu-driven console application simulating a video rental store's inventory management using Object-Oriented principles.
-   **[03-exceptions-student-grades](./03-exceptions-student-grades/)**: A project demonstrating package structure and custom exception handling for validating student data and calculating grades.
-   **[04-io-streams-employee-management](./04-io-streams-employee-management/)**: An employee management system that persists data by writing and reading serialized objects to and from a file.
-   **[05-collections-projects](./05-collections-projects/)**: A set of smaller projects demonstrating the use of `ArrayList`, `Set`, and `Map` to manage data like employee registers, string lists, and unique game cards.

### Milestone 2: Database and Multithreading

-   **[06-multithreading-hare-tortoise-race](./06-multithreading-hare-tortoise-race/)**: A classic simulation of the Hare and Tortoise race using multiple threads, demonstrating thread creation, priorities, and control (`sleep`).
-   **[07-jdbc-user-operations](./07-jdbc-user-operations/)**: A comprehensive Java application that connects to an Oracle database using JDBC to perform various CRUD (Create, Read, Update, Delete) operations on a `Users` table.

### Milestone 3: Web Application Development

-   **[08-html-css-js-projects](./08-html-css-js-projects/)**:
    -   **Webpage with Frameset**: A static webpage layout created using the legacy HTML `<frameset>` tag.
    -   **Registration Form Validation**: An HTML5 registration form with client-side validation using JavaScript regular expressions and a timeout feature.
    -   **Online Bookstore UI**: A static welcome page for a bookstore, styled with external CSS to create a professional layout.
-   **[09-servlets-jsp-projects](./09-servlets-jsp-projects/)**: A collection of dynamic web applications built with Servlets and JSP.
    -   **Online Auction**: A bidding application where users submit item bids via an HTML form, which are processed by a Servlet and displayed on a JSP result page.
    -   **Login & User Management Module**: A complete user authentication system with login, registration, and password change functionalities, interacting with a database.
-   **[10-xml-technologies](./10-xml-technologies/)**:
    -   **Mobile Sales Report**: An XML document containing mobile sales data, validated with an XSD and transformed into a styled HTML table using an XSLT stylesheet.
    -   **XML Exercises**: A series of exercises covering DTD and XSD creation, namespaces, and XML validation.
-   **[11-ajax-library-registration](./11-ajax-library-registration/)**: A library management system featuring a registration page that uses AJAX to perform real-time, server-side validation of a user's email address without reloading the page.

### Milestone 4: Enterprise Frameworks

-   **[12-spring-boot-hibernate-crud-app](./12-spring-boot-hibernate-crud-app/)**: A complete, modern web application built with **Spring Boot**, **Spring MVC**, and **Spring Data JPA (Hibernate)**.
    -   **Features**:
        -   Secure user registration and login system with server-side validation.
        -   Session management to protect pages from unauthorized access.
        -   Full CRUD (Create, Read, Update, Delete) functionality for managing employee records.
        -   A streamlined, minimal-configuration setup demonstrating the power of the Spring ecosystem.

---

## 🛠️ Getting Started

### Prerequisites

-   Java Development Kit (JDK) 8 or higher (Java 17 for the Spring Boot project).
-   Apache Maven for dependency management.
-   An IDE like IntelliJ IDEA or Eclipse.
-   A database server (Oracle was used for development).
-   A web server like Apache Tomcat (for non-Spring Boot projects).

### How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/Java-Full-Stack-Milestone-Projects.git](https://github.com/your-username/Java-Full-Stack-Milestone-Projects.git)
    ```
2.  **Navigate to a project folder:**
    ```bash
    cd Java-Full-Stack-Milestone-Projects/12-spring-boot-hibernate-crud-app
    ```
3.  **Database Setup:** Run the SQL scripts provided within each project's directory to create the necessary tables and initial data.
4.  **Configuration:** For projects involving databases (JDBC, Hibernate, Spring), update the database connection details in the relevant configuration file (e.g., `DBUtil.java`, `hibernate.cfg.xml`, or `application.properties`).
5.  **Run the Application:**
    -   For **console applications**, compile and run the main Java class.
    -   For **Servlet/JSP applications**, build a `.war` file and deploy it to a Tomcat server.
    -   For the **Spring Boot application**, you can run it directly from your IDE or use Maven:
        ```bash
        mvn spring-boot:run
        ```
