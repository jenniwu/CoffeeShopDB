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

    /** gets all rows in Product table
     * @return      list of ProductInfo objects
     */
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

    /** adds new product to Product table
     * @param price             price of product
     * @param stockAmount       stock amount of product
     * @param returnable        whether the product is returnable
     * @param pType             type of product
     */
    public void addProduct(int price, int stockAmount, boolean returnable, String pType) {
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

    /** checks whether ptype for the specified order amount is available in stock
     * @param orderAmount   the amount to order
     * @param pType         the type of product to order
     * @return              boolean to indicate whether order amount is feasible
     */
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

    /** updates the stock amount of specified product
     * @param deltaAmount       change to be made to the stock amount
     * @param pType             type of product to update
     */
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
