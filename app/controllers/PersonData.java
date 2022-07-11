package controllers;

import play.data.validation.Constraints;

 public class PersonData {

    @Constraints.Pattern("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$") // Проверка правильности почты
    private String email;

   @Constraints.MinLength(6) // Проверка длинны пароля
   private String password;

    public PersonData() {
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
}
