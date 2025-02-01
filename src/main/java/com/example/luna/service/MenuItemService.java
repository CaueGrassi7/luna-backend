package com.example.luna.service;

import com.example.luna.dto.RequestMenuItemDTO;
import com.example.luna.dto.ResponseMenuItemDTO;
import com.example.luna.entity.MenuItemEntity;
import com.example.luna.mapper.MenuItemMapper;
import com.example.luna.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    @Autowired
    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<ResponseMenuItemDTO> getAllMenuItems() {
        return repository.findAll()
                .stream()
                .map(MenuItemMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ResponseMenuItemDTO getMenuItemById(Long id) {
        MenuItemEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id " + id));
        return MenuItemMapper.toResponseDTO(entity);
    }

    public ResponseMenuItemDTO createMenuItem(RequestMenuItemDTO requestDto) {
        MenuItemEntity entity = MenuItemMapper.fromRequestDTO(requestDto);
        MenuItemEntity savedEntity = repository.save(entity);
        return MenuItemMapper.toResponseDTO(savedEntity);
    }

    public ResponseMenuItemDTO updateMenuItem(Long id, RequestMenuItemDTO requestDto) {
        MenuItemEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id " + id));
        existingEntity.setName(requestDto.name());
        existingEntity.setDescription(requestDto.description());
        existingEntity.setPrice(requestDto.price());
        existingEntity.setCategory(requestDto.category());

        MenuItemEntity updatedEntity = repository.save(existingEntity);
        return MenuItemMapper.toResponseDTO(updatedEntity);
    }

    public void deleteMenuItem(Long id) {
        repository.deleteById(id);
    }
}
