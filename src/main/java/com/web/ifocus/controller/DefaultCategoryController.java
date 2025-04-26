package com.web.ifocus.controller;

import com.web.ifocus.dto.default_category.DefaultCategoryResponseDto;
import com.web.ifocus.service.default_category.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/default_categories")  
public class DefaultCategoryController {

    private final DefaultCategoryService defaultCategoryService;

    public DefaultCategoryController(DefaultCategoryService defaultCategoryService) {
        this.defaultCategoryService = defaultCategoryService;
    }

    @GetMapping
    public List<DefaultCategoryResponseDto> getAll() {
        return defaultCategoryService.getAll();
    }

}
