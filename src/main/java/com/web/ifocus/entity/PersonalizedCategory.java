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
@Table(name = "Personalized_Category")
public class PersonalizedCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personalizedCategoryId;
    private String name;
    private String description;
    private String icon;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserSec user;
}
