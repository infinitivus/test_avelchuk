package service;

import controllers.PersonData;
import models.Person;
import org.springframework.stereotype.Service;
import repository.IPersonRepository;

import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PersonService implements IPersonService {
    private final IPersonRepository repository;
    private final IEmail mail;

    @Inject
    public PersonService(IPersonRepository repository, IEmail mail) {
        this.repository = repository;
        this.mail = mail;
    }

    @Override
    public Person checkAuthentication(PersonData data) {
        int numRecord = repository.checkEmail(data.getEmail());
        if (numRecord >= 0) {
            Person person = repository.getPerson(numRecord);
            String passwordEncoder = encodingPassword(data.getPassword());
            if (passwordEncoder.equals(person.getPassword())) {
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean registration(PersonData data) {
        if (repository.checkEmail(data.getEmail()) >= 0) {
            return false;
        } else {
            if (mail.sendMessageEmailRegistration(data.getEmail(), encodingPassword(data.getPassword()))) {
                savePerson(data);
                return true;
            }
        }
        return false;
    }

    @Override
    public Person authorisation(PersonData data) {
        int numRecord = repository.checkEmail(data.getEmail());
        if (numRecord >= 0) {
            Person person = repository.getPerson(numRecord);
            if (data.getPassword().equals(person.getPassword())) {
                repository.updateAuthPerson(data, numRecord);
                return person;
            }
        }
        return null;
    }

@Override
    public String encodingPassword(String password) {
        byte[] digest = new byte[0];
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] bytePass = password.getBytes();
            digest = digester.digest(bytePass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(digest);
    }

    @Override
    public void savePerson(PersonData data) {
        repository.save(new Person(data.getEmail(), encodingPassword(data.getPassword()), false));
    }
}
