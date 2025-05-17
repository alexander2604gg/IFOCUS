package com.web.ifocus.controller;

import com.web.ifocus.dto.habit.HabitRequestDto;
import com.web.ifocus.dto.habit.HabitResponseDto;
import com.web.ifocus.service.habit.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import jakarta.validation.Valid;
import java.util.List;

/**
 * API REST para gestión de hábitos.
 */
@RestController
@RequestMapping("/api/habits")
@Validated
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    /**
     * Crea un nuevo hábito.
     */
    @PostMapping
    public ResponseEntity<HabitResponseDto> create(
            @Valid @RequestBody HabitRequestDto dto
    ) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(habitService.createHabit(dto));
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex
            );
        }
    }

    /**
     * Lista todos los hábitos.
     */
    @GetMapping
    public ResponseEntity<List<HabitResponseDto>> listAll() {
        return ResponseEntity.ok(habitService.getAllHabits());
    }

    /**
     * Obtiene un hábito por ID o devuelve 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<HabitResponseDto> getById(@PathVariable Long id) {
        return habitService.getHabitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}