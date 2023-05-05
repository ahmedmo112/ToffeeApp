import java.util.ArrayList;

public class CategoryView implements ICategoryView{
    ArrayList<Category> categories;

    @Override
    public ArrayList<Category> viewCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category(1, "Category 1"));
        categories.add(new Category(2, "Category 2"));
        categories.add(new Category(3, "Category 3"));
        categories.add(new Category(4, "Category 4"));
        categories.add(new Category(5, "Category 5"));
        return categories;
    }

    @Override
    public ArrayList<Product> viewCategoryItems(int categoryID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ViewCategoryItems'");
    }

    @Override
    public void addCategory(int id, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddCategory'");
    }

}

