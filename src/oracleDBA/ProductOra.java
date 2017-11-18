package oracleDBA;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ProductOra {

    OracleManager oracleManager;

    public ProductOra(){

        oracleManager = new OracleManager();
    }



    public ProductInfo getReservation(String resID) {
        ProductInfo res = null;
        oracleManager.buildConnection();
        ResultSet rs = oracleManager.query("select * from Product ");
        //RESID FROMDATE TODATE   FIRSTNAME	LASTNAME PHONENUM RTNAME
        // int PRODUCTID;
       // int  PRICE;
        //int STOCKAMOUNT;
        //boolean RETURN;
        //String PRODUCTTYPE;
        try {
            while(rs.next())
            {
                res = new ProductInfo(res.getPRODUCTID(),res.getPRICE(),res.getSTOCKAMOUNT(),res.getRETURN(),res.getPRODUCTTYPE());

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return res;
    }

}
