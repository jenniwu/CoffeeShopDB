package oracleDBA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class trackOra {
    OracleManager oraMgr;
    Connection conn;

    public trackOra() {
        oraMgr = OracleManager.getInstance();
        conn = oraMgr.getConnection();
    }

    public List<trackInfo> getTracks() {
        List<trackInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from track");

            while(rs.next()) {
                int pid = rs.getInt("pid");
                String sphone = rs.getString("sphone");
                int mmid = rs.getInt("mmid");

                trackInfo trackInfo = new trackInfo(pid,sphone,mmid);
                ret.add(trackInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
