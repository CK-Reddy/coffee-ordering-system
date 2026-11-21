package com.coffee.ordering.menu.dto;
import java.math.BigDecimal;
import java.util.*;

public record MenuItemResponse(
        Long id, Long categoryId, String name, String description,
        BigDecimal basePrice, boolean available,
        List<ItemOptionResponse> options) {}
