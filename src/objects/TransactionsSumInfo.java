package objects;

import java.sql.Date;

public class TransactionsSumInfo extends TransactionsInfo {
    int sum;

    public TransactionsSumInfo(int tid, int tamount, Date tday, String ttime, int cid, int eid, int sum) {
        super(tid, tamount, tday, ttime, cid, eid);
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
