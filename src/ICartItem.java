public interface ICartItem {
    Product getProduct();
    void setProduct(Product product);
    int getQuantity();
    void setQuantity(int quantity);
    double getUnitPrice();
    double getTotalPrice();

}
