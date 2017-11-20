/**
 * Created by zhanghuanxin on 2017-11-17.
 */
package oracleDBA;

import java.util.Date;

public class VIPInfo {

    String phone;
    String email;
    int  lotaltypoints;
    Date birthday;
    int dollarBalance;
    int eid;

    public VIPInfo(String phone, String email, int loyaltypoints, Date birthday, int dollarBalance, int eid){
        this.phone = phone;
        this.email  = email;
        this.lotaltypoints  = loyaltypoints;
        this.birthday= birthday;
        this.dollarBalance= dollarBalance;
        this.eid=eid;
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

    public int getEid() {
        return eid;
    }
}

