

public interface IPayment {
    void processPayment();
    int getAmount();
    void setAmount(int amount);
    int getTransactionId();
    String getDate();
}
