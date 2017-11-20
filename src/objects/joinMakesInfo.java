package objects;

/**
 * Created by shadongliu on 2017-11-18.
 */
import java.sql.Date;

public class joinMakesInfo extends makesInfo{
    int tid;
    Date tday;
    String ttime;
    int eid;
    int cid;
    String cname;
    String phone;
    String email;
    int  lotaltypoints;
    Date birthday;
    int dollarBalance;


    public joinMakesInfo(int rating, int tid, Date tday, String ttime, int eid, int cid, String cname, String phone, String email, int lotaltypoints, Date birthday,int dollarBalance){
        super(rating);
        this.tid = tid;
        this.tday = tday;
        this.ttime = ttime;
        this.eid = eid;
        this.cid = cid;
        this.cname = cname;
        this.phone = phone;
        this.email = email;
        this.lotaltypoints = lotaltypoints;
        this.birthday = birthday;
        this.dollarBalance = dollarBalance;
    }

    public int getRating() {
        return rating;
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

    public int getEid() {
        return eid;
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

    public String getEmail() {
        return email;
    }

    public int getLotaltypoints() {
        return lotaltypoints;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getDollarBalance() {
        return dollarBalance;
    }
}
