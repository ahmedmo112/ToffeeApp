package user_manager;
public interface IUser {
   public void setPhoneNumber(String phoneNumber);
   public void setName(String name);
   public void setEmail(String Email);
   public void setID(int ID);
   public String getPhoneNumber();
    public String getName();
    public String getEmail();
    public int getID();
    public String getPassword();
    public void setStatus(UserStatus status);
    public UserStatus getStatus();
    public void setAddress(String address);
    public void setCountry(String country);
    public void setLoyaltyPoints(int loyaltyPoints);
    public String getAddress();
    public String getCountry();
    public int getLoyaltyPoints();

}
