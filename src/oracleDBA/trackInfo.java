package oracleDBA;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class trackInfo {
    int pid;
    String sphone;
    int mmid;

    public trackInfo(int pid, String sphone, int mmid){
        this.pid = pid;
        this.sphone = sphone;
        this.mmid = mmid;
    }

    public int getPid() {
        return pid;
    }

    public String getSphone() {
        return sphone;
    }

    public int getMmid() {
        return mmid;
    }
}
