package com.praveen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.praveen.model.Student;
import com.praveen.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {

        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Student Deleted";
    }
}