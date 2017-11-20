package oracleDBA;

import objects.EmployeeInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EmployeeOra {

    OracleManager oracleManager;
    Connection conn;
    Random rand;

    public EmployeeOra() {
        oracleManager = OracleManager.getInstance();
        conn = oracleManager.getConnection();
    }

    public List<EmployeeInfo> getEmployees() {
        List<EmployeeInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Employee");

            while(rs.next()) {
                int eid = rs.getInt("eid");
                String mname = rs.getString("ename");
                String position = rs.getString("position");
                int tier = rs.getInt("tier");
                int mmid = rs.getInt("mmid");

                EmployeeInfo employeeInfo = new EmployeeInfo(eid,mname,position,tier,mmid);
                ret.add(employeeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void insertEmployee(String ename, String position, int tier, int mmid) {
        rand = new Random();
        int eid = rand.nextInt(9999);
        if (!isValidEID(eid)) {
            try {
                PreparedStatement ps = conn.prepareStatement("insert into Employee values (?,?,?,?,?)");
                ps.setInt(1, eid);
                ps.setString(2, ename);
                ps.setString(3, position);
                ps.setInt(4, tier);
                ps.setInt(5, mmid);
                ps.executeUpdate();
                conn.commit();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else insertEmployee(ename, position, tier, mmid);
    }

    public boolean isValidEID(int eid) {
        try {
            Statement st = conn.createStatement();
            String query = "select 1 from Employee where eid = " + eid;
            ResultSet rs = st.executeQuery(query);
            if (!rs.next()) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int getEID(String ename) {
        int eid = 0;
        try {
            Statement st = conn.createStatement();
            String query = "select eid from Employee where ename = '" + ename + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) eid = rs.getInt("eid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eid;
    }

    public List<EmployeeInfo> getEmployeeByManager(int mmid) {
        List<EmployeeInfo> ret = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String query = "select * from Employee where mmid = " + mmid;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int eid = rs.getInt("eid");
                String ename = rs.getString("ename");
                String position = rs.getString("position");
                int tier = rs.getInt("tier");

                EmployeeInfo ei = new EmployeeInfo(eid, ename, position, tier, mmid);
                ret.add(ei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public List<EmployeeInfo> getEmployeeByOwn(int eid){
        List<EmployeeInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            String query = "select * from Employee where eid = " + eid;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String ename = rs.getString("ename");
                String position = rs.getString("position");
                int tier = rs.getInt("tier");
                int mmid = rs.getInt("mmid");

                EmployeeInfo ei = new EmployeeInfo(eid, ename, position, tier, mmid);
                ret.add(ei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void deleteEmployeeInDB(int eid) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Employee where eid = " + eid);
            ps.executeUpdate();
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateEmployeePosition(int eid, String position) {
        try {
            PreparedStatement ps = conn.prepareStatement("update Employee set position = ? where eid = ?");
            ps.setString(1, position);
            ps.setInt(2, eid);
            ps.executeUpdate();
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
