package com.web.ifocus.repository;

import com.web.ifocus.entity.HabitScheduleMonthly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitScheduleMonthlyRepository extends JpaRepository<HabitScheduleMonthly, Long> {
}