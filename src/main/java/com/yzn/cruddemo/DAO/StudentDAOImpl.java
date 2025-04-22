package com.yzn.cruddemo.DAO;

import com.yzn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    // Since we are performing an update on the database/table
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

    // Implement the findAll method

    @Override
    public List<Student> findAll() {
        // Create query
        // (Student) is the name of JPA Entity(class name)
        // All JPQL syntax is based on entity name and entity fields

        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);

        // Default sort is ascending
       // TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName asc",Student.class);

        // Default sort is ascending
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc",Student.class);

        // Return query results
        return query.getResultList();
    }

    // Implement the findByLastName method

    @Override
    public List<Student> findByLastName(String data) {
        // Create the query
        // JPQL Named parameters are prefixed with a colon (:)
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        // Set the query parameters
        query.setParameter("data", data);

        // Return the query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        // Perform an update on the student object
        entityManager.merge(student);
    }

    @Override
    // Since we're performing an update on the database/table
    @Transactional
    public void delete(Integer id) {
        // Retrieve the student
        Student student = entityManager.find(Student.class,id);

        // Delete the student
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
        // return the number of rows deleted from the table
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
