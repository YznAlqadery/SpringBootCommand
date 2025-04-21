package com.yzn.cruddemo.DAO;

import com.yzn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Specialized annotation for repositories
// Supports component scanning
// Translates JDBC exceptions

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject the entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Implement the save method

    @Override
    // Since we are performing an update on the database
    @Transactional
    public void save(Student student) {
        // Saves the student to the database
        entityManager.persist(student);
    }

    // Implement the findById method

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }


}
