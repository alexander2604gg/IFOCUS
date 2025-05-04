package com.web.ifocus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import com.web.ifocus.entity.PersonalizedCategory;
import com.web.ifocus.service.PersonalizedCategoryService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class PersonalizedCategoryController {

    private final PersonalizedCategoryService personalizedCategoryService;

    public PersonalizedCategoryController(PersonalizedCategoryService personalizedCategoryService) {
        this.personalizedCategoryService = personalizedCategoryService;
    }

    // Endpoint para crear una categoría personalizada
    @PostMapping
    public ResponseEntity<PersonalizedCategory> createCategory(@RequestBody PersonalizedCategory category) {
        PersonalizedCategory createdCategory = personalizedCategoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Endpoint para obtener todas las categorías personalizadas
    @GetMapping
    public ResponseEntity<List<PersonalizedCategory>> getAllCategories() {
        List<PersonalizedCategory> categories = personalizedCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Endpoint para obtener una categoría personalizada por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonalizedCategory> getCategoryById(@PathVariable Long id) {
        Optional<PersonalizedCategory> category = personalizedCategoryService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar una categoría personalizada (sin DTO)
    @PutMapping("/{id}")
    public ResponseEntity<PersonalizedCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody PersonalizedCategory category) {
        try {
            PersonalizedCategory updatedCategory = personalizedCategoryService.update(id, category);
            return ResponseEntity.ok(updatedCategory);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

        // Endpoint para eliminar una categoría personalizada
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            personalizedCategoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content, ya que no devuelve cuerpo
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada", e);
        }
    }
}
