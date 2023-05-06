public class App {
    public static void main(String[] args) throws Exception {
        MobileGUI gui = new MobileGUI(new CategoryView(),new ShoppingCart(),new LoggedInUser());
        gui.runner();
    }
}



// order data 
// payment
// auth
//! validate phone number
