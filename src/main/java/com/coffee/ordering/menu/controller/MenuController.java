package com.coffee.ordering.menu.controller;
import com.coffee.ordering.menu.service.MenuService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.coffee.ordering.menu.dto.CategoryResponse;
import com.coffee.ordering.menu.dto.CreateCategoryRequest;

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

}
