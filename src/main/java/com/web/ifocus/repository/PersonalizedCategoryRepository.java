package com.web.ifocus.repository;

import com.web.ifocus.entity.PersonalizedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalizedCategoryRepository extends JpaRepository<PersonalizedCategory, Long> {
}