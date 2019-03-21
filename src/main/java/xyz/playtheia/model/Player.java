package xyz.playtheia.model;

import xyz.playtheia.util.Globals;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Entity
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String userName;
    private Timestamp registrationDate;
    private Timestamp lastLogIn;


    private String salt;


    public Player(String email, String name, String password) {
        this.email = email;
        this.salt = generateSalt();
        this.password = generateHash(password, salt);
        this.userName = name;
        this.registrationDate = new Timestamp(System.currentTimeMillis());
        this.lastLogIn = new Timestamp(System.currentTimeMillis());
    }


    public Player() {}


    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String generateHash(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }


    public static String generateSalt() {
        byte[] salt = new byte[16];
        Globals.getRANDOM().nextBytes(salt);
        return salt.toString();
    }
}