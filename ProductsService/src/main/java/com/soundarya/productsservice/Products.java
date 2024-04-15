package com.soundarya.productsservice;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products") // Define the table name explicitly
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Specify the column name explicitly
    private Integer id; // Updated to Integer for ID column

    @Column(name = "name", nullable = false, length = 255) // Set the column properties
    private String name;

    @Column(name = "description", columnDefinition = "TEXT") // Use columnDefinition for TEXT type
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2) // Set precision and scale for DECIMAL
    private BigDecimal price; // Updated to BigDecimal for price column

    @Column(name = "stock", nullable = false) // Set nullable to false for stock column
    private Integer stock; // Updated to Integer for stock column

    @Column(name = "image_id", nullable = false, length = 50) // Set nullable to false and length for image_id column
    private String imageId;




}
