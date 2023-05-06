import java.util.ArrayList;
import java.util.Random;

public  class ShoppingCart implements IShoppingCart {
    private int shippingFees;
    private ArrayList<ICartItem> items;

    public ShoppingCart() {
        items = new ArrayList<ICartItem>();
    }

    @Override
    public void AddItem(Product item , int Quantity) {
        ICartItem cartItem = new CartItem(item, Quantity);
        items.add(cartItem);
    }

    @Override
    public void RemoveItem(ICartItem item) {
        items.remove(item);
    }

    @Override
    public void UpdateItem(ICartItem item, int Quantity) {
        item.setQuantity(Quantity);
    }

    @Override
    public ArrayList<ICartItem> getItems() {
        return items;
    }

    @Override
    public ICartItem getItem(int ProductID) {
        for (ICartItem item : items) {
            if (item.getProduct().getId() == ProductID) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int countItems() {
        return items.size();
    }

    @Override
    public int calcTotal() {
        int total = 0;
        for (ICartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    @Override
    public void clearCart() {
        items.clear();
    }

    @Override
    public Order placeOrder() {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Order order = new Order(id, calcTotal(), items);
        return order;
    }

    @Override
    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    @Override
    public int getShippingFees() {
      return shippingFees;
    }

    
    
}
