package shopping_cart_manager;
import category_view_manager.Product;

public interface ICartItem {
    Product getProduct();
    void setProduct(Product product);
    int getQuantity();
    void setQuantity(int quantity);
    double getUnitPrice();
    double getTotalPrice();

}
