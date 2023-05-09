package order_manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashOnDeliveryPayment extends Payment{
    private String phoneNumber;
    
    public CashOnDeliveryPayment(){

    }
    public CashOnDeliveryPayment(double amount, String paymentMethod,String date, int transactionId) {
        super(amount, paymentMethod, date, transactionId);
    }




    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {

        return this.phoneNumber;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^(010|011|012|015)[0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

   
}
