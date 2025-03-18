package com.prashant.SpringDataJpaAssignment3.repository;

import com.prashant.SpringDataJpaAssignment3.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}

