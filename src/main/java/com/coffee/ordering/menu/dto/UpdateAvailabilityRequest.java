package com.coffee.ordering.menu.dto;
import jakarta.validation.constraints.*;

public record UpdateAvailabilityRequest (
        @NotNull Boolean available
){}
