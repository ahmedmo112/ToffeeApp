public class CartItem implements ICartItem {
    private int quantity;
    private Product product;
    private double price;

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
