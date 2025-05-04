package com.web.ifocus.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.web.ifocus.entity.PersonalizedCategory;
import com.web.ifocus.repository.PersonalizedCategoryRepository;

@Service
public class PersonalizedCategoryService {

    private final PersonalizedCategoryRepository personalizedCategoryRepository;

    public PersonalizedCategoryService(PersonalizedCategoryRepository personalizedCategoryRepository) {
        this.personalizedCategoryRepository = personalizedCategoryRepository;
    }

    // Método para crear una categoría personalizada
    public PersonalizedCategory createCategory(PersonalizedCategory category) {
        return personalizedCategoryRepository.save(category);
    }

    // Método para obtener todas las categorías personalizadas
    public List<PersonalizedCategory> getAllCategories() {
        return personalizedCategoryRepository.findAll();
    }

    // Método para obtener una categoría por ID
    public Optional<PersonalizedCategory> getCategoryById(Long id) {
        return personalizedCategoryRepository.findById(id);
    }

    // Método para actualizar una categoría personalizada
    public PersonalizedCategory update(Long id, PersonalizedCategory category) {
        // Buscar la categoría existente
        PersonalizedCategory existingCategory = personalizedCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría personalizada no encontrada"));

        // Actualizar los valores
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setIcon(category.getIcon());

        // Guardar y devolver la categoría actualizada
        return personalizedCategoryRepository.save(existingCategory);
    }

    // Método para eliminar una categoría personalizada
    public void delete(Long id) {
        // Verificar si la categoría existe antes de eliminarla
        PersonalizedCategory category = personalizedCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría personalizada no encontrada"));

        // Eliminar la categoría de la base de datos
        personalizedCategoryRepository.delete(category);
    }
}
