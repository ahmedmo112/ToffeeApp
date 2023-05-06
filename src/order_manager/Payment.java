package order_manager;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.Random;

public class Payment implements IPayment {

    private double amount;
    private int transactionId;
    private String date;
    private String paymentMethod;

    public Payment() {

    }

    public Payment(double amount, String paymentMethod,String data, int transactionId) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = data;
        this.transactionId = transactionId;
    }

    @Override
    public void processPayment() {
        Random rand = new Random();
        this.transactionId = rand.nextInt(1000000);
        LocalDate date = LocalDate.now();
        this.date = date.toString();
        System.out.println("Payment processed successfully");
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int getTransactionId() {
        return transactionId;
    }

    @Override
    public String getDate() {
        return date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
}
