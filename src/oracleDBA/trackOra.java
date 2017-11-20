package oracleDBA;

import objects.joinTrackInfo;
import objects.trackInfo;

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
                String ptype = rs.getString("ptype");
                String sphone = rs.getString("sphone");
                int mmid = rs.getInt("mmid");

                trackInfo trackInfo = new trackInfo(ptype,sphone,mmid);
                ret.add(trackInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public List<joinTrackInfo> joinTrack() {
        List<joinTrackInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select Supplier.sname, track.sphone, "
                         + "Product.ptype, Product.price, Product.stockAmount, Product.returnableFlag, "
                         + "track.mmid, Manager.mname from Product "
                         + "join track on track.ptype = Product.ptype "
                         + "join Supplier on Supplier.sphone = track.sphone "
                         + "join Manager on Manager.mmid = track.mmid";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String sname = rs.getString("sname");
                String phone = rs.getString("sphone");
                String ptype = rs.getString("ptype");
                int price = rs.getInt("price");
                int stockAmount = rs.getInt("stockAmount");
                String returnable = rs.getString("returnableFlag");
                int mmid = rs.getInt("mmid");
                String mname = rs.getString("mname");


                joinTrackInfo jti = new joinTrackInfo(ptype, phone, mmid, price, stockAmount, returnable, sname, mname);
                ret.add(jti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
