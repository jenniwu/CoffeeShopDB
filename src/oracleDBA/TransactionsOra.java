package oracleDBA;

import objects.InputInfo;
import objects.TransactionsInfo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionsOra {
    OracleManager om;
    Connection conn;
    Random rand;

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
                int tamount = rs.getInt("tamount");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");
                int eid = rs.getInt("eid");

                TransactionsInfo ti = new TransactionsInfo(tid, tamount, tday, ttime, cid, eid);
                ret.add(ti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int generateTID() {
        rand = new Random();
        int tid = rand.nextInt(99999);
        if(isValidTID(tid)) generateTID();
        return tid;
    }

    public void insertTransactions(int tid, int tamount, int cid, int eid) {
        java.util.Date date = new java.util.Date();
        Date tday = new Date(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String ttime = sdf.format(date);
        String sqlCommand1 = "insert into Transactions values ("
                    + tid + ", "
                    + tamount + ", "
                    + "'" + tday + "', "
                    + "'" + ttime + "',"
                    + cid + ", " + eid + ")";
            om.execute(sqlCommand1);
    }

    public boolean isValidTID(int tid) {
        try {
            Statement st = conn.createStatement();
            String query = "select 1 from Transactions where tid = " + tid;
            ResultSet rs = st.executeQuery(query);
            if (!rs.next()) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<InputInfo> getTransactionsJoinEmployee() {
        List<InputInfo> ret = new ArrayList<>();

        try {
            createTransJoinEmpl();
            Statement st = conn.createStatement();
            String query = "select * from trans_input_empl";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String ename = rs.getString("ename");
                int eid = rs.getInt("eid");
                String pos = rs.getString("position");
                int tier = rs.getInt("tier");
                int mmid = rs.getInt("mmid");
                int tid = rs.getInt("tid");
                java.sql.Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");

                InputInfo ii = new InputInfo(tid, tday, ttime, tier, mmid, eid, ename, pos, cid);
                ret.add(ii);
            }

            dropTransJoinEmpl();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public List<TransactionsInfo> getTransactionsByEmployee(int eid) {
        List<TransactionsInfo> ret = new ArrayList<>();

        try {
            createTransJoinEmpl();
            Statement st = conn.createStatement();
            String query = "select tid, tamount, tday, ttime, cid from trans_input_empl where eid = " + eid;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                int tamount = rs.getInt("tamount");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");

                TransactionsInfo ti = new TransactionsInfo(tid, tamount, tday, ttime, cid, eid);
                ret.add(ti);
            }

            dropTransJoinEmpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public List<TransactionsInfo> getTransactionsByDate(Date fromDay, Date toDay) {
        List<TransactionsInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            String query = "select * from Transactions where tday between '" + fromDay + "' and '" + toDay + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                int tamount = rs.getInt("tamount");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");
                int eid = rs.getInt("eid");

                TransactionsInfo ti = new TransactionsInfo(tid, tamount, tday, ttime, cid, eid);
                ret.add(ti);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public List<TransactionsInfo> getTransactionsEmpDate(int eid, Date fromDay, Date toDay) {
        List<TransactionsInfo> ret = new ArrayList<>();

        try {
            createTransJoinEmpl();
            Statement st = conn.createStatement();
            String query = "select tid, tday, ttime, cid, eid from trans_input_empl "
                    + "where ( tday between '" + fromDay + "' and '" + toDay + "' ) and eid = " + eid;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                int tamount = rs.getInt("tamount");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");

                TransactionsInfo ti = new TransactionsInfo(tid, tamount, tday, ttime, cid, eid);
                ret.add(ti);
            }

            dropTransJoinEmpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private void createTransJoinEmpl() {
        try {
            Statement st = conn.createStatement();
            String query = "create view trans_input_empl as "
                    + "select Employee.ename, Employee.eid, Employee.position, Employee.tier, Employee.mmid, "
                    + "Transactions.tid, Transactions.tamount, Transactions.tday, Transactions.ttime, Transactions.cid "
                    + "from Employee join Transactions on Employee.eid = Transactions.eid";
            st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTransJoinEmpl() {
        try {
            Statement st = conn.createStatement();
            st.executeQuery("drop view trans_input_empl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}