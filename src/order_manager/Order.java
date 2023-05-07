package order_manager;
import java.io.IOException;
import java.util.ArrayList;

import category_view_manager.Product;
import presistence_manager.ProductDBPresistence;
import shopping_cart_manager.ICartItem;

public class Order {
    private int id;
    private int userId;
    private String shippedAddress;
    private double totalPrice;
    private IPayment payment;
    private OrderStatus status;
    
    private ArrayList<ICartItem> items;

    public Order(int id,int userId ,double totalPrice, ArrayList<ICartItem> items) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.items = items;
        this.userId = userId;
    }

    public Order(int id,int userId ,String shippedAddress , double totalPrice, int transactionId, String paymentMethod, OrderStatus status, String date, ArrayList<ICartItem> items) {
        this.id = id;
        this.userId = userId;
        this.shippedAddress = shippedAddress;
        this.totalPrice = totalPrice;
        
        if(paymentMethod.equals("CashOnDelivery")){
            this.payment = new CashOnDeliveryPayment(totalPrice, paymentMethod, date, transactionId);

        }

        
        
        this.items = items;
        
        this.status = status;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IPayment getPayment() {
        return this.payment;
    }

    public String getShippedAdress() {
        return this.shippedAddress;
    }

    public void setShippedAdress(String shippedAddress) {
        this.shippedAddress = shippedAddress;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public boolean payOrder(IPayment payment){
        this.payment = payment;
        this.payment.processPayment();
        // save order in database
        return true;
    }

    public void setItems(ArrayList<ICartItem> items) {
        this.items = items;
    }

    public ArrayList<ICartItem> getItems() {
        return this.items;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void updateProductsQuantity() {
        ProductDBPresistence productDBPresistence = new ProductDBPresistence();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            products = productDBPresistence.readProductDataFromFile();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        for (ICartItem cartItem : items) {
            for (Product product : products) {
                if (cartItem.getProduct().getId() == product.getId()) {
                    product.setAvailablieQuantity(product.getAvailablieQuantity() - cartItem.getQuantity());
                }
            }
        }
        try {
            productDBPresistence.writeProductDataToFile(products);
        } catch (IOException e) {
           
            e.printStackTrace();
        }

    }
    

}
