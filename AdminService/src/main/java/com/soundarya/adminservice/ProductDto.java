package com.soundarya.adminservice;

import java.math.BigDecimal;
public record ProductDto(Integer id, String name, String description, BigDecimal price, Integer stock, String imageId) {
}
