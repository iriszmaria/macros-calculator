# Macros Calculator

A Java Swing desktop application that calculates calories and protein from a
MySQL food database.

## Features

- Select food from the database
- Enter a quantity in grams or pieces
- Calculate total calories and protein

## Requirements

- Java 24
- Maven
- MySQL

## Database setup

Create a MySQL database named `food` and a table with the following structure:

```sql
CREATE DATABASE food;

USE food;

CREATE TABLE food (
    name VARCHAR(255) PRIMARY KEY,
    calories INT NOT NULL,
    protein INT NOT NULL,
    unit VARCHAR(10) NOT NULL
);
```

The application expects `unit` to contain `gr` for gram-based foods or another
value for piece-based foods.

Create `macros/.env` with your local database settings:

```dotenv
DB_URL=jdbc:mysql://localhost:3306/food
DB_USER=root
DB_PASSWORD=your-password
```

The app loads `.env` from the `macros` directory (or current working directory).
Environment variables take precedence if set. `.env` is gitignored; do not
commit it or share your real password.

## Run

From the repository root:

```powershell
cd macros
mvn clean compile
```

Open `Main.java` in your IDE and run its `main` method.

The main window appears after the application starts. Select
**Calculate Macros**, choose a food, enter a quantity, and select **ENTER**.
