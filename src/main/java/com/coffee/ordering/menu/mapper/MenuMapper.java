package com.coffee.ordering.menu.mapper;

import com.coffee.ordering.menu.entity.ItemOption;
import com.coffee.ordering.menu.entity.MenuCategory;
import com.coffee.ordering.menu.entity.MenuItem;
import com.coffee.ordering.menu.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "items", ignore = true)
    MenuCategory toEntity(CreateCategoryRequest request);

    CategoryResponse toResponse(MenuCategory category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "available", ignore = true)
    @Mapping(target = "options", ignore = true)
    @Mapping(target = "category", ignore = true)
    MenuItem toEntity(CreateItemRequest request);

    @Mapping(target = "categoryId", source = "category.id")
    MenuItemResponse toResponse(MenuItem item);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "menuItem", ignore = true)
    ItemOption toEntity(CreateOptionRequest request);

    @Mapping(target = "menuItemId", source = "menuItem.id")
    ItemOptionResponse toResponse(ItemOption option);
}
