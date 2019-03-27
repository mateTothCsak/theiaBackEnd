package xyz.playtheia.model;

import xyz.playtheia.util.Globals;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

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
    private String registrationDate;
    private String lastLogIn;
    private String characterType;
    private Integer level;
    private Integer experience;
    private Integer gold;
    private Integer baseHealth;
    private Integer damage;
    private Integer attackSpeed;
    private String leftSidekick;
    private String rightSidekick;



    private String salt;


    public Player(String email, String name, String password) {
        this.email = email;
        this.salt = generateSalt();
        this.password = generateHash(password, salt);
        this.userName = name;
        Date date = new Date();
        this.registrationDate = new Timestamp(date.getTime()).toString();
        this.lastLogIn = new Timestamp(date.getTime()).toString();
        this.characterType = "Maverick";
        this.level = 1;
        this.experience = 0;
        this.gold = 0;
        this.baseHealth = 50;
        this.damage = 200;
        this.attackSpeed = 70;
        this.leftSidekick = "";
        this.rightSidekick = "";
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

    public String generateHash(String passwordToHash, String salt){
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

    public Integer getExperience() {
        return experience;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getLastLogIn() {
        return lastLogIn;
    }

    public String getCharacterType() {
        return characterType;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getBaseHealth() {
        return baseHealth;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getAttackSpeed() {
        return attackSpeed;
    }

    public String getLeftSidekick() {
        return leftSidekick;
    }

    public String getRightSidekick() {
        return rightSidekick;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastLogIn(String lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public void setBaseHealth(Integer baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void setAttackSpeed(Integer attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setLeftSidekick(String leftSidekick) {
        this.leftSidekick = leftSidekick;
    }

    public void setRightSidekick(String rightSidekick) {
        this.rightSidekick = rightSidekick;
    }
}