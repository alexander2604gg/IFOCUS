package com.web.ifocus.repository;

import com.web.ifocus.entity.FrequencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyTypeRepository extends JpaRepository<FrequencyType, Long> {
}