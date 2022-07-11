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

    // проверка совпадения паролей +
    @Override
    public boolean checkPassword(String password, int numRecord) {
        return password.equals(repository.getPerson(numRecord).getPassword());
    }

    //проверка наличия емайла  +
    @Override
    public int checkDuplicationEmail(String email) {
        return repository.checkEmail(email);
    }

    // изменение авторизации на true +
    @Override
    public void setAuthorisation(PersonData data, Integer numRecord) {
        repository.updateAuthPerson(data, numRecord);
    }

    // кодирование пароля +
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

    // Запись пользователя  +
    @Override
    public void savePerson(PersonData data) {
        repository.save(new Person(data.getEmail(), encodingPassword(data.getPassword()), false));
    }

    // отправка сообщения о регистрации на почту пользователю
    @Override
    public void sendMessageEmailRegistration(String email, String pass) {
        mail.sendMessageEmailRegistration(email, pass);
    }

    // Получение статуса авторизации
    @Override
    public boolean getAuthorisation(Integer numRecord) {
        return repository.getPerson(numRecord).getAuthorisation();
    }
}
