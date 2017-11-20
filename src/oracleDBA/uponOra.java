package oracleDBA;

import objects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<joinUponInfo> joinUpon() {
        List<joinUponInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select Transactions.tday, Transactions.ttime, Transactions.tid, upon.ptype, Product.price"
                         + "from Transactions join upon on upon.tid = Transactions.tid "
                         + "join Product on Product.ptype = upon.ptype";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                String ptype = rs.getString("ptype");
                int price = rs.getInt("price");

                joinUponInfo jui = new joinUponInfo(tid, tday, ttime, ptype, price);
                ret.add(jui);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void insertUpon(int tid, String ptype) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into upon values (?,?)");
            ps.setInt(1, tid);
            ps.setString(2, ptype);
            ps.executeUpdate();
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TransactionsSumInfo> groupByTID() {
        List<TransactionsSumInfo> ret = new ArrayList<>();
        try {
            createTransJoinProd();

            Statement st = conn.createStatement();
            String query = "select tid, tamount, tday, ttime, cid, eid, sum(price) from trans_upon_prod "
                         + "group by tid";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                int tamount = rs.getInt("tamount");
                Date tday = rs.getDate("tday");
                String ttime = rs.getString("ttime");
                int cid = rs.getInt("cid");
                int eid = rs.getInt("eid");
                int sum = rs.getInt("sum(price)");

                TransactionsSumInfo tsi = new TransactionsSumInfo(tid, tamount, tday, ttime, cid, eid, sum);
                ret.add(tsi);
            }

            dropTransJoinProd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private void createTransJoinProd() {
        try {
            Statement st = conn.createStatement();
            String query = "create view trans_upon_product as "
                         + "select upon.tid, Transactions.tamount, Transactions.tday, Transactions.ttime, Transactions.cid, Transactions.eid, "
                         + "upon.ptype, Product.price, Product.stockAmount, Product.returnableFlag from Transactions "
                         + "join upon on upon.tid = Transactions.tid "
                         + "join Product on upon.ptype = Product.ptype";
            st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTransJoinProd() {
        try {
            Statement st = conn.createStatement();
            st.executeQuery("drop view trans_upon_product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
