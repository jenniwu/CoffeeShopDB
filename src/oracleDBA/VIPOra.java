package oracleDBA;

import java.sql.*;
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

    public boolean deleteVipInDB(int phone) {
        oracleManager.getConnection();

        int rowCount = oracleManager.execute("DELETE from Vip WHERE phone = "
                + phone);

        oracleManager.disconnect();

        if (rowCount == 1)
            return true;
        else
            return false;
    }

    public boolean updateVipEmailInDB(int phone, String email) {
        oracleManager.getConnection();
        String query = "UPDATE Employee SET email = '"
                + email
                + "' WHERE phone = '"
                + phone + "'";
        System.out.println(query);
        int rowCount = oracleManager.execute(query);
        oracleManager.disconnect();

        if (rowCount != 1)
            return false;
        else
            return true;

    }

    public boolean updateVipLPInDB(int phone, int loyaltypoints) {
        oracleManager.getConnection();
        String query = "UPDATE Vip SET loyaltypoints = "
                + loyaltypoints
                + "' WHERE phone = '"
                + phone + "'";
        System.out.println(query);
        int rowCount = oracleManager.execute(query);
        oracleManager.disconnect();

        if (rowCount != 1)
            return false;
        else
            return true;

    }

    public boolean updateVipDolBalInDB(int phone, int dollarBalance) {
        oracleManager.getConnection();
        String query = "UPDATE Vip SET dollarBalance = "
                + dollarBalance
                + "' WHERE phone = '"
                + phone + "'";
        System.out.println(query);
        int rowCount = oracleManager.execute(query);
        oracleManager.disconnect();

        if (rowCount != 1)
            return false;
        else
            return true;

    }

    public void addVip(String phone, String email, Date birthday, int dollarBalance, int eid) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Vip values (?,?,?,?)");
            ps.setString(1, phone);
            ps.setString(2, email);
            ps.setDate(3, (java.sql.Date) birthday);
            ps.setInt(4, dollarBalance);
            ps.setInt(5, eid);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
