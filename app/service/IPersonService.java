package service;

import com.google.inject.ImplementedBy;
import controllers.PersonData;
import models.Person;

@ImplementedBy(PersonService.class)
public interface IPersonService {

    public void savePerson(PersonData data);

    public Person checkAuthentication(PersonData data);

    public boolean registration(PersonData data);

    public Person authorisation(PersonData data);

    public String encodingPassword(String password);


}
