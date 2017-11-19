package oracleDBA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class uponOra {
    OracleManager om;
    Connection conn;

    public uponOra() {
        om = OracleManager.getInstance();
        conn = om.getConnection();
    }

    public List<uponInfo> getUpons() {
        List<uponInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from upon");

            while (rs.next()) {
                int tid = rs.getInt("tid");
                String ptype = rs.getString("ptype");

                uponInfo up = new uponInfo(tid,ptype);
                ret.add(up);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
