package jmgomez.wiremock.model;

public class User {
    private String dni;
    private String password;

    public User() {
    }
    public User(String password, String dni) {
        this.password = password;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
