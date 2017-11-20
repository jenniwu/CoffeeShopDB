package objects;

/**
 * Created by shadongliu on 2017-11-19.
 */
public class joinSalaryInfo extends SalaryInfo{
    int EID;
    String ENAME ;
    String POSITION ;
    int TIER ;
    int MMID ;

    public joinSalaryInfo(int tier , String  frequency , int bonus, int EID , String ENAME, String POSITION, int TIER, int MMID ){
        super(tier, frequency, bonus);
        this.TIER = tier;
        this.FREQUENCY = frequency;
        this.BONUS = bonus;
    }

    public int getTIER(){
        return TIER;
    }
    public String getFREQUENCY(){
        return FREQUENCY;
    }
    public int getBONUS(){
        return BONUS;
    }

    public int getEID() {
        return EID;
    }

    public String getENAME() {
        return ENAME;
    }

    public int getMMID() {
        return MMID;
    }

    public String getPOSITION() {
        return POSITION;
    }
}
