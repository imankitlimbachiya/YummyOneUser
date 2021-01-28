package yummy.one.Models;

public class FeaturedVlogModel {

    int FeaturedVlogImage, FeaturedVlogerImage;
    String FeaturedVlogerName, FeaturedVlogerType;

    public FeaturedVlogModel(int FeaturedVlogImage) {
        this.FeaturedVlogImage = FeaturedVlogImage;
    }

    public int getFeaturedVlogImage() {
        return FeaturedVlogImage;
    }

    public void setFeaturedVlogImage(int featuredVlogImage) {
        FeaturedVlogImage = featuredVlogImage;
    }

    public int getFeaturedVlogerImage() {
        return FeaturedVlogerImage;
    }

    public void setFeaturedVlogerImage(int featuredVlogerImage) {
        FeaturedVlogerImage = featuredVlogerImage;
    }

    public String getFeaturedVlogerName() {
        return FeaturedVlogerName;
    }

    public void setFeaturedVlogerName(String featuredVlogerName) {
        FeaturedVlogerName = featuredVlogerName;
    }

    public String getFeaturedVlogerType() {
        return FeaturedVlogerType;
    }

    public void setFeaturedVlogerType(String featuredVlogerType) {
        FeaturedVlogerType = featuredVlogerType;
    }
}
