public class LoggedInUser implements IUser {
    private int phoneNumber;
    private String name;
    private String Email;
    private int ID;
    private String address;
    private String country;
    private String loyaltyPoints;

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEMail(String Email) {
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
    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getEMail() {
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
    public String getLoyaltyPoints() {
        return loyaltyPoints;
    }

}
