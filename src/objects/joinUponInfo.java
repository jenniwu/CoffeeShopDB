package objects;

import java.util.Date;

public class joinUponInfo extends uponInfo {
    Date tday;
    String ttime;
    int price;

    public joinUponInfo( int tid, Date tday, String ttime, String pType, int price) {
        super(tid, pType);
        this.tday = tday;
        this.ttime = ttime;
        this.price = price;
    }

    public Date getTday() {
        return tday;
    }

    public String getTtime() {
        return ttime;
    }

    public int getPrice() {
        return price;
    }
}
