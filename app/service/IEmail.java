package service;

import com.google.inject.ImplementedBy;

@ImplementedBy(Mail.class)
public interface IEmail {

    public void sendMessageEmailRegistration(String email,String password);
}
