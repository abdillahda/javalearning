package com.belajar.belajar_java.repository;

import com.belajar.belajar_java.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
