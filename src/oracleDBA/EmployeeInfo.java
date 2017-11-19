/**
 * Created by zhanghuanxin on 2017-11-17.
 */
package oracleDBA;

public class EmployeeInfo {

    int EID;
    String ENAME ;
    String POSITION ;
    int TIER ;
    int MMID ;

    public EmployeeInfo(int eid , String ename , String position ,  int tier , int mmid ){
        this.EID=eid;
        this.ENAME=ename;
        this.POSITION= position;
        this.TIER=tier;
        this.MMID=mmid;
    }

    public int getEID(){
        return  EID;
    }

    public String getENAME(){
        return ENAME;
    }

    public String getPOSITION(){
        return POSITION;
    }

    public int getTIER(){
        return TIER;
    }
    public int getMMID(){
        return MMID;
    }

}

