package com.coffee.ordering.menu.controller;
import com.coffee.ordering.menu.service.MenuService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.coffee.ordering.menu.dto.CategoryResponse;
import com.coffee.ordering.menu.dto.CreateCategoryRequest;
import com.coffee.ordering.menu.dto.MenuItemResponse;
import com.coffee.ordering.menu.dto.CreateItemRequest;
import com.coffee.ordering.menu.dto.CreateOptionRequest;
import com.coffee.ordering.menu.dto.ItemOptionResponse;
import com.coffee.ordering.menu.dto.UpdateAvailabilityRequest;
import java.util.List;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(
        @Valid @RequestBody CreateCategoryRequest request) {
       CategoryResponse response = menuService.createCategory(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/items")
    public ResponseEntity<MenuItemResponse> createItem(
            @Valid @RequestBody CreateItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.createItem(request));
    }

    @PatchMapping("/items/{id}/availability")
    public ResponseEntity<MenuItemResponse> updateAvailability(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAvailabilityRequest request){
        return ResponseEntity.ok(menuService.updateAvailability(request, id));
    }

    @PostMapping("/options")
    public ResponseEntity<ItemOptionResponse> createOption(
            @Valid @RequestBody CreateOptionRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.createOption(request));
    }
}
