package objects;

public class trackInfo {
    String ptype;
    String sphone;
    int mmid;

    public trackInfo(String ptype, String sphone, int mmid){
        this.ptype = ptype;
        this.sphone = sphone;
        this.mmid = mmid;
    }

    public String getPtype() {
        return ptype;
    }

    public String getSphone() {
        return sphone;
    }

    public int getMmid() {
        return mmid;
    }
}
