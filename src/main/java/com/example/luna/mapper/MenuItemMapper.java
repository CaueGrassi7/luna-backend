package com.example.luna.mapper;

import com.example.luna.dto.RequestMenuItemDTO;
import com.example.luna.dto.ResponseMenuItemDTO;
import com.example.luna.entity.MenuItemEntity;

public class MenuItemMapper {

    public static ResponseMenuItemDTO toResponseDTO(MenuItemEntity entity) {
        return new ResponseMenuItemDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory()
        );
    }

    public static MenuItemEntity fromRequestDTO(RequestMenuItemDTO dto) {
        MenuItemEntity entity = new MenuItemEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setCategory(dto.category());
        return entity;
    }
}
