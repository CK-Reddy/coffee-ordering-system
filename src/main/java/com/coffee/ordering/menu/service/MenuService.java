package com.coffee.ordering.menu.service;
import com.coffee.ordering.menu.dto.CategoryResponse;
import com.coffee.ordering.menu.dto.CreateCategoryRequest;
import com.coffee.ordering.menu.dto.CreateItemRequest;
import com.coffee.ordering.menu.dto.MenuItemResponse;
import com.coffee.ordering.menu.dto.ItemOptionResponse;
import com.coffee.ordering.menu.dto.CreateOptionRequest;
import com.coffee.ordering.menu.dto.UpdateAvailabilityRequest;
import com.coffee.ordering.menu.entity.ItemOption;
import com.coffee.ordering.menu.mapper.MenuMapper;
import com.coffee.ordering.menu.entity.MenuCategory;
import com.coffee.ordering.menu.entity.MenuItem;
import com.coffee.ordering.menu.repository.MenuCategoryRepository;
import com.coffee.ordering.menu.repository.MenuItemRepository;
import com.coffee.ordering.menu.repository.ItemOptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MenuService {

    private final MenuCategoryRepository categoryRepository;
    private final MenuMapper mapper;
    private final MenuItemRepository itemRepository ;
    private final ItemOptionRepository itemOptionRepository;

    public MenuService(MenuCategoryRepository categoryRepository, MenuMapper mapper, MenuItemRepository itemRepository, ItemOptionRepository itemOptionRepository){
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.itemRepository = itemRepository;
        this.itemOptionRepository = itemOptionRepository;
    }

    @Transactional
    public CategoryResponse createCategory(CreateCategoryRequest request){
        MenuCategory category = mapper.toEntity(request);
        MenuCategory saved = categoryRepository.save(category);
        return mapper.toResponse(saved);
    }

    @Transactional
    public MenuItemResponse createItem(CreateItemRequest request){
        MenuCategory category = categoryRepository.findById(request.categoryId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found: " + request.categoryId()));
        MenuItem item = mapper.toEntity(request);
        item.setCategory(category);
        MenuItem saved = itemRepository.save(item);
        return mapper.toResponse(saved);
    }

    @Transactional
    public ItemOptionResponse createOption(CreateOptionRequest request){
        MenuItem menuItem = itemRepository.findById(request.menuItemId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu Item not found: " + request.menuItemId()));
        ItemOption itemOption = mapper.toEntity(request);
        itemOption.setMenuItem(menuItem);
        ItemOption saved = itemOptionRepository.save(itemOption);
        return mapper.toResponse(saved);
    }

    @Transactional
    public MenuItemResponse updateAvailability(UpdateAvailabilityRequest request, Long id){
    MenuItem menuItem = itemRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu Item not found: " + id));
        menuItem.setAvailable(request.available());
        MenuItem saved = itemRepository.save(menuItem);
        return mapper.toResponse(saved);
    }

}
