public class Product {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String image;
    private String description;
    private int avaliablequantity;
    private int loyaltyPoints;
    private int categoryID;

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
    public void setPrice(int price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setAvailablieQuantity(int avaliablequantity){
        this.avaliablequantity = avaliablequantity;
    }
    public int getAvailablieQuantity(){
        return avaliablequantity;
    }
    public void setLoyaltyPoints(int loyaltyPoints){
        this.loyaltyPoints= loyaltyPoints;
    }
    public int getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }
    public int getCategoryID(){
        return categoryID;
    }
    
    public Product(int id, String name, String brand, double price, String image, String desc, int avaliablequantity, int category_id, int loyaltyPoints){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.description = desc;
        this.avaliablequantity = avaliablequantity;
        this.categoryID = category_id;
        this.loyaltyPoints = loyaltyPoints;
    }

    
    
}
