package oracleDBA;

import objects.TransactionsSumInfo;
import objects.joinUponInfo;
import objects.uponInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

    public List<TransactionsSumInfo> groupTransactionsByProd(String ptype) {
        List<TransactionsSumInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select sum(price), tday, ttime, tid, ptype from trans_upon_prod ";
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
////            Statement st = conn.createStatement();
////            String query = "select Transactions.tday, Transactions.ttime, Transactions.tid, upon.ptype, Product.price"
////                    + "from Transactions join upon on upon.tid = Transactions.tid "
////                    + "join Product on Product.ptype = upon.ptype";
////            ResultSet rs = st.executeQuery(query);
////
////            while (rs.next()) {
////                int tid = rs.getInt("tid");
////                Date tday = rs.getDate("tday");
////                String ttime = rs.getString("ttime");
////                String ptype = rs.getString("ptype");
////                int price = rs.getInt("price");
////
////                joinUponInfo jui = new joinUponInfo(tid, tday, ttime, ptype, price);
////                ret.add(jui);
////            }


        return ret;
    }

    private void createTransJoinProd() {
        try {
            Statement st = conn.createStatement();
            String query = "create view trans_upon_product as "
                         + "select upon.tid, Transactions.tday, Transactions.ttime, Transactions.cid, Transactions.eid, "
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
            st.executeQuery("trans_upon_product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
