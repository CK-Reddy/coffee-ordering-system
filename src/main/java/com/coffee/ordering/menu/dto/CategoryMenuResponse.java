package com.coffee.ordering.menu.dto;
import java.util.*;

public record CategoryMenuResponse (
        Long categoryId,
        String categoryName,
        List<MenuItemResponse> items
){}
