package com.soundarya.productsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soundarya.productsservice.ProductsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductsRepository productRepository;

    public ProductService(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create Operation
    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    // Read Operation
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Update Operation
    public Products updateProduct(Integer id, Products updatedProduct) {
        Products existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setImageId(updatedProduct.getImageId());

        return productRepository.save(existingProduct);
    }

    // Delete Operation
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
