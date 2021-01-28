package yummy.one.Models;

public class OfferModel {

    int OfferImage;
    String OfferID, OfferTitle;

    public OfferModel(String OfferTitle, int OfferImage) {
        this.OfferTitle = OfferTitle;
        this.OfferImage = OfferImage;
    }

    public int getOfferImage() {
        return OfferImage;
    }

    public void setOfferImage(int offerImage) {
        OfferImage = offerImage;
    }

    public String getOfferID() {
        return OfferID;
    }

    public void setOfferID(String offerID) {
        OfferID = offerID;
    }

    public String getOfferTitle() {
        return OfferTitle;
    }

    public void setOfferTitle(String offerTitle) {
        OfferTitle = offerTitle;
    }
}
