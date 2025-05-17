package com.web.ifocus.dto.habit;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

/**
 * Datos de entrada para crear o actualizar un hábito.
 * Se debe especificar exactamente una categoría: defaultCategoryId o personalizedCategoryId.
 */
@Getter
@Setter
public class HabitRequestDto {
    @NotBlank(message = "El nombre del hábito no puede estar vacío")
    private String habitName;

    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate startAt;

    private LocalDate endAt;

    /** El ID del usuario que crea el hábito */
    @NotNull(message = "El ID del usuario no puede ser nulo")
    private Long userId;

    /** XOR con personalizedCategoryId */
    private Long defaultCategoryId;

    /** XOR con defaultCategoryId */
    private Long personalizedCategoryId;
}