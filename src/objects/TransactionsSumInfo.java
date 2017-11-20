package objects;

import java.sql.Date;

public class TransactionsSumInfo {
    int sum;
    String ptype;

    public TransactionsSumInfo(int sum, String ptype) {
        this.sum = sum;
        this.ptype = ptype;
    }

    public int getSum() {
        return sum;
    }

    public String getPtype() {
        return ptype;
    }
}
