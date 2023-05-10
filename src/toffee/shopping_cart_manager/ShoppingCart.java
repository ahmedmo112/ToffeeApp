package toffee.shopping_cart_manager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import toffee.category_view_manager.Product;
import toffee.order_manager.Order;
import toffee.presistence_manager.ShoppingCartDBPresistence;

public  class ShoppingCart implements IShoppingCart {
    private int shippingFees;
    private ArrayList<ICartItem> items;

    public ShoppingCart() {

        items = new ArrayList<ICartItem>();
    }

    
    /** 
     * add item to cart
     * @param item Product to be added
     * @param Quantity quantity of product to be added
     */
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

    
    /** 
     * remove item from cart
     * @param item item to be removed
     */
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

    
    /** 
     * update item quantity
     * @param item item to be updated
     * @param Quantity new quantity
     */
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

    
    /** 
     * get items in cart
     * @return ArrayList<ICartItem> items in cart
     */
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

    
    /** 
     * get item by id
     * @param ProductID id of item
     * @return ICartItem item
     */
    @Override
    public ICartItem getItem(int ProductID) {
        for (ICartItem item : items) {
            if (item.getProduct().getId() == ProductID) {
                return item;
            }
        }
        return null;
    }

    
    /** 
     * set items in cart
     * @param items items to be set
     */
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

    
    /** 
     * count items in cart
     * @return int number of items
     */
    @Override
    public int countItems() {
        return items.size();
    }

    
    /** 
     * calculate total price of items in cart
     * @return double total price
     */
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

    
    /** 
     * place order
     * @param userId id of user
     * @return Order order
     */
    @Override
    public Order placeOrder(int userId) {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Order order = new Order(id,userId,calcTotal(), items);
        return order;
    }

    
    /** 
     * set shipping fees
     * @param shippingFees fees to be set
     */
    @Override
    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    
    /** 
     * get shipping fees
     * @return int shipping fees
     */
    @Override
    public int getShippingFees() {
      return shippingFees;
    }

    
    
}
