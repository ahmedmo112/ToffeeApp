import java.util.ArrayList;

public class Order {
    private int id;
    private String shippedAdress;
    private int totalPrice;
    private IPayment payment;
    private OrderStatus status;
    private ArrayList<ICartItem> items;

    public Order(int id,  int totalPrice, ArrayList<ICartItem> items) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void processPayment() {
        this.payment.processPayment();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippedAdress() {
        return this.shippedAdress;
    }

    public void setShippedAdress(String shippedAdress) {
        this.shippedAdress = shippedAdress;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public boolean payOrder(IPayment payment){
        this.payment.processPayment();
        return true;
    }

}
