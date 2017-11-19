package oracleDBA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierOra {
    OracleManager oraMgr;
    Connection conn;

    public SupplierOra() {
        oraMgr = OracleManager.getInstance();
        conn = oraMgr.getConnection();
    }

    public List<SupplierInfo> getSuppliers() {
        List<SupplierInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Supplier");

            while(rs.next()) {
                String sphone = rs.getString("sphone");
                String sname = rs.getString("sname");

                SupplierInfo s = new SupplierInfo(sphone, sname);
                ret.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void addSupplier(String sphone, String sname) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Supplier values (?,?)");
            ps.setString(1, sphone);
            ps.setString(2, sname);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
