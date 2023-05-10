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

    
    /** 
     * get product
     * @return Product the product
     */
    @Override
    public Product getProduct() {
        return product;
    }
    
    /** 
     * set product
     * @param product   the product
     */
    @Override
    public void setProduct(Product product) {
        this.product = product;
    }
    
    /** 
     * get quantity
     * @return int the quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    
    /** 
     * set quantity
     * @param quantity the quantity
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /** 
     * get unit price
     * @return double the unit price
     */
    @Override
    public double getUnitPrice() {
        return price;
    }
    
    /**
     * get total price
     * @return double the total price
     */
    @Override
    public double getTotalPrice() {
        return price * quantity;
    }
}
