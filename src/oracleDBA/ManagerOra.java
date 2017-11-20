package oracleDBA;

import objects.ManagerInfo;

import java.sql.*;
import java.util.*;

public class ManagerOra {
    OracleManager oraMgr;
    Connection conn;

    public ManagerOra() {
        oraMgr = OracleManager.getInstance();
        conn = oraMgr.getConnection();
    }

    public List<ManagerInfo> getManagers() {
        List<ManagerInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Manager");

            while(rs.next()) {
                int mmid = rs.getInt("mmid");
                String mname = rs.getString("mname");

                ManagerInfo m = new ManagerInfo(mmid, mname);
                ret.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void addManager(int mmid, String mname) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Manager values (?,?)");
            ps.setInt(1, mmid);
            ps.setString(2, mname);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(int price, int stockAmount, String returnable, String pType) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Product values (?,?,?,?)");
            ps.setInt(1, price);
            ps.setInt(2, stockAmount);
            ps.setString(3, returnable);
            ps.setString(4, pType);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public boolean isValidMID(int mid) {
        try {
            Statement st = conn.createStatement();
            String query = "select 1 from Manager where mid = " + mid;
            ResultSet rs = st.executeQuery(query);
            if (!rs.next()) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
