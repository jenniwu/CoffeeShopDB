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

    public void addProduct(int pID, int price, int stockAmount, boolean returnable, String pName) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Product values (?,?,?,?,?)");
            ps.setInt(1, pID);
            ps.setInt(2, price);
            ps.setInt(3, stockAmount);
            ps.setBoolean(4, returnable);
            ps.setString(5, pName);
            ps.executeUpdate();
            conn.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Product");

            List<ProductInfo> ret = new ArrayList<>();

            while(rs.next()) {
                int pID = rs.getInt("pid");
                int price = rs.getInt("price");
                int stockAmount = rs.getInt("stockAmount");
                boolean flag = rs.getBoolean("returnableFlag");
                String pType = rs.getString("ptype");

                ProductInfo p = new ProductInfo(pID,price,stockAmount,flag,pType);
                ret.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
