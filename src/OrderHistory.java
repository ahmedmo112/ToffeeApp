import java.util.ArrayList;

public class OrderHistory implements IOrderHistory {
    private ArrayList<Order> orderHistory = new ArrayList<Order>();
    @Override
    public void createOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public void removeOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeOrder'");
    }

    @Override
    public void reOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reOrder'");
    }

    @Override
    public ArrayList<Order> viewOrderHistory() {
       return orderHistory;
    }

    
}
