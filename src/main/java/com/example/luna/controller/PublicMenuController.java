package com.example.luna.controller;

import com.example.luna.dto.ResponseMenuItemDTO;
import com.example.luna.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/menu")
@CrossOrigin(origins = "*")
public class PublicMenuController {

    private final MenuItemService menuItemService;

    @Autowired
    public PublicMenuController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<ResponseMenuItemDTO> getMenuItems() {
        return menuItemService.getAllMenuItems();
    }
}
