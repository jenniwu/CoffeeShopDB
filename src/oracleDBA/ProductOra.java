package oracleDBA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductOra {
    OracleManager oraMgr;
    Connection conn;

    public ProductOra() {
        oraMgr = OracleManager.getInstance();
        conn = oraMgr.getConnection();
    }

    public List<ProductInfo> getProducts() {
        List<ProductInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Product");

            while(rs.next()) {
                int price = rs.getInt("price");
                int stockAmount = rs.getInt("stockAmount");
                String flag = rs.getString("returnableFlag");
                String pType = rs.getString("ptype");

                ProductInfo p = new ProductInfo(price,stockAmount,flag,pType);
                ret.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void addProduct(int pID, int price, int stockAmount, boolean returnable, String pType) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Product values (?,?,?,?)");
            ps.setInt(1, price);
            ps.setInt(2, stockAmount);
            ps.setBoolean(3, returnable);
            ps.setString(4, pType);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable(int orderAmount, String pType) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select stockAmount from Product where ptype = pType");
            while (rs.next()) {
                if (orderAmount > rs.getInt("stockAmount")) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void updateStock(int deltaAmount, String pType) {
        try {
            Statement st = conn.createStatement();
            String query = "select stockAmount from Product where ptype = " + pType;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int newAmount = rs.getInt("stockAmount") + deltaAmount;
                PreparedStatement ps = conn.prepareStatement("update Product set stockAmount = ? where pType = ?");
                ps.setInt(1, newAmount);
                ps.setString(2, pType);
                ps.executeUpdate();
                conn.commit();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
