package com.finki.lab1b.demo.repository;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Student;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentRepository {
    // Od 4. imam pristap do studentList bidejki static
    public List<Student> findAllStudents(){
        return DataHolder.studentList;
    }
    public List<Student> findAllByNameOrSurname(String text){
        return DataHolder.studentList.stream().filter(
                // za sekoe s kade s.getName go sodrzi text ili s.getSurname sodrzi text
                s->s.getName().contains(text)   ||  s.getSurname().contains(text))
                // pretvorigo ova vo lista
                .toList();
    }
}
