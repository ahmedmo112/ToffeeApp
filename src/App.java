import authentication_manager.Authentication;
import category_view_manager.CategoryView;
import mobile_ui.MobileGUI;
import order_manager.OrderHistory;
import shopping_cart_manager.ShoppingCart;
import user_manager.LoggedInUser;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Toffee App!");
        MobileGUI gui = new MobileGUI(new CategoryView(),new ShoppingCart(),new OrderHistory(),new Authentication());
        gui.Menu();
    }
}



// order data 
// payment
// auth
//! validate phone number
