/**
 * Created by zhanghuanxin on 2017-11-17.
 */
package oracleDBA;

import java.util.Date;

public class VIPInfo {

    String PHONE;
    String EMAIL;
    int  LOYALTYPOINTS;
    Date BIRTHDAY;
    int BALANCE;
    int VIPNUM;

    public VIPInfo(String phone, String email, int loyapoints, Date birthday, int balance, int vipnum){
        this.PHONE = phone;
        this.EMAIL  = email;
        this.LOYALTYPOINTS  = loyapoints;
        this.BIRTHDAY= birthday;
        this.BALANCE=balance;
        this.VIPNUM=vipnum;
    }

    public String getPHONE(){
        return  PHONE;
    }

    public String getEMAIL(){
        return EMAIL;
    }

    public int getLOYALTYPOINTS(){
        return LOYALTYPOINTS;
    }

    public Date getBIRTHDAY(){
        return BIRTHDAY;
    }
    public int getBALANCE(){
        return BALANCE;
    }
    public int getVIPNUM(){
        return VIPNUM;
    }

    public void setPHONE(String p ){
        this.PHONE=p ;
    }

    public void setEMAIL(String e){
        this.EMAIL=e;
    }

    public void setLOYALTYPOINTS(int l){
        this.LOYALTYPOINTS=l;
    }

    public void setBIRTHDAY(Date d ){
        this.BIRTHDAY=d;
    }
    public void setBALANCE(int b){
         BALANCE=b;
    }
    public void setVIPNUM(int v){
         VIPNUM=v;
    }


}

