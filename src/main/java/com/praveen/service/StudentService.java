package com.praveen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.praveen.model.Student;
import com.praveen.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student Not Found"));
    }

    public List<Student> getAll() {

        List<Student> students = new ArrayList<>();

        repository.findAll().forEach(students::add);

        return students;
    }

    public Student update(Long id, Student student) {

        Student existing = getById(id);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}