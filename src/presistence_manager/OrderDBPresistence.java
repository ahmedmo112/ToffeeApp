package presistence_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import category_view_manager.Product;
import order_manager.IPayment;
import order_manager.Order;
import order_manager.OrderStatus;
import shopping_cart_manager.CartItem;
import shopping_cart_manager.ICartItem;

public class OrderDBPresistence {
    private String dataFilePath;

    public OrderDBPresistence() {
        this.dataFilePath = "src\\data\\order.txt";
    }

    public ArrayList<Order> getOrdersHistory(int userId) throws IOException {
        ArrayList<Order> orderList = readOrderDataFromFile();
        ArrayList<Order> userOrderList = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUserId() == userId) {
                userOrderList.add(order);
            }
        }
        return userOrderList;
    }


    private ArrayList<Order> readOrderDataFromFile() throws IOException {
        ArrayList<Order> orders = new ArrayList<>();
        ProductDBPresistence productDBPresistence = new ProductDBPresistence();
       
       BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
            String line;
            
            while ((line = reader.readLine()) != null) {
               
                ArrayList<ICartItem> cartItemList = new ArrayList<>();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                int userId = Integer.parseInt(fields[1]);
                String shippedAddress = fields[2];
                double totalPrice = Double.parseDouble(fields[3]);
                int transactionId = Integer.parseInt(fields[4]);
                String paymentMethod = fields[5];
                OrderStatus status = OrderStatus.valueOf(fields[6]);
                String date = fields[7];
                for (int i = 8; i < fields.length; i+=2) {
                    int productId = Integer.parseInt(fields[i]);
                    int quantity = Integer.parseInt(fields[i+1]);
                    Product product = productDBPresistence.getProduct(productId);
                    CartItem cartItem = new CartItem(product, quantity);
                    cartItemList.add(cartItem);
                }

             
           
                Order order = new Order(id, userId, shippedAddress, totalPrice, transactionId, paymentMethod, status, date, cartItemList);
               
                orders.add(order);
            }
        return orders;
    }

    public void addOrder(Order order) throws IOException {
        ArrayList<Order> orderList = readOrderDataFromFile();
      
        orderList.add(order);
        writeOrderDataToFile(orderList);
    }


   public void writeOrderDataToFile(ArrayList<Order> orderList){
    String data = "";
    for (Order order : orderList) {
        data += order.getId() + "," + order.getUserId() + "," + order.getShippedAdress() + "," + order.getTotalPrice() + "," + order.getPayment().getTransactionId() + "," + order.getPayment().getPaymentMethod() + "," + order.getStatus() + "," + order.getPayment().getDate();
        for (ICartItem cartItem : order.getItems()) {
            data += "," + cartItem.getProduct().getId() + "," + cartItem.getQuantity();
        }
        data += "\n";
    }
    FileWriter myWriter;
    try {
        myWriter = new FileWriter(dataFilePath);
        myWriter.write(data);
        myWriter.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
   }

public void updateOrderStatus(Order order) {
    ArrayList<Order> orderList;
    try {
        orderList = readOrderDataFromFile();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == order.getId()) {
                orderList.set(i, order);
            }
        }
        writeOrderDataToFile(orderList);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


}
