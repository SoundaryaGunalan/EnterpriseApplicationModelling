package com.soundarya.productsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // Create Operation
    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.createProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        System.out.println("Headers of create Product : >>>>>>>>>"+headers);
        return ResponseEntity.ok().headers(headers).body(createdProduct);
        //return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Read Operations
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Integer id) {
        Optional<Products> product = productService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update Operation
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Integer id, @RequestBody Products updatedProduct) {
        Products product = productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Delete Operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
