-- Drop the database if it exists
DROP DATABASE IF EXISTS anggaran_app;

-- Create the database
CREATE DATABASE anggaran_app;

-- Use the database
USE anggaran_app;

-- Tabel Categories
CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50)
);

INSERT INTO Categories (category_name)
VALUES
    ('Transportasi'),
    ('Akomodasi'),
    ('Konsumsi'),
    ('Hiburan'),
    ('Lain-lain');

-- Tabel User
CREATE TABLE `User` (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    full_name VARCHAR(100)
);

-- Buat akun default untuk admin
INSERT INTO `User` (username, password, email, full_name) VALUES ('admin', 'admin123', 'admin@example.com', 'SUPERADMIN');

-- Buat akun dummy
INSERT INTO `User` (username, password, email, full_name) VALUES ('user', 'user123', 'user@example.com', 'USER');

-- Tabel Trip
CREATE TABLE Trip (
    trip_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(200),
    destination VARCHAR(100),
    start_date DATE,
    end_date DATE,
    total_budget DECIMAL(10, 2),
    actual_expenses DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES `User`(user_id) ON DELETE CASCADE
);

-- Tabel Expenses
CREATE TABLE Expenses (
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    trip_id INT,
    expense_date DATE,
    description VARCHAR(200),
    amount DECIMAL(10, 2),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE CASCADE,
    FOREIGN KEY (trip_id) REFERENCES Trip(trip_id) ON DELETE CASCADE
);
