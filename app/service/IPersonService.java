package service;

import com.google.inject.ImplementedBy;
import controllers.PersonData;

@ImplementedBy(PersonService.class)
public interface IPersonService {

 public void setAuthorisation(PersonData data,Integer numRecord);

    public String encodingPassword(String password);

    public boolean checkPassword(String password, int numRecord);

    public int checkDuplicationEmail(String email);

    public void savePerson(PersonData data);

    public void sendMessageEmailRegistration(String email,String password);

    public boolean getAuthorisation(Integer numRecord);
}
