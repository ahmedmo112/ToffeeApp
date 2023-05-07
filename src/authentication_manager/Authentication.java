package authentication_manager;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import presistence_manager.UserDBPresistence;
import user_manager.IUser;
import user_manager.LoggedInUser;

public class Authentication implements IAuthentication{
    private boolean isLoggedIn;
    private IUser user;

    public Authentication() {
        this.isLoggedIn = false;
        user = new LoggedInUser();
    }
    public boolean login(String email, String password) {
        UserDBPresistence userDBPresistence = new UserDBPresistence();
        try {
            user = userDBPresistence.getUser(email, password);
            if (user == null) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        this.isLoggedIn = true;
        return true;
    }
    public boolean logout() {
        this.isLoggedIn = false;
        this.user = new LoggedInUser();
        return true;
    }
    public boolean register(IUser user) {
        UserDBPresistence userDBPresistence = new UserDBPresistence();
        try {
            userDBPresistence.registerUser(user);
        } catch (IOException e) {
            e.printStackTrace();
            return false; 
        }
        this.user = user;
        this.isLoggedIn = true;
        return true;
    }
    public boolean resetPassword(String email) {
        
        return false;
    }
    @Override
    public boolean validateRegister(String email, String password,  String phone) {
        if (!validateEmail(email)) {
            System.out.println("Invalid email");
            return false;
        }else if (!validatePassword(password)) {
            System.out.println("1- Password must contain at least one digit [0-9].");
            System.out.println("2- Password must contain at least one lowercase Latin character [a-z].");
            System.out.println("3- Password must contain at least one uppercase Latin character [A-Z].");
            System.out.println("4- Password must contain at least one special character like ! @ # & ( ).");
            System.out.println("5-  Password must contain a length of at least 8 characters and a maximum of 20 characters.");
            return false;
        }else if (!validatePhone(phone)) {
            System.out.println("Invalid phone");
            return false;
        }
        return true;
    }

    private boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    private boolean validatePhone(String phone) {
        String regex = "^(010|011|012|015)[0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }
    @Override
    public boolean validateLogin(String email, String password) {
        if (!validateEmail(email)) {
            System.out.println("Invalid email");
            return false;
        }else if (!validatePassword(password)) {
            System.out.println("1- Password must contain at least one digit [0-9].");
            System.out.println("2- Password must contain at least one lowercase Latin character [a-z].");
            System.out.println("3- Password must contain at least one uppercase Latin character [A-Z].");
            System.out.println("4- Password must contain at least one special character like ! @ # & ( ).");
            System.out.println("5-  Password must contain a length of at least 8 characters and a maximum of 20 characters.");
            return false;
        }
        return true;
    }
    @Override
    public IUser getUser() {
       return this.user;
    }
    @Override
    public void setUser(IUser user) {
        this.user = user;
    }
    @Override
    public boolean validateOTP(int otp,int otpSent) {
        if(otp == otpSent){
            return true;
        }
        return false;
    }
    @Override
    public int sendOTP(String email) {
       Random rand = new Random();
         int otp = rand.nextInt(10000);
         return otp;
    }

}
