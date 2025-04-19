package com.web.ifocus.repository;

import com.web.ifocus.entity.HabitSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitScheduleRepository extends JpaRepository<HabitSchedule, Long> {
}