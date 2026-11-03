package com.coffee.ordering.menu.repository;

import com.coffee.ordering.menu.entity.ItemOption;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long>{

    List<ItemOption> findByMenuItemId(Long menuItemId);

}
