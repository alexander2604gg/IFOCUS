package com.web.ifocus.repository;

import com.web.ifocus.entity.RolPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPermissionRepository extends JpaRepository<RolPermission, Long> {
}