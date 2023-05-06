package order_manager;
public class CashOnDeliveryPayment extends Payment{
    private String phoneNumber;
    
    public CashOnDeliveryPayment(){

    }
    public CashOnDeliveryPayment(double amount, String paymentMethod,String date, int transactionId) {
        super(amount, paymentMethod, date, transactionId);
        this.phoneNumber = phoneNumber;
    }




    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11 || !phoneNumber.startsWith("01")) {
            return false;
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

   
}
