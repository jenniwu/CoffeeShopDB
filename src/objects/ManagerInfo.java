package objects;

public class ManagerInfo {
    int mmid;
    String mname;

    public ManagerInfo(int mmid, String mname) {
        this.mmid = mmid;
        this.mname = mname;
    }

    public int getMmid() {
        return mmid;
    }

    public String getMname() {
        return mname;
    }
}
