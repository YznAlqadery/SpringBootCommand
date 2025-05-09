
#   SpringBootCommand

A command-line CRUD application built with Spring Boot, JPA (Hibernate), and MySQL. This project uses a traditional `Entity` and `DAO` design pattern to manage database operations without exposing a web interface. Perfect for backend learners and CLI tool prototyping.

## 📌 Features

- Full CRUD operations via `CommandLineRunner`
- Uses Entity and DAO (no Spring Data Repository)
- Console-based application with no web layer
- Logs database actions to the terminal
---


## Installation

1️⃣ Clone this repository:  
```bash
git clone https://github.com/YznAlqadery/SpringBootCommand.git
cd SpringBootCommand
mvn clean install
```
2️⃣ Configure MySQL:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
3️⃣ Run the App:
```bash
mvn spring-boot:run
```


    
## 🧰 Tech Stack

- Java 17+
- Spring Boot 3.x
- Hibernate (JPA)
- MySQL
- Maven



## 📂 Project Structure

- `entity/` — Contains JPA entity classes representing database tables  
- `dao/` — Contains DAO interfaces and their implementations for CRUD operations  
- `CruddemoApplication.java` — The main class that executes all database operations using `CommandLineRunner`
## 🧪 Example Behavior

When the application starts, it performs a sequence of CRUD operations through the command line:

- 🟢 **Create**: Adds new records to the database using the DAO layer.
- 🔵 **Read**: Fetches and displays all records or specific entries.
- 🟡 **Update**: Modifies existing records (e.g., updates a field like name or status).
- 🔴 **Delete**: Removes specific records from the database.

All actions are logged to the terminal for easy visibility and debugging.## 📫 Contact

Created by [Yazan Al-Qadery](https://github.com/YznAlqadery) — feel free to reach out via GitHub if you have any questions or suggestions!