package com.coffee.ordering.menu.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record CreateItemRequest(
        @NotNull Long categoryId,
        @NotBlank String name,
        String description,
        @NotNull @Positive BigDecimal basePrice) {}

