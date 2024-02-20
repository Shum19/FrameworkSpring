CREATE TABLE IF NOT EXISTS users (
        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        user_name VARCHAR (45) NOT NULL,
        password TEXT NOT NULL,
        role VARCHAR(45) NOT NULL
);