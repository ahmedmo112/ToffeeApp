package toffee.user_manager;

import java.io.IOException;
import java.util.Random;

import toffee.presistence_manager.UserDBPresistence;

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

    
    /** 
     * set user phone number
     * @param phoneNumber user phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * set user name
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**  
     * set email
     * @param Email user email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    /** 
     * set user id
     * @param ID user id
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    
    /** 
     * set user address
     * @param address  user address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    /** 
     * set user country
     * @param country user country
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /** 
     * set user loyalty points
     * @param loyaltyPoints user loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        UserDBPresistence userDBPresistence = new UserDBPresistence();
        try {
            userDBPresistence.updateUser(this);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    
    /** 
     * get user phone number
     * @return String user phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /** 
     * get user name
     * @return String user name
     */
    public String getName() {
        return name;
    }
    
    /** 
     * get user email
     * @return String user email
     */
    public String getEmail() {
        return Email;
    }
    
    /** 
     * get user id
     * @return int user id
     */
    public int getID() {
        return ID;
    }
    
    /** 
     * get user address
     * @return String user address
     */
    public String getAddress() {
        return address;
    }
    
    /** 
     * get user country
     * @return String user country
     */
    public String getCountry() {
        return country;
    }
    
    /** 
     * get user loyalty points
     * @return int user loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    
    /** 
     * set user status
     * @param status user status
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    
    /** 
     * get user status
     * @return UserStatus user status
     */
    public UserStatus getStatus() {
        return status;
    }
    
    /** 
     * set user password
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /** 
     * get user password
     * @return String user password
     */
    public String getPassword() {
        return password;
    }
}
