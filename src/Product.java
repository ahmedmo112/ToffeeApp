public class Product {
    private int id;
    private String name;
    private String brand;
    private int price;
    private String image;
    private String description;
    private int avaliablequantity;
    private int loyaltyPoints;

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
    public int getprice(){
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
    Product(int id, String name, String brand, int price, String image, String desc, int avaliablequantity, Category category){

    }
    
}
