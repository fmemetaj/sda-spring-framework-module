package com.java38.spring_framework.lectures.restapi.repository;

import com.java38.spring_framework.lectures.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
