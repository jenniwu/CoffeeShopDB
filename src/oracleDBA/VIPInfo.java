/**
 * Created by zhanghuanxin on 2017-11-17.
 */
package oracleDBA;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

public class VIPInfo {

/*	phone	         email		        loyalty points           birthday       balance        VIP#
	-------------------- -------------------- ------------------------------------------------------------
	6047796888 	     huanxin@11.com 		 2                   1998-11-21      2              1
	*/

    String PHONE;
    String EMAIL;
    int  LOYALTYPOINTS;
    Date BIRTHDAY;
    int BALANCE;
    String VIPNUM;

    public VIPInfo(String phone, String email, int loyapoints, Date birthday, int balance, String vipnum){
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
    public String getVIPNUM(){
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
    public void setVIPNUM(String   v){
         VIPNUM=v;
    }

    public void viewInfo() {
        // TODO Auto-generated method stub
        System.out.println(PHONE + " " + EMAIL + " " + LOYALTYPOINTS + " " + BIRTHDAY);

    }

}

