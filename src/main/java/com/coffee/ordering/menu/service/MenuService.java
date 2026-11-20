package com.coffee.ordering.menu.service;
import com.coffee.ordering.menu.dto.CategoryResponse;
import com.coffee.ordering.menu.dto.CreateCategoryRequest;
import com.coffee.ordering.menu.mapper.MenuMapper;
import com.coffee.ordering.menu.entity.MenuCategory;
import com.coffee.ordering.menu.repository.MenuCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

    private final MenuCategoryRepository categoryRepository;
    private final MenuMapper mapper;

    public MenuService(MenuCategoryRepository categoryRepository, MenuMapper mapper ){
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Transactional
    public CategoryResponse createCategory(CreateCategoryRequest request){
        MenuCategory category = mapper.toEntity(request);
        MenuCategory saved = categoryRepository.save(category);
        return mapper.toResponse(saved);
    }
}
