package com.java38.spring_framework.lectures.thymeleaf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MVCUserRepository extends JpaRepository<MVCUser, Long> {
}
