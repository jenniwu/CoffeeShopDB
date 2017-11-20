package oracleDBA;

import objects.TransactionsInfo;
import objects.joinMakesInfo;
import objects.makesInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class makesOra {
    OracleManager om;
    Connection conn;

    public makesOra() {
        om = OracleManager.getInstance();
        conn = om.getConnection();
    }

    public List<makesInfo> getMakes() {
        List<makesInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from makes");

            while (rs.next()) {
                int rating = rs.getInt("rating");

                makesInfo m = new makesInfo(rating);
                ret.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public List<joinMakesInfo> joinMake(){
        List<joinMakesInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select Transactions.tid, Transactions.tday, Transactions.ttime"
                    + "Vip.phone, Vip.email, Vip.loyaltypoints, Vip.birthday, Vip.dollarBalance"
                    + "track.rating from Customer"
                    + "join Transactions on Customer.cid = Transactions.cid"
                    + "join makes"
                    + "join Vip on Customer.phone = Vip.phone";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int rating = rs.getInt("rating");
                int tid = rs.getInt("tid");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int eid = rs.getInt("eid");
                int cid = rs.getInt("cid");
                String phone = rs.getString("phone");
                String cname = rs.getString("cname");
                String email = rs.getString("email");
                int loyaltypoints = rs.getInt("loyaltypoints");
                Date birthday = rs.getDate("birthday");
                int dollarBalance = rs.getInt("dollarBalance");


                joinMakesInfo jmi = new joinMakesInfo(rating, tid, tday, ttime, eid, cid, cname, phone,email, loyaltypoints,birthday,dollarBalance);
                ret.add(jmi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }




    public void insertMakes(int rating) {
        String sqlCommand1 = "insert into makes values("
                + rating + ")";
        om.execute(sqlCommand1);
    }

}

