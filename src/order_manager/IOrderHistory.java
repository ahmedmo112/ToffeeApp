package order_manager;
import java.util.ArrayList;

import shopping_cart_manager.ICartItem;

public interface IOrderHistory {
    void createOrder(Order order);
    ArrayList<ICartItem>  reOrder(Order order);
    ArrayList<Order> viewOrderHistory(int userID);
}
