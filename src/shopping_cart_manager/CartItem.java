package shopping_cart_manager;
import category_view_manager.Product;

public class CartItem implements ICartItem {

    private int quantity;
    private Product product;
    private double price;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    @Override
    public Product getProduct() {
        return product;
    }
    @Override
    public void setProduct(Product product) {
        this.product = product;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public double getUnitPrice() {
        return price;
    }
    @Override
    public double getTotalPrice() {
        return price * quantity;
    }
}
