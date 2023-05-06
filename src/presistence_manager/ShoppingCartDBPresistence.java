package presistence_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import category_view_manager.Product;
import shopping_cart_manager.CartItem;
import shopping_cart_manager.ICartItem;

public class ShoppingCartDBPresistence {
    private String dataFilePath;

    public ShoppingCartDBPresistence() {
        this.dataFilePath = "src\\data\\shoppingcart.txt";
    }

    public ArrayList<ICartItem> getShoppingCartProducts() throws IOException {
        ArrayList<ICartItem> cartItems = readProductDataFromFile();

        return cartItems;
    }


    private ArrayList<ICartItem> readProductDataFromFile() throws IOException {
        ArrayList<ICartItem> cartItemList = new ArrayList<>();
        ProductDBPresistence productDBPresistence = new ProductDBPresistence();

       BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                int quantity = Integer.parseInt(fields[1]);
                Product product = productDBPresistence.getProduct(id);
                CartItem cartItem = new CartItem(product, quantity);
                cartItemList.add(cartItem);
            }
        

        return cartItemList;
    }



    public void addProductToCart(ICartItem cartItem) throws IOException {
        ArrayList<ICartItem> cartItemList = readProductDataFromFile();
        cartItemList.add(cartItem);
        writeProductDataToFile(cartItemList);
    }



    public void removeProductFromCart(int productId) throws IOException {
        ArrayList<ICartItem> cartItemList = readProductDataFromFile();
        for (int i = 0; i < cartItemList.size(); i++) {
            if (cartItemList.get(i).getProduct().getId() == productId) {
                cartItemList.remove(i);
                break;
            }
        }
        writeProductDataToFile(cartItemList);
    }

    public void updateProductQuantity(ICartItem cartItem) throws IOException {
        ArrayList<ICartItem> cartItemList = readProductDataFromFile();
        for (int i = 0; i < cartItemList.size(); i++) {
            if (cartItemList.get(i).getProduct().getId() == cartItem.getProduct().getId()) {
                cartItemList.get(i).setQuantity(cartItem.getQuantity());
                break;
            }
        }
        writeProductDataToFile(cartItemList);
    }

    public void clearCart() throws IOException {
        ArrayList<ICartItem> cartItemList = new ArrayList<>();
        writeProductDataToFile(cartItemList);
    }

    public void writeProductDataToFile(ArrayList<ICartItem> cartItemList) throws IOException {
        String data = "";
        for (ICartItem cartItem : cartItemList) {
            data += cartItem.getProduct().getId() + "," + cartItem.getQuantity() + "\n";
        }
        FileWriter myWriter = new FileWriter(dataFilePath);
        myWriter.write(data);
        myWriter.close();
    }

    
}
