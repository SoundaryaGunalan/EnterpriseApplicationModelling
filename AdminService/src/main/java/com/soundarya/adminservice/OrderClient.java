package com.soundarya.adminservice;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("order-service")
public interface OrderClient {

    @PostMapping("/api/orders")
    OrderDto createOrder(@RequestBody OrderDto orderDto);

    @GetMapping("/api/orders")
    List<OrderDto> getAllOrders();


    @PutMapping("/api/orders/{id}")
    OrderDto updateOrder(@PathVariable Integer id, @RequestBody OrderDto orderDto);

    @DeleteMapping("/api/orders/{id}")
    Void deleteOrder(@PathVariable Integer id);

}
