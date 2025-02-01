package com.example.luna.controllers;

import com.example.luna.domain.menuItem.ResponseMenuItemDTO;
import com.example.luna.domain.user.UserEntity;
import com.example.luna.repositories.UserRepository;
import com.example.luna.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/menu")
@CrossOrigin(origins = "*")
public class PublicMenuController {


    @Autowired
    MenuItemService menuItemService;

    @Autowired
    UserRepository userRepository;

//    @GetMapping
//    public List<ResponseMenuItemDTO> getMenuItems() {
//        return menuItemService.getAllMenuItems();
//    }

    @GetMapping
    public List<UserEntity> teste() {
        return userRepository.findAll();
    }
}
