package com.coffee.ordering.menu.dto;
import com.coffee.ordering.menu.entity.OptionKind;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateOptionRequest(
        @NotNull Long menuItemId,
        @NotNull OptionKind kind,
        @NotBlank String name,
        @NotNull @PositiveOrZero BigDecimal priceDelta) {}
