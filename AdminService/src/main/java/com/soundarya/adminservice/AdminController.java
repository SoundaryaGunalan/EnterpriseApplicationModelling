package com.soundarya.adminservice;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController {

    private final ProductClient productClient;

    private final OrderClient orderClient;

    @GetMapping("/admin-products")
    ResponseEntity<List<ProductDto>> getProducts(){

        return ResponseEntity.ok(productClient.getAllProducts());

    }

    @PostMapping("/admin-products")
    ResponseEntity<List<ProductDto>> createProduct(@RequestBody ProductDto productDto){
        ProductDto createdProduct = productClient.createProduct(productDto);
        List<ProductDto> productList = productClient.getAllProducts();
        productList.add(createdProduct);

        return ResponseEntity.ok(productList);
    }

    @PutMapping("/admin-products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        ProductDto product = productClient.updateProduct(id, productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/admin-products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productClient.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/admin-orders")
    ResponseEntity<List<OrderDto>> getOrders(){

        return ResponseEntity.ok(orderClient.getAllOrders());

    }

    @PostMapping("/admin-orders")
    ResponseEntity<List<OrderDto>> createOrder(@RequestBody OrderDto orderDto){
        OrderDto createdOrder = orderClient.createOrder(orderDto);
        List<OrderDto> orderList = orderClient.getAllOrders();
        orderList.add(createdOrder);

        return ResponseEntity.ok(orderList);
    }

    @PutMapping("/admin-orders/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Integer id, @RequestBody OrderDto orderDto) {
        OrderDto order = orderClient.updateOrder(id, orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    @DeleteMapping("/admin-orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderClient.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
