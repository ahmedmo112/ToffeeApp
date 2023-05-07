package mobile_ui;
import java.util.ArrayList;
import java.util.Scanner;

import category_view_manager.Category;
import category_view_manager.ICategoryView;
import category_view_manager.Product;
import order_manager.CashOnDeliveryPayment;
import order_manager.IOrderHistory;
import order_manager.Order;
import order_manager.OrderStatus;
import shopping_cart_manager.ICartItem;
import shopping_cart_manager.IShoppingCart;
import user_manager.IUser;

public class MobileGUI {
    private ICategoryView categoryView;
    private IShoppingCart shoppingCart;
    private IOrderHistory orderHistory;
    private IUser user;
    private boolean isLoggedIn;


    public MobileGUI(ICategoryView categoryView, IShoppingCart shoppingCart, IUser user, IOrderHistory orderHistory) {
        isLoggedIn = true;
        this.categoryView = categoryView;
        this.shoppingCart = shoppingCart;
        this.user = user;
        this.orderHistory = orderHistory;
    }

    public void Menu() {
        
        System.out.println("Please choose one of the following options:");
        System.out.println("1- View Categories");
        if (isLoggedIn) {
            System.out.println("2- View Shopping Cart");
            System.out.println("3- View Order History");
            System.out.println("4- View Profile");
            System.out.println("5- Logout");
        } else {
            System.out.println("2- Register");
            System.out.println("3- Login");
        }
        System.out.println("0- Exit");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                viewCategories();
                break;
            case 2:
                if (isLoggedIn) {
                    viewShoppingCart();
                } else {
                    register();
                }
                break;
            case 3:
                if (isLoggedIn) {
                    viewOrderHistory();
                } else {
                    login();
                }
                break;
           
            case 4:
                if (isLoggedIn) {
                    viewProfile();
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            case 5:
                if (isLoggedIn) {
                    logout();
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            case 0:
                System.out.println("Thank you for using Toffee App!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void searchForItem() {
        // TODO implement here
    }
    public void viewCategories() {
        ArrayList<Category> cArrayList = categoryView.viewCategories();
        System.out.println("Please Choose Category:");
        for (int i = 0; i < cArrayList.size(); i++) {
            System.out.println(i+1 + " - " + cArrayList.get(i).getName());
        }
        System.out.println("0 - Back");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        if (choice == 0) {
            Menu();
        } else {
            viewCategoryItems(cArrayList.get(choice-1).getId());
        }  
    }

    public void viewCategoryItems(int categoryID) {
        ArrayList<Product> pArrayList = categoryView.viewCategoryItems(categoryID);
        System.out.println("Please Choose Item:");
        for (int i = 0; i < pArrayList.size(); i++) {
            System.out.println(i+1 + " - " + pArrayList.get(i).getName());
        }
        System.out.println("0 - Back");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        if (choice == 0) {
            viewCategories();
        } else {
            viewItem(pArrayList.get(choice-1));
        }
    }
    public void viewItem(Product product) {
        System.out.println("Item Name: " + product.getName());
        System.out.println("Item Price: " + product.getPrice());
        System.out.println("Item Description: " + product.getDescription());
        System.out.println("Item Quantity: " + product.getAvailablieQuantity());
        System.out.println("1- Add to Cart");
        System.out.println("0- Back");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                addItemsToCart(product);
                break;
            case 0:
                viewCategoryItems(product.getCategoryID());
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }


    public void addItemsToCart(Product product) {
        System.out.println("Enter Quantity: ");
        Scanner scanner = new Scanner(System.in);
        int quantity =  Integer.parseInt(scanner.nextLine());
        if (quantity > product.getAvailablieQuantity()) {
            System.out.println("Invalid Quantity!");
            addItemsToCart(product);
        } else {
            shoppingCart.AddItem(product, quantity);
            System.out.println("Item added to cart successfully!");
            Menu();
        }
    }
    public void viewShoppingCart() {
        ArrayList<ICartItem> cartItems= shoppingCart.getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
            Menu();
        }
            
        
        System.out.println("Please Choose Item:");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println(i+1 + " - Name: " + cartItems.get(i).getProduct().getName() + "   Quantity: " + cartItems.get(i).getQuantity()+ "   Price: " + cartItems.get(i).getUnitPrice()+ "   Total Price: " + cartItems.get(i).getTotalPrice()) ;
        }
        System.out.println("--------------------------------");
        System.out.println("1- Remove Item");
        System.out.println("2- Update Item Quantity");
        System.out.println("3- Checkout");
        System.out.println("0- Back");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Enter Item Number: ");
                int itemNumber =  Integer.parseInt(scanner.nextLine());
                shoppingCart.RemoveItem(cartItems.get(itemNumber-1));
                System.out.println("Item removed successfully!");
                viewShoppingCart();
                break;
            case 2:
                System.out.println("Enter Item Number: ");
                int itemNumber2 =  Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Quantity: ");
                int quantity =  Integer.parseInt(scanner.nextLine());
                if(quantity > cartItems.get(itemNumber2-1).getProduct().getAvailablieQuantity() ){
                    System.out.println("Invalid Quantity!");
                }else{
                    shoppingCart.UpdateItem(cartItems.get(itemNumber2-1), quantity);
                }
                System.out.println("Item updated successfully!");
                viewShoppingCart();
                break;
            case 3:
                checkout();
                break;
            case 0:
                Menu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void checkout() {
        System.out.println("Total Price: " + shoppingCart.calcTotal());
        System.out.println("1- Confirm");
        System.out.println("0- Back");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                  Order order = shoppingCart.placeOrder(user.getID());
                  
                payOrder(order);
                break;
            case 0:
                viewShoppingCart();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    

    public void payOrder(Order order) { 
        System.out.println("Please Enter Shipped Address: ");
        Scanner scanner = new Scanner(System.in);
        String address =  scanner.nextLine();
        order.setShippedAdress(address);
        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println("1- Pay upon delivery");
        System.out.println("2- Pay with Smart Wallet");
        System.out.println("3- Pay using voucher");
        System.out.println("3- Pay using loyalty points");
        
        System.out.println("0- Back");
        System.out.println("Enter your choice: ");
        
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
            if (order.getTotalPrice() > 2000) {
                System.out.println("The Order is more than 2000 EGP, We Can't Deliver it");
                System.out.println("Please choose another payment method");
                payOrder(order);
            } 
            
            
                System.out.println("There is 20 EGP delivery fees");
                System.out.println("Total Price + 20 EGP: " + (order.getTotalPrice()+20));
                
                System.out.println("1- Confirm");
                System.out.println("0- Back");
                System.out.println("Enter your choice: ");
                choice =  Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                    System.out.println("Please Enter Your Phone Number: ");
                    String phoneNumber =  scanner.nextLine();
                    
                    
                    CashOnDeliveryPayment cashOnDeliveryPayment = new CashOnDeliveryPayment();
                    while(!cashOnDeliveryPayment.validatePhoneNumber(phoneNumber)){
                        System.out.println("Invalid Phone Number!");
                        System.out.println("Please Enter Your Phone Number: ");
                        phoneNumber =  scanner.nextLine();
                    }
                    order.setTotalPrice(order.getTotalPrice()+20);
                    if(order.payOrder(cashOnDeliveryPayment)){
                        
                        order.setStatus(OrderStatus.PROCESSING);
                        System.out.println("Order placed successfully!");
                        cashOnDeliveryPayment.setPaymentMethod("CashOnDelivery");  
                        orderHistory.createOrder(order);
                        order.updateProductsQuantity();
                        shoppingCart.clearCart();
                        Menu();
                    }else{
                        System.out.println("Order failed!");
                        Menu();
                    }
                        
                        
                        break;
                        case 0:
                        payOrder(order);
                        break;
                        default:
                        System.out.println("Invalid choice!");
                        break;
                }
                break;
            case 0:
                viewShoppingCart();
                break;
                default:
                System.out.println("Invalid choice!");
                break;
            }
        }
        
        public void viewOrderHistory() {
            ArrayList<Order> orders = orderHistory.viewOrderHistory(user.getID());
            if (orders.isEmpty()) {
                System.out.println("You have no orders!");
                Menu();
            }
            System.out.println("Please Choose Order:");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(i+1 + " - Order ID: " + orders.get(i).getId() + "   Total Price: " + orders.get(i).getTotalPrice() + "   Status: " + orders.get(i).getStatus()) ;
            }
            System.out.println("--------------------------------");
            System.out.println("1- View Order Details");
            System.out.println("0- Back");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice =  Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter Order Number: ");
                    int orderNumber =  Integer.parseInt(scanner.nextLine());
                    viewOrderDetails(orders.get(orderNumber-1));
                    break;
                case 0:
                    Menu();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            
        }

