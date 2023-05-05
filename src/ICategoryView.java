import java.util.ArrayList;

public interface ICategoryView {
    ArrayList<Category> viewCategories();
    void ViewCategoryItems(Category category);
    void AddCategory(int id,String name);
}
