package com.finki.lab1b.demo.service.impl;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Student;
import com.finki.lab1b.demo.repository.StudentRepository;
import com.finki.lab1b.demo.service.interfaces.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return this.studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return this.studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        Student student=new Student(username, password, name, surname);
        DataHolder.studentList.add(new Student(username, password, name, surname));
        return student;
    }
}
