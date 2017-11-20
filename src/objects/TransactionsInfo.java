package objects;

import java.sql.Date;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class TransactionsInfo {
    int tid;
    int tamount;
    Date tday;
    String ttime;
    int cid;
    int eid;

    public TransactionsInfo(int tid, int tamount, Date tday, String ttime, int cid, int eid) {
        this.tid = tid;
        this.tamount = tamount;
        this.tday = tday;
        this.ttime = ttime;
        this.cid = cid;
        this.eid = eid;
    }

    public int getTid() {
        return tid;
    }

    public int getTamount() {
        return tamount;
    }

    public Date getTday() {
        return tday;
    }

    public String getTtime() {
        return ttime;
    }

    public int getCid() {
        return cid;
    }

    public int getEid() {
        return eid;
    }
}
