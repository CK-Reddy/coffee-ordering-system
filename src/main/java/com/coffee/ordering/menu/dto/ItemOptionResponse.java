package com.coffee.ordering.menu.dto;
import java.math.BigDecimal;
import com.coffee.ordering.menu.entity.OptionKind;

public record ItemOptionResponse(

        Long id, Long menuItemId, OptionKind kind, String name, BigDecimal priceDelta) {}
