package com.soundarya.adminservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @PostMapping("/api/products")
    ProductDto createProduct(@RequestBody ProductDto productDto);

    @GetMapping("/api/products/products")
    List<ProductDto> getAllProducts();


    @PutMapping("/api/products/{id}")
    ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto);

    @DeleteMapping("/api/products/{id}")
    Void deleteProduct(@PathVariable Integer id);




}
