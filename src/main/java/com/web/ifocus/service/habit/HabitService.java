package com.web.ifocus.service.habit;

import com.web.ifocus.dto.habit.HabitRequestDto;
import com.web.ifocus.dto.habit.HabitResponseDto;
import com.web.ifocus.entity.DefaultCategory;
import com.web.ifocus.entity.Habit;
import com.web.ifocus.entity.PersonalizedCategory;
import com.web.ifocus.entity.UserSec;
import com.web.ifocus.repository.DefaultCategoryRepository;
import com.web.ifocus.repository.HabitRepository;
import com.web.ifocus.repository.PersonalizedCategoryRepository;
import com.web.ifocus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Lógica de negocio para gestionar hábitos.
 */
@Service
public class HabitService {

    private final HabitRepository habitRepo;
    private final UserRepository userRepo;
    private final DefaultCategoryRepository defaultCatRepo;
    private final PersonalizedCategoryRepository personalCatRepo;

    public HabitService(HabitRepository habitRepo,
                        UserRepository userRepo,
                        DefaultCategoryRepository defaultCatRepo,
                        PersonalizedCategoryRepository personalCatRepo) {
        this.habitRepo             = habitRepo;
        this.userRepo              = userRepo;
        this.defaultCatRepo        = defaultCatRepo;
        this.personalCatRepo       = personalCatRepo;
    }

    /**
     * Crea un hábito validando que se seleccione exactamente una categoría.
     * @throws IllegalArgumentException si falla la validación o no existe alguna entidad.
     */
    @Transactional
public HabitResponseDto createHabit(HabitRequestDto dto) {
    // 1) Validación XOR de categorías
    boolean hasDefault  = dto.getDefaultCategoryId() != null;
    boolean hasPersonal = dto.getPersonalizedCategoryId() != null;
    if (!(hasDefault ^ hasPersonal)) {
        throw new IllegalArgumentException(
            "Debe especificar exactamente una categoría: defaultCategoryId O personalizedCategoryId"
        );
    }

    // 2) Cargar el usuario CON userId
    UserSec user = userRepo.findById(dto.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

    // 3) Mapear entidad Habit
    Habit h = new Habit();
    h.setHabitName(dto.getHabitName());
    h.setStartAt(dto.getStartAt());
    h.setEndAt(dto.getEndAt());
    h.setUser(user);

    if (hasDefault) {
        DefaultCategory def = defaultCatRepo.findById(dto.getDefaultCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("DefaultCategory no encontrada"));
        h.setDefaultCategory(def);
    } else {
        PersonalizedCategory per = personalCatRepo.findById(dto.getPersonalizedCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("PersonalizedCategory no encontrada"));
        h.setPersonalizedCategory(per);
    }

    // 4) Guardar y devolver DTO
    return toDto(habitRepo.save(h));
}

    /**
     * Devuelve todos los hábitos registrados.
     */
    @Transactional(readOnly = true)
    public List<HabitResponseDto> getAllHabits() {
        return habitRepo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve un hábito por su ID, o empty si no existe.
     */
    @Transactional(readOnly = true)
    public Optional<HabitResponseDto> getHabitById(Long id) {
        return habitRepo.findById(id).map(this::toDto);
    }

    // Convierte entidad a DTO
    private HabitResponseDto toDto(Habit h) {
        return new HabitResponseDto(
            h.getHabitId(),
            h.getHabitName(),
            h.getStartAt(),
            h.getEndAt(),
            h.getUser().getUserId(),
            h.getDefaultCategory() != null ? h.getDefaultCategory().getDefaultCategoryId() : null,
            h.getPersonalizedCategory() != null ? h.getPersonalizedCategory().getPersonalizedCategoryId() : null
        );
    }
}