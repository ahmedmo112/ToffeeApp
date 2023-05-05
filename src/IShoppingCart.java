import java.util.ArrayList;

public interface IShoppingCart {
    void AddItem(Product item);
    void RemoveItem(int ProductID);
    void UpdateItem(int ProductID, int Quantity);
    ArrayList<ICartItem> getItems();
    ICartItem getItem(int ProductID);
    int countItems();
    int calcTotal();
    void clearCart();
    Order placeOrder();
    void setShippingFees(int shippingFees);
    int getShippingFees();
    
}
