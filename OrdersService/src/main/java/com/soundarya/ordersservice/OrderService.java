package com.soundarya.ordersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Orders> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Orders updateOrder(Integer id, Orders updatedOrder) {
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setProducts(updatedOrder.getProducts());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
