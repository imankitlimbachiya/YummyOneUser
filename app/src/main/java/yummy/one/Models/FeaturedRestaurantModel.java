package yummy.one.Models;

public class FeaturedRestaurantModel {

    int FeaturedRestaurantImage;
    String FeatureRestaurantName;

    public FeaturedRestaurantModel(int FeaturedRestaurantImage) {
        this.FeaturedRestaurantImage = FeaturedRestaurantImage;
    }

    public FeaturedRestaurantModel(int FeaturedRestaurantImage, String FeatureRestaurantName) {
        this.FeaturedRestaurantImage = FeaturedRestaurantImage;
        this.FeatureRestaurantName = FeatureRestaurantName;
    }

    public int getFeaturedRestaurantImage() {
        return FeaturedRestaurantImage;
    }

    public void setFeaturedRestaurantImage(int featuredRestaurantImage) {
        FeaturedRestaurantImage = featuredRestaurantImage;
    }

    public String getFeatureRestaurantName() {
        return FeatureRestaurantName;
    }

    public void setFeatureRestaurantName(String featureRestaurantName) {
        FeatureRestaurantName = featureRestaurantName;
    }
}
