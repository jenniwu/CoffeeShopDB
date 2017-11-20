package objects;

public class SalaryInfo {
    int TIER     ;
    String  FREQUENCY ;
    int BONUS;

    public SalaryInfo(int tier , String  frequency , int bonus  ){

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

}

