import java.util.ArrayList;
import java.util.Scanner;

public class MobileGUI {
    private ICategoryView categoryView;
    private IShoppingCart shoppingCart;
    private IUser user;
    private boolean isLoggedIn;


    public MobileGUI(ICategoryView categoryView, IShoppingCart shoppingCart, IUser user) {
        isLoggedIn = true;
        this.categoryView = categoryView;
        this.shoppingCart = shoppingCart;
        this.user = user;
    }

    public void runner() {
        System.out.println("Welcome to Toffee App!");
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
            runner();
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
        if (choice == 0) {
            viewCategoryItems(product.getCategoryID());
        } else {
            if (isLoggedIn) {
                addItemsToCart(product);
            } else {
                System.out.println("Please login first!");
                login();
            }
       
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
            runner();
        }
    }
    public void viewShoppingCart() {
        ArrayList<ICartItem> cartItems= shoppingCart.getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
            runner();
        }
            
        
        System.out.println("Please Choose Item:");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println(i+1 + " - Name: " + cartItems.get(i).getProduct().getName() + "   Quantity: " + cartItems.get(i).getQuantity()+ "   Price: " + cartItems.get(i).getUnitPrice()+ "   Total Price: " + cartItems.get(i).getTotalPrice()) ;
        }
        System.out.println("--------------------------------");
        System.out.println("1- Remove Item");
        System.out.println("2- Checkout");
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
                checkout();
                break;
            case 0:
                runner();
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

    

    public void viewOrderHistory() {
        // TODO implement here
    }
    public void payOrder(Order order) { 
        System.out.println("Please Enter Shipped Address: ");
        Scanner scanner = new Scanner(System.in);
        String address =  scanner.nextLine();
        order.setShippedAdress(address);
        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println("1- Pay upon delivery");
        System.out.println("0- Back");
        System.out.println("Enter your choice: ");
        
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
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
                        

                        CashOnDeliveryPayment cashOnDeliveryPayment = new CashOnDeliveryPayment(phoneNumber);
                        order.setTotalPrice(order.getTotalPrice()+20);
                        if(order.payOrder(cashOnDeliveryPayment)){
                            order.setStatus(OrderStatus.PROCESSING);
                            System.out.println("Order placed successfully!");
                            runner();
                        }else{
                            System.out.println("Order failed!");
                            runner();
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
