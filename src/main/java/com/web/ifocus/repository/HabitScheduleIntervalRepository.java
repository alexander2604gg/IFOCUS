package com.web.ifocus.repository;

import com.web.ifocus.entity.HabitScheduleInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitScheduleIntervalRepository extends JpaRepository<HabitScheduleInterval, Long> {
}