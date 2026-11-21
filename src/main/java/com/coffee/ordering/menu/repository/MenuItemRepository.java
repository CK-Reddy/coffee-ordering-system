package com.coffee.ordering.menu.repository;

import com.coffee.ordering.menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{

    List<MenuItem> findByCategoryId(Long categoryId);

}
