package com.web.ifocus.repository;
import com.web.ifocus.entity.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSec, Long>{

}
