package com.soundarya.adminservice;

import com.soundarya.productsservice.Products;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Integer id, LocalDateTime orderDate, BigDecimal totalPrice, List<Products> products) {
}
