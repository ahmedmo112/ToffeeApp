package toffee.shopping_cart_manager;
import java.util.ArrayList;

import toffee.category_view_manager.Product;
import toffee.order_manager.Order;

public interface IShoppingCart {
    void AddItem(Product item , int Quantity);
    void RemoveItem(ICartItem item);
    void UpdateItem(ICartItem item, int Quantity);
    ArrayList<ICartItem> getItems();
    ICartItem getItem(int ProductID);
    void setItems(ArrayList<ICartItem> items);
    int countItems();
    double calcTotal();
    void clearCart();
    Order placeOrder(int userId);
    void setShippingFees(int shippingFees);
    int getShippingFees();
    
}
