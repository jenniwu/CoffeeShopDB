package objects;

import java.sql.Date;

public class InputInfo {
    int tid;
    Date tday;
    String ttime;
    int tier;
    int mmid;
    int eid;
    String ename;
    String position;
    int cid;

    public InputInfo(int tid, Date tday, String ttime, int tier, int mmid, int eid, String ename, String position, int cid) {
        this.tid = tid;
        this.tday = tday;
        this.ttime = ttime;
        this.tier = tier;
        this.mmid = mmid;
        this.eid = eid;
        this.ename = ename;
        this.position = position;
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public Date getTday() {
        return tday;
    }

    public String getTtime() {
        return ttime;
    }

    public int getTier() {
        return tier;
    }

    public int getMmid() {
        return mmid;
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getPosition() {
        return position;
    }

    public int getCid() {
        return cid;
    }
}
