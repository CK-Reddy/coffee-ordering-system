package com.coffee.ordering.menu.dto;
import jakarta.validation.constraints.*;

public record CreateCategoryRequest (
    @NotBlank String name,
    String description) {}

