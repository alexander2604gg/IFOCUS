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
@Table(name = "Habit_Schedule")
public class HabitSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitScheduleId;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @ManyToOne
    @JoinColumn(name = "frequency_type_id")
    private FrequencyType frequencyType;
}
