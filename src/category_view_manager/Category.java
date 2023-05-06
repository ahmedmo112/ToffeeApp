package category_view_manager;
import java.util.ArrayList;

public class Category {
    private int id;
    private String name;
    private ArrayList<Product> products;

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public ArrayList<Product> viewItems(Category category){
        throw new UnsupportedOperationException();
    }

    public void setItems(ArrayList<Product> products){
        this.products = products;
    }

    public Product getItem(int id){
        throw new UnsupportedOperationException();
    }
    public void setId(int id){

    }
    public int getId(){
        return id;
    }
    public void setName(String name){

    }
    public String getName(){
        return name;
    }
    public void AddItem(int id, String name, String brand, int price, String image, String desc, int avaliablequantity){

    }
    public void RemoveItem(Product product){

    }
    public void UpdateItem(Product product){

    }
}
