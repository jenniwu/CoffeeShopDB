package oracleDBA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VIPOra {

    OracleManager oracleManager;
    Connection conn;

    public VIPOra(){
        oracleManager = OracleManager.getInstance();
        conn = oracleManager.getConnection();
    }



    public List<VIPInfo> getVIPs() {
        List<VIPInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Vip");

            while(rs.next()) {
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int loyaltyPoints = rs.getInt("loyaltyPoints");
                Date birthday = rs.getDate("birthday");
                int dollarBalance = rs.getInt("dollarBalance");
                int eid = rs.getInt("eid");

                VIPInfo vipInfo = new VIPInfo(phone,email,loyaltyPoints,birthday,dollarBalance,eid);
                ret.add(vipInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
