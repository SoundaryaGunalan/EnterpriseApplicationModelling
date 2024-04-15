-- Create the Products table
CREATE TABLE Products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          stock INT NOT NULL,
                          image_id VARCHAR(50) NOT NULL
);
