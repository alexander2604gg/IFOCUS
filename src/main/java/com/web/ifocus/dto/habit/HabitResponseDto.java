
package com.web.ifocus.dto.habit;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class HabitResponseDto {
    private Long habitId;
    private String habitName;
    private LocalDate startAt;
    private LocalDate endAt;
    private Long userId;
    private Long defaultCategoryId;
    private Long personalizedCategoryId;
}
