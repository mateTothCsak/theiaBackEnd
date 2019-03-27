package xyz.playtheia.controller.requestBodies;

public class LogInBody {

    private String email;
    private String password;

    public LogInBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
