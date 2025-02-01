package com.example.luna.domain.menuItem;

import java.math.BigDecimal;

public record RequestMenuItemDTO(
        String name,
        String description,
        BigDecimal price,
        ItemCategory category
) { }