package oracleDBA;

import objects.SalaryInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SalaryOra {

    OracleManager oracleManager;
    Connection conn;

    public SalaryOra() {
        oracleManager = OracleManager.getInstance();
        conn = oracleManager.getConnection();
    }


    public List<SalaryInfo> getSalaries() {
        List<SalaryInfo> salaryInfos = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Salary");
            while (rs.next()) {
                int tier = rs.getInt("tier");
                String freq = rs.getString("frequency");
                int bonus = rs.getInt("bonus");
                SalaryInfo s = new SalaryInfo(tier, freq, bonus);
                salaryInfos.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salaryInfos;
    }

    public void InsertSalary(SalaryInfo s, int tier, String frequency, int bonus) {
        String sqlCommand1 = "insert into Salary values("
                + tier + ", "
                + frequency + ", "
                + bonus + ", "
                + "'" + ")";
        oracleManager.execute(sqlCommand1);
    }

    public boolean updateSalaryInDB(int tier, String frequency, int bonus) {
        oracleManager.getConnection();
        int rowCount = oracleManager.execute("UPDATE Employee SET frequency = "
                + frequency
                + " , bonus = "
                + bonus
                + " WHERE tier = "
                + tier);
        oracleManager.disconnect();
        if (rowCount == 1)
            return true;
        else
            return false;
    }

    public List<SalaryInfo> getSalariesByEmployee(int eid) {
        List<SalaryInfo> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            String query = "select * from Employee where eid = " + eid;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int tier = rs.getInt("tier");
                String freq = rs.getString("frequency");
                int bonus = rs.getInt("bonus");
                SalaryInfo s = new SalaryInfo(tier, freq, bonus);
                ret.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }


}
