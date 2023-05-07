package shopping_cart_manager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import category_view_manager.Product;
import order_manager.Order;
import presistence_manager.ShoppingCartDBPresistence;

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
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            shoppingCartDBPresistence.addProductToCart(cartItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void RemoveItem(ICartItem item) {
        items.remove(item);
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            shoppingCartDBPresistence.removeProductFromCart(item.getProduct().getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateItem(ICartItem item, int Quantity) {
        item.setQuantity(Quantity);
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            shoppingCartDBPresistence.updateProductQuantity(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ICartItem> getItems() {
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            items = shoppingCartDBPresistence.getShoppingCartProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void setItems(ArrayList<ICartItem> items) {
        this.items = items;
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            shoppingCartDBPresistence.writeProductDataToFile(items);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int countItems() {
        return items.size();
    }

    @Override
    public double calcTotal() {
        double total = 0;
        for (ICartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    @Override
    public void clearCart() {
        items.clear();
        ShoppingCartDBPresistence shoppingCartDBPresistence = new ShoppingCartDBPresistence();
        try {
            shoppingCartDBPresistence.clearCart();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }

    @Override
    public Order placeOrder(int userId) {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Order order = new Order(id,userId,calcTotal(), items);
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
