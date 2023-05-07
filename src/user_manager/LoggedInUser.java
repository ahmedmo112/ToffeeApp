package user_manager;

import java.io.IOException;
import java.util.Random;

import presistence_manager.UserDBPresistence;

public class LoggedInUser implements IUser {
    private String phoneNumber;
    private String name;
    private String Email;
    private int ID;
    private String password;
    private String address;
    private String country;
    private int loyaltyPoints;
    private UserStatus status;

    public LoggedInUser() {
    }

    public LoggedInUser(int id, String name, String Email, String password, String phoneNumber, String address, String country, int loyaltyPoints, UserStatus status) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.Email = Email;
        this.ID = id;
        this.password = password;
        this.address = address;
        this.country = country;
        this.loyaltyPoints = loyaltyPoints;
        this.status = status;
    }

    public LoggedInUser(String name, String Email, String password, String phoneNumber, String address, String country) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.Email = Email;
        Random rand = new Random();
        this.ID = rand.nextInt(1000000);
        this.password = password;
        this.address = address;
        this.country = country;
        this.loyaltyPoints = 0;
        this.status = UserStatus.ACTIVE;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        UserDBPresistence userDBPresistence = new UserDBPresistence();
        try {
            userDBPresistence.updateUser(this);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return Email;
    }
    public int getID() {
        return ID;
    }
    public String getAddress() {
        return address;
    }
    public String getCountry() {
        return country;
    }
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
