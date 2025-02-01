package com.example.luna.dto;

import com.example.luna.entity.enums.ItemCategory;
import java.math.BigDecimal;

public record RequestMenuItemDTO(
        String name,
        String description,
        BigDecimal price,
        ItemCategory category
) { }