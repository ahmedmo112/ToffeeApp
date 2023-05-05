import java.util.ArrayList;

public interface IOrderHistory {
    void createOrder(Order order);
    void removeOrder(Order order);
    void reOrder(Order order);
    ArrayList<Order> viewOrderHistory();
}
