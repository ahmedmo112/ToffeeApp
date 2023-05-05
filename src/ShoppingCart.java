import java.util.ArrayList;

public  class ShoppingCart implements IShoppingCart {
    private int shippingFees;
    private ArrayList<ICartItem> items;

    @Override
    public void AddItem(Product item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddItem'");
    }

    @Override
    public void RemoveItem(int ProductID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'RemoveItem'");
    }

    @Override
    public void UpdateItem(int ProductID, int Quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateItem'");
    }

    @Override
    public ArrayList<ICartItem> getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }

    @Override
    public ICartItem getItem(int ProductID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItem'");
    }

    @Override
    public int countItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countItems'");
    }

    @Override
    public int calcTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcTotal'");
    }

    @Override
    public void clearCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearCart'");
    }

    @Override
    public Order placeOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
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
