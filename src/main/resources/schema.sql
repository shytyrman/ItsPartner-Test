CREATE TABLE APP_USER (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         login VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         name VARCHAR(255),
                         surname VARCHAR(255),
                         email VARCHAR(255),
                         user_role VARCHAR(255) NOT NULL
);
