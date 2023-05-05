public class Payment implements IPayment {

    private int amount;
    private int transactionId;
    private String date;


    @Override
    public void processPayment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
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
    
}
