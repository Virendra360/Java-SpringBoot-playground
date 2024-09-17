package com.dev.SpringBootPlayground.repository;

import com.dev.SpringBootPlayground.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
