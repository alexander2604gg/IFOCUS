package com.web.ifocus.dto.personalized_category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PersonalizedCategoryUpdateDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String name;

    @Size(max = 120, message = "La descripción no puede tener más de 120 caracteres")
    private String description;

    @Size(max = 120, message = "El icono no puede tener más de 120 caracteres")
    private String icon;

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
