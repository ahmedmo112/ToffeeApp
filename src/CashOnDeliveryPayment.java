public class CashOnDeliveryPayment extends Payment{
    private String phoneNumber;

    public CashOnDeliveryPayment( String phoneNumber) {
        
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
