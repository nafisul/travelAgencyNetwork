package com.bs23.travelagencynetwork.repository;

import com.bs23.travelagencynetwork.entity.Status;
import com.bs23.travelagencynetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Status,Long> {
    List<Status> findByUserEmail(String email);

    @Query(value = "SELECT u FROM Status u WHERE u.postPrivacy = 0 AND u.user = :user")
    List<Status> findByUserWithPrivate(@Param("user") User user);

    @Query(value = "SELECT u FROM Status u WHERE u.postPrivacy = 1")
    List<Status> getAllPublicPost();
}

