/**
 * Created by zhanghuanxin on 2017-11-17.
 */
package oracleDBA;

public class ProductInfo {

/*	phone	         email		        loyalty points           birthday       balance        VIP#
	-------------------- -------------------- ------------------------------------------------------------
	6047796888 	     huanxin@11.com 		 2                   1998-11-21      2              1
	*/

    int PRODUCTID;
    int  PRICE;
    int STOCKAMOUNT;
    boolean RETURN;
    String PRODUCTTYPE;


    public ProductInfo(int productid, int price, int stockamount, boolean r, String producttype){
        this.PRODUCTID = productid;
        this.PRICE  = price;
        this.STOCKAMOUNT  = stockamount;
        this.RETURN   = r;
        this.PRODUCTTYPE=producttype;

    }

    public int getPRODUCTID(){
        return      PRODUCTID;
    }

    public int getPRICE(){
        return PRICE;
    }

    public int getSTOCKAMOUNT(){
        return STOCKAMOUNT;
    }

    public boolean getRETURN(){
        return RETURN;
    }
    public String getPRODUCTTYPE(){
        return PRODUCTTYPE;
    }


    public void viewInfo() {
        // TODO Auto-generated method stub
        System.out.println(PRODUCTID + " " + PRICE + " " + STOCKAMOUNT + " " + RETURN+"  "+PRODUCTTYPE);

    }

}

