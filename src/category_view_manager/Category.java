package category_view_manager;


public class Category {
    private int id;
    private String name;
   

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }


    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
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
