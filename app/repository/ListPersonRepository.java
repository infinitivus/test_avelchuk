package repository;

import controllers.PersonData;
import models.Person;

import java.util.List;

public class ListPersonRepository implements IPersonRepository {

    public List<Person> persons;

    public ListPersonRepository() {
        this.persons = com.google.common.collect.Lists.newArrayList();
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void updateAuthPerson(PersonData data, Integer numRecord) {
        persons.add(numRecord, new Person(data.getEmail(), data.getPassword(), true));
    }

    @Override
    public int checkEmail(String email) {
        for (Person per : persons) {
            if (per.getEmail().equals(email)) {
                return persons.indexOf(per);
            }
        }
        return -1;
    }

    @Override
    public Person getPerson(Integer numRecord) {
        return persons.get(numRecord);
    }
}
