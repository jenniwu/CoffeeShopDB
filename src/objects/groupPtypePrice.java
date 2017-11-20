package objects;

public class groupPtypePrice {
    int price;
    String ptype;

    public groupPtypePrice(int price, String ptype) {
        this.price = price;
        this.ptype = ptype;
    }

    public int getPrice() {
        return price;
    }

    public String getPtype() {
        return ptype;
    }
}
