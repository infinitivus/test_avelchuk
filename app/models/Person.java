package models;

import io.ebean.Model;

public class Person extends Model {

    private Integer id;

    private String email;

    private String password;

    private boolean authorisation;

    public Person() {
    }

    public Person(String email, String password, boolean authorisation) {
        this.email = email;
        this.password = password;
        this.authorisation = authorisation;
    }

    public Person(Integer id, String email, String password, boolean authorisation) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorisation = authorisation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(boolean authorisation) {
        this.authorisation = authorisation;
    }

}
