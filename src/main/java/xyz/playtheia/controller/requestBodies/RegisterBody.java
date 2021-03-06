package xyz.playtheia.controller.requestBodies;

public class RegisterBody {

    private String email;
    private String password;
    private String userName;

    public RegisterBody(String email, String userName, String password) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
