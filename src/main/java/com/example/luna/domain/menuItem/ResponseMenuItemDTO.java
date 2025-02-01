package com.example.luna.domain.menuItem;

import java.math.BigDecimal;

public record ResponseMenuItemDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        ItemCategory category
) { }
