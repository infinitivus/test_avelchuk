package repository;

import controllers.PersonData;
import models.Person;

import javax.persistence.EntityManager;
import javax.persistence.*;

public class SQLPersonRepository implements IPersonRepository { // Preparing to connect to the database

    private final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    private EntityManager manager;

    public SQLPersonRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void updateAuthPerson(PersonData data, Integer numRecord) {
        manager = managerFactory.createEntityManager();
        Person person = new Person(numRecord, data.getEmail(), data.getPassword(), true);
        manager.merge(person);
    }

    @Override
    public void save(Person person) {
        manager = managerFactory.createEntityManager();
        manager.persist(person);
    }

    @Override
    public int checkEmail(String email) {
        manager = managerFactory.createEntityManager();
        Query query = manager.createNativeQuery("from Person where email=:search");
        Person person = (Person) query.setParameter("search", email);
        if (!(person == null)) {
            return person.getId();
        }
        return -1;
    }

    @Override
    public Person getPerson(Integer id) {
        manager = managerFactory.createEntityManager();
        return manager.find(Person.class, id);
    }
}
