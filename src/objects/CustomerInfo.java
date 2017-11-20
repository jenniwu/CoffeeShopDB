package objects;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class CustomerInfo {
    int cid;
    String cname;
    String phone;

    public CustomerInfo(int cid, String cname, String phone){
        this.cid = cid;
        this.cname = cname;
        this.phone = phone;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getPhone() {
        return phone;
    }
}
