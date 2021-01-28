package yummy.one.Models;

public class ItemModel {

    int ItemImage;
    String ItemTitle, ItemPrice;

    public ItemModel(String ItemTitle, String ItemPrice, int ItemImage) {
        this.ItemTitle = ItemTitle;
        this.ItemPrice = ItemPrice;
        this.ItemImage = ItemImage;
    }

    public int getItemImage() {
        return ItemImage;
    }

    public void setItemImage(int itemImage) {
        ItemImage = itemImage;
    }

    public String getItemTitle() {
        return ItemTitle;
    }

    public void setItemTitle(String itemTitle) {
        ItemTitle = itemTitle;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }
}
