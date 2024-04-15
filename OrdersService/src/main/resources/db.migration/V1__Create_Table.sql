-- Create the Products table
CREATE TABLE Products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          stock INT NOT NULL,
                          image_id VARCHAR(50) NOT NULL
);

-- Create the Orders table
CREATE TABLE Orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        order_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        total_price DECIMAL(10, 2) NOT NULL
);

-- Create a table to store the relationship between orders and products
CREATE TABLE Order_Products (
                                order_id INT NOT NULL,
                                product_id INT NOT NULL,
                                quantity INT NOT NULL,
                                PRIMARY KEY (order_id, product_id),
                                FOREIGN KEY (order_id) REFERENCES Orders(id),
                                FOREIGN KEY (product_id) REFERENCES Products(id)
);
