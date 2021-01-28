package yummy.one.Models;

public class TopRestaurantModel {

    int TopRestaurantImage;
    String TopRestaurantID, TopRestaurantTitle;

    public TopRestaurantModel(String TopRestaurantTitle, int TopRestaurantImage) {
        this.TopRestaurantID = TopRestaurantID;
        this.TopRestaurantTitle = TopRestaurantTitle;
        this.TopRestaurantImage = TopRestaurantImage;
    }

    public int getTopRestaurantImage() {
        return TopRestaurantImage;
    }

    public void setTopRestaurantImage(int topRestaurantImage) {
        TopRestaurantImage = topRestaurantImage;
    }

    public String getTopRestaurantID() {
        return TopRestaurantID;
    }

    public void setTopRestaurantID(String topRestaurantID) {
        TopRestaurantID = topRestaurantID;
    }

    public String getTopRestaurantTitle() {
        return TopRestaurantTitle;
    }

    public void setTopRestaurantTitle(String topRestaurantTitle) {
        TopRestaurantTitle = topRestaurantTitle;
    }
}
