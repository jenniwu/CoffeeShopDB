package oracleDBA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class uponOra {
    OracleManager oraMgr;
    Connection conn;

    public uponOra() {
        oraMgr = OracleManager.getInstance();
        conn = oraMgr.getConnection();
    }

    public List<uponInfo> getUpons() {
        List<uponInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from upon");

            while(rs.next()) {
                int tid = rs.getInt("tid");
                int pid = rs.getInt("pid");

                uponInfo upon = new uponInfo(tid, pid);
                ret.add(upon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
