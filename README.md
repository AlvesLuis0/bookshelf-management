![Bookshelf Banner](.github/banner.jpg)

# 📚 Bookshelf Management API

REST API for managing books on a *"virtual bookshelf"*

## 📝 Features

- [x] Display the list of books on the bookshelf
- [x] Add a new book to the bookshelf
- [x] Update the details of an existing book
- [x] Delete a book from the bookshelf

## 👾 Demo

![Home Page](.github/home-page.png)
![Request](.github/request.png)

## ❓ How to Use

### ✋ Prerequisites

Before starting, you will need to have the following tools installed on your machine:
[Git](https://git-scm.com), [JDK 17](https://www.oracle.com/java/), [Maven](https://maven.apache.org/), [Postgres](https://www.postgresql.org/). 
Furthermore, it is good to have an editor to work with the code like [VSCode](https://code.visualstudio.com/)

### 🚀 Running

```bash
# Clone this repository
git clone https://github.com/alvesluis0/bookshelf-management

# Access the project folder in terminal/cmd
cd bookshelf-management

# Create a database and configure the application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookshelf_management_api
spring.datasource.username=postgres
spring.datasource.password=postgres

# Install the application
mvn package

# Run the application
java -jar target/bookshelf-management-api.jar

# The server will start on port:8080 - access <http://localhost:8080/swagger-ui.html> to test
```

## 🛠 Technologies

The following tools were used to build the project:

- [Java 17](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/)
- [Postgres](https://www.postgresql.org/)

## 🔖 Learnings

- Connection to the Postgres database
- Document API with Swagger