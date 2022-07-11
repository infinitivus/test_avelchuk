package repository;

import com.google.inject.ImplementedBy;
import controllers.PersonData;
import models.Person;

@ImplementedBy(ListPersonRepository.class)
public interface IPersonRepository {

    public void updateAuthPerson(PersonData data, Integer numRecord);

    public void save(Person person);

    public int checkEmail(String email);

    public Person getPerson(Integer id);
}
