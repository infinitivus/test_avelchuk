package repository;

import controllers.PersonData;
import models.Person;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.*;

public class SQLPersonRepository implements IPersonRepository {

    private EntityManager entityManager;

    @Inject
    public SQLPersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

    @Override
    public void updateAuthPerson(PersonData data, Integer numRecord) {
    }

    @Override
    public void save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.merge(person);
    }

    @Override
    public int checkEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from Person where surname=:search");
        Person person = (Person) query.setParameter("search", email);
        if (!(person == null)) {
            return person.getId();
        }
        return -1;
    }

    @Override
    public Person getPerson(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Person.class, id);
    }
}
