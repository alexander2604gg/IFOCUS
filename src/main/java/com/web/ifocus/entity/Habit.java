package com.web.ifocus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Habit")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitId;

    private String habitName;
    private LocalDate startAt;
    private LocalDate endAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserSec user;
    @ManyToOne
    @JoinColumn(name = "default_category_id")
    private DefaultCategory defaultCategory;
    @ManyToOne
    @JoinColumn(name = "personalized_category_id")
    private PersonalizedCategory personalizedCategory;
}
