package oracleDBA;

import objects.TransactionsInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by shadongliu on 2017-11-18.
 */
public class TransactionsOra {
    OracleManager om;
    Connection conn;

    public TransactionsOra() {
        om = OracleManager.getInstance();
        conn = om.getConnection();
    }

    public List<TransactionsInfo> getTransactions() {
        List<TransactionsInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Transactions");

            while (rs.next()) {
                int tid = rs.getInt("tid");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");
                int eid = rs.getInt("eid");

                TransactionsInfo ti = new TransactionsInfo(tid, tday, ttime, cid, eid);
                ret.add(ti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void insertTransactions(int tid, Date tday, String ttime, int cid, int eid){
        String sqlCommand1 = "insert into Transactions values("
                +  tid  + ", "
                + "'" + tday + "'" + ", "
                + cid + ", " + eid
                + ")";
        om.execute(sqlCommand1);
    }

    public boolean updateTransactionsInDB(int tid , Date tday , String ttime, int cid, int eid) {
        om.getConnection();
        int rowCount = om.execute("UPDATE Transactions SET tday = "
                + tday
                + " , ttime = "
                + ttime
                + " , cid = "
                + cid
                + " , eid = "
                + eid
                + " WHERE tid = "
                + tid);
        om.disconnect();
        if (rowCount == 1)
            return true;
        else
            return false;
    }

    public List<TransactionsInfo> getTransactionsByEmployee(int eid) {
        List<TransactionsInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select * from Transactions where eid = " + eid;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");

                TransactionsInfo ti = new TransactionsInfo(tid, tday, ttime, cid, eid);
                ret.add(ti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
