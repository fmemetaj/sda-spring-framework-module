package com.java38.spring_framework.lectures.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeIsBetween(Integer ageMin, Integer ageMax);
    Optional<Student> findByNameAndEmail(String name, String email);
}
