package com.praveen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praveen.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
