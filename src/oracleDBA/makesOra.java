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

    public void insertMakes(int rating) {
        String sqlCommand1 = "insert into makes values("
                + rating + ")";
        om.execute(sqlCommand1);
    }

}

