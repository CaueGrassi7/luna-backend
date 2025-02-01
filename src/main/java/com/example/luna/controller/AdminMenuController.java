package com.example.luna.controller;

import com.example.luna.dto.RequestMenuItemDTO;
import com.example.luna.dto.ResponseMenuItemDTO;
import com.example.luna.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/menu")
@CrossOrigin(origins = "*")
public class AdminMenuController {

    private final MenuItemService menuItemService;

    @Autowired
    public AdminMenuController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<ResponseMenuItemDTO> createMenuItem(@RequestBody RequestMenuItemDTO requestDto) {
        ResponseMenuItemDTO responseDto = menuItemService.createMenuItem(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMenuItemDTO> updateMenuItem(@PathVariable Long id,
                                                              @RequestBody RequestMenuItemDTO requestDto) {
        ResponseMenuItemDTO updatedDto = menuItemService.updateMenuItem(id, requestDto);
        return ResponseEntity.ok(updatedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMenuItemDTO> getMenuItem(@PathVariable Long id) {
        ResponseMenuItemDTO responseDto = menuItemService.getMenuItemById(id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
