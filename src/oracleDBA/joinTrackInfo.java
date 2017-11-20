package oracleDBA;

public class joinTrackInfo extends trackInfo {
    int price;
    int stockAmount;
    String returnable;
    String sname;
    String mname;

    public joinTrackInfo(String ptype, String sphone, int mmid, int price, int stockAmount, String returnable, String sname, String mname) {
        super(ptype, sphone, mmid);
        this.price = price;
        this.stockAmount = stockAmount;
        this.returnable = returnable;
        this.sname = sname;
        this.mname = mname;
    }

    public int getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getReturnable() {
        return returnable;
    }

    public String getSname() {
        return sname;
    }

    public String getMname() {
        return mname;
    }
}
