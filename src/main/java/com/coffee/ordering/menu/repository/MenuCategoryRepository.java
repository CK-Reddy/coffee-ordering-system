package com.coffee.ordering.menu.repository;

import com.coffee.ordering.menu.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository <MenuCategory, Long> {
}