        public void viewOrderDetails(Order order){
            System.out.println("Order ID: " + order.getId());
            System.out.println("Order Date: " + order.getPayment().getDate());
            System.out.println("Order Status: " + order.getStatus());
            System.out.println("Order Total Price: " + order.getTotalPrice());
            System.out.println("Order Shipped Address: " + order.getShippedAdress());
            System.out.println("Order Payment Method: " + order.getPayment().getPaymentMethod());
            System.out.println("Order Items: ");
            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.println(i+1 + " - Item Name: " + order.getItems().get(i).getProduct().getName() + "   Item Price: " + order.getItems().get(i).getUnitPrice() + "   Item Quantity: " + order.getItems().get(i).getQuantity()) ;
            }
            System.out.println("--------------------------------");
            System.out.println("1- Re-Order");
            System.out.println("0- Back");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice =  Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ArrayList<ICartItem> itemsList = orderHistory.reOrder(order);
                    shoppingCart.setItems(itemsList);
                    System.out.println("Your Previous Order added to cart successfully!");
                    viewShoppingCart();
                    break;
                case 0:
                    viewOrderHistory();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        
        public void register() {
            // TODO implement here
        }
        public void login() {
        // TODO implement here
    }
    public void logout() {
        // TODO implement here
    }
    public void viewProfile() {
        // TODO implement here
    }
}
