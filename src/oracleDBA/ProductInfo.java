package oracleDBA;

public class ProductInfo {

    int pID;
    int price;
    int stockAmount;
    boolean returnable;
    String productType;

    public ProductInfo(int pID, int price, int stockAmount, boolean returnable, String productType) {
        this.pID = pID;
        this.price = price;
        this.stockAmount = stockAmount;
        this.returnable = returnable;
        this.productType = productType;
    }

    public int getpID() {
        return pID;
    }

    public int getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public boolean getReturnable() {
        return returnable;
    }

    public String getProductType() {
        return productType;
    }
}

