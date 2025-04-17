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
@Table(name = "Habit_Schedule_Monthly")
public class HabitScheduleMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitScheduleMonthlyId;

    private int dayOfMonth;

    @OneToOne
    @JoinColumn(name = "habit_schedule_id")
    private HabitSchedule habitSchedule;
}
