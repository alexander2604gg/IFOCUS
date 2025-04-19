package com.web.ifocus.repository;

import com.web.ifocus.entity.HabitScheduleWeekly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitScheduleWeeklyRepository extends JpaRepository<HabitScheduleWeekly, Long> {
}