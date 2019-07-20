package com.bs23.travelagencynetwork.repository;

import com.bs23.travelagencynetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
