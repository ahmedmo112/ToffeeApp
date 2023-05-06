package order_manager;
import java.io.IOException;
import java.util.ArrayList;

import category_view_manager.Product;
import presistence_manager.OrderDBPresistence;
import presistence_manager.ProductDBPresistence;
import shopping_cart_manager.ICartItem;

public class OrderHistory implements IOrderHistory {
    private ArrayList<Order> orderHistory = new ArrayList<Order>();
    @Override
    public void createOrder(Order order) {
        orderHistory.add(order);
        OrderDBPresistence orderDBPresistence = new OrderDBPresistence();
        try {
            orderDBPresistence.addOrder(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  

    @Override
    public ArrayList<ICartItem> reOrder(Order order) {
        ArrayList<ICartItem> items = order.getItems();
        int outOfStock = 0;
        for (ICartItem iCartItem : items) {
            if (iCartItem.getProduct().getAvailablieQuantity() < iCartItem.getQuantity()) {
               if (iCartItem.getProduct().getAvailablieQuantity() > 0) {
                   iCartItem.setQuantity(iCartItem.getProduct().getAvailablieQuantity());
                
               }else{
                    items.remove(iCartItem);
                    outOfStock++;
               }
            } 
        }
        if (outOfStock > 0) {
            System.out.println("Sorry, "+ outOfStock + "items are out of stock");
        
        }
        return items;
    }

    @Override
    public ArrayList<Order> viewOrderHistory(int userID) {
        OrderDBPresistence orderDBPresistence = new OrderDBPresistence();
        try {
            orderHistory = orderDBPresistence.getOrdersHistory(userID);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return orderHistory;
    }

    
}
