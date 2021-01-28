package yummy.one.Models;

public class CategoryModel {

    int CategoryImage;
    String CategoryID, CategoryTitle, CategoryItemCount;

    public CategoryModel(String CategoryTitle, int CategoryImage) {
        this.CategoryTitle = CategoryTitle;
        this.CategoryImage = CategoryImage;
    }

    public CategoryModel(String CategoryTitle, String CategoryItemCount) {
        this.CategoryTitle = CategoryTitle;
        this.CategoryItemCount = CategoryItemCount;
    }

    public int getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        CategoryImage = categoryImage;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public String getCategoryItemCount() {
        return CategoryItemCount;
    }

    public void setCategoryItemCount(String categoryItemCount) {
        CategoryItemCount = categoryItemCount;
    }
}
