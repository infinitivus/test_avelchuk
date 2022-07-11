package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person extends Model {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="emals")
    private String email;
    @Column(name="passwords")
    private String password;
    @Column(name="authorisations")
    private boolean authorisation;

    public Person() {
    }

    public Person(String email, String password, boolean authorisation) {
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
