package com.example.luna.dto;

import com.example.luna.entity.enums.ItemCategory;
import java.math.BigDecimal;

public record ResponseMenuItemDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        ItemCategory category
) { }
