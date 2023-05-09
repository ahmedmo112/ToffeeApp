package category_view_manager;
import java.io.IOException;
import java.util.ArrayList;

import presistence_manager.CategoryDBPersistence;
import presistence_manager.ProductDBPresistence;

public class CategoryView implements ICategoryView{
    ArrayList<Category> categories;

    @Override
    public ArrayList<Category> viewCategories() {
        CategoryDBPersistence categoryDBPersistence = new CategoryDBPersistence();
        try {
            categories = categoryDBPersistence.getAllCategories();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public ArrayList<Product> viewCategoryItems(int categoryID) {
       ProductDBPresistence productDBPresistence = new ProductDBPresistence();
       ArrayList<Product> products = new ArrayList<>();
    
        try {
            products = productDBPresistence.getCategoryProducts(categoryID);
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void addCategory(int id, String name) {
        
        throw new UnsupportedOperationException("Unimplemented method 'AddCategory'");
    }

}

