package com.web.ifocus.repository;

import com.web.ifocus.entity.DefaultCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultCategoryRepository extends JpaRepository<DefaultCategory, Long> {
}