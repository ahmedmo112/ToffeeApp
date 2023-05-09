package user_manager;
public interface IUser {
   public void setPhoneNumber(String phoneNumber);
   public String getPhoneNumber();
   public String getName();
   public String getEmail();
   public void setEmail(String Email);
   public void setName(String name);
   public void setID(int ID);
    public int getID();
    public String getPassword();
    public void setStatus(UserStatus status);
    public UserStatus getStatus();
    public void setAddress(String address);
    public String getAddress();
    public void setCountry(String country);
    public String getCountry();
    public void setLoyaltyPoints(int loyaltyPoints);
    public int getLoyaltyPoints();
    public void setPassword(String password);
}
