package oracleDBA;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VIPOra {

    OracleManager oracleManager;

    public VIPOra(){

        oracleManager = new OracleManager();
    }



    public VIPInfo getReservation(String resID) {
        VIPInfo res = null;
        oracleManager.getConnection();
        ResultSet rs = oracleManager.query("select * from VIP ");
        //RESID FROMDATE TODATE   FIRSTNAME	LASTNAME PHONENUM RTNAME
        try {
            while(rs.next())
            {
                res = new VIPInfo(res.getPHONE(),res.getEMAIL(),res.getLOYALTYPOINTS(),res.getBIRTHDAY(),res.getBALANCE(),res.getVIPNUM());

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return res;
    }

}
