package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployee() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
