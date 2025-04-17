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
@Table(name = "Frequency_Type")
public class FrequencyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long frequencyTypeId;
    private String name;
    private String description;
}
