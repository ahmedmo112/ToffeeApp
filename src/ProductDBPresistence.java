import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDBPresistence {
    private String dataFilePath;

    public ProductDBPresistence() {
        this.dataFilePath = "src\\data\\products.txt";
    }

    public ArrayList<Product> getCategoryProducts(int categoryID) throws IOException {
        ArrayList<Product> productList = readProductDataFromFile();
        ArrayList<Product> categoryProducts = new ArrayList<>();

        for (Product product : productList) {
            if (product.getCategoryID() == categoryID) {
                categoryProducts.add(product);
            }
        }

        return categoryProducts;
    }

    public Product getProduct(int productId) throws IOException {
        ArrayList<Product> productList = readProductDataFromFile();

        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
    }

    private ArrayList<Product> readProductDataFromFile() throws IOException {
        ArrayList<Product> productList = new ArrayList<>();

       BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double price = Double.parseDouble(fields[2]);
                int categoryId = Integer.parseInt(fields[3]);
                String brand = fields[4];
                String image = fields[5];
                String description = fields[6];
                int avaliablequantity = Integer.parseInt(fields[7]);
                int loyaltyPoints = Integer.parseInt(fields[8]);
                Product product = new Product(id, name, brand, price, image, description, avaliablequantity, categoryId, loyaltyPoints);
                productList.add(product);
            }
        

        return productList;
    }
}