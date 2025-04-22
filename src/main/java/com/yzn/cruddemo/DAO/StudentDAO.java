package com.yzn.cruddemo.DAO;

import com.yzn.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String data);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
