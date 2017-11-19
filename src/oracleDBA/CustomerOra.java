package oracleDBA;

/**
 * Created by shadongliu on 2017-11-18.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerOra {
    OracleManager om;
    Connection conn;

    public CustomerOra() {
        om = OracleManager.getInstance();
        conn = om.getConnection();
    }

    public List<CustomerInfo> getCustomer() {
        List<CustomerInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer");

            while (rs.next()) {
                int cid = rs.getInt("cid");
                String sname = rs.getString("sname");
                String phone = rs.getString("phone");

                CustomerInfo ci = new CustomerInfo(cid, sname, phone);
                ret.add(ci);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void InsertCustomer(CustomerInfo c,int cid , String sname , String phone){
        String sqlCommand1 = "insert into Customer values("
                +  cid  + ", "
                + "'" + sname + "'" + ", "
                + "'" + phone + "'" + ", "
                + ")";
        om.execute(sqlCommand1);
    }

    public boolean updateCustomerInDB( int cid , String sname , String phone) {
        om.getConnection();
        int rowCount = om.execute("UPDATE Customer SET phone = "
                + phone
                + " , sname = "
                + sname
                + " WHERE cid = "
                + cid);
        om.disconnect();
        if (rowCount == 1)
            return true;
        else
            return false;
    }
}