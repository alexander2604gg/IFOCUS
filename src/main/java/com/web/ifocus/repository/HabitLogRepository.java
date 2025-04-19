package com.web.ifocus.repository;

import com.web.ifocus.entity.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
}