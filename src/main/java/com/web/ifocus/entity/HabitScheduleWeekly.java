package com.web.ifocus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Habit_Schedule_Weekly")
public class HabitScheduleWeekly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitScheduleWeeklyId;
    private String dayOfWeek;
    @OneToOne
    @JoinColumn(name = "habit_schedule_id")
    private HabitSchedule habitSchedule;
}
