package com.khg.springdatabaseudemy.jpa;

import com.khg.springdatabaseudemy.entity.Person;
import com.khg.springdatabaseudemy.jdbc.PersonRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> personTypedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return personTypedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person updatePerson(Person person) {
        return entityManager.merge(person);
    }

    public Person insertPerson(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
