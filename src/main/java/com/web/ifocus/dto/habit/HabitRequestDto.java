package com.web.ifocus.dto.habit;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
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

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha de inicio no puede ser pasada")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate startAt;

    @NotNull(message = "La fecha de fin es obligatoria")
    @FutureOrPresent(message = "La fecha de fin no puede ser pasada")
    private LocalDate endAt;


    @NotNull(message = "El ID del usuario no puede ser nulo")
    private Long userId;

    private Long defaultCategoryId;


    private Long personalizedCategoryId;
}