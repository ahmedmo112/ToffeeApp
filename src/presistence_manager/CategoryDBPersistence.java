package presistence_manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import category_view_manager.Category;

public class CategoryDBPersistence {
    private String dataFilePath;

    public CategoryDBPersistence() {
        this.dataFilePath = "src\\data\\categories.txt";
    }

    public ArrayList<Category> getAllCategories() throws IOException {
        ArrayList<Category> categoryList = readCategoryDataFromFile();

        return categoryList;
    }

   

    private ArrayList<Category> readCategoryDataFromFile() throws IOException {
        ArrayList<Category> categories = new ArrayList<>();

       BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                
                Category category = new Category(id, name);
                categories.add(category);
            }
        

        return categories;
    }
}