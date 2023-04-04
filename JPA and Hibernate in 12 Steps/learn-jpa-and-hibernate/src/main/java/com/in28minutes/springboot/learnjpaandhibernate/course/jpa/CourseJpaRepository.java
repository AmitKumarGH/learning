package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    //when you'd want to make use of JPA to talk to the database
    //you need to make use of something called EntityManager.
    //@Autowired  //While autowired also would work there is a better recommendation for annotation.
                // So instead of saying @ autowired you can also say @ persistence context.
    @PersistenceContext
    private EntityManager entityManager;//So we created an entity and we will use
                                        //an entity manager to manage our entity-Jakarta persistence
                                        // entity manager
    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }
    public void deleteById(long id){
        //So delete by ID and the way you would execute the delete is a little bit more complex.
        //So what I would need to do is to find the entity.
        //assign it to a local variable, course
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
