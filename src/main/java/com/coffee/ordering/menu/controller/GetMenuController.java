package com.coffee.ordering.menu.controller;

import com.coffee.ordering.menu.service.MenuService;
import com.coffee.ordering.menu.dto.CategoryMenuResponse;
import com.coffee.ordering.menu.dto.MenuItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

    @RestController
    @RequestMapping("/menu")
    public class GetMenuController{
        private final MenuService menuService;
        public GetMenuController(MenuService menuService){ this.menuService = menuService;}

        @GetMapping()
        public ResponseEntity<List<CategoryMenuResponse>> getMenu(){
            return ResponseEntity.ok(menuService.getMenu());
        }

        @GetMapping("/items/{id}")
        public ResponseEntity<MenuItemResponse> getItem(@PathVariable Long id){
            return ResponseEntity.ok(menuService.getItem(id));
        }
    }

