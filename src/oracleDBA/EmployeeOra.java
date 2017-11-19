package oracleDBA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeOra {

    OracleManager oracleManager;
    Connection conn;

    public EmployeeOra(){

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

    public void InsertEmployee(EmployeeInfo e, int eid , String ename , String position ,  int tier , int mmid){
        String sqlCommand1 = "insert into Employee values("
                +  eid  + ", "
                +  ename + ", "
                + position + ", "
                + tier + ", "
                + mmid+  "'" + ")";
        oracleManager.execute(sqlCommand1);
    }
}
