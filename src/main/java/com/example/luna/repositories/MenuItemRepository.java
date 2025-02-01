package com.example.luna.repositories;

import com.example.luna.domain.menuItem.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {
}
