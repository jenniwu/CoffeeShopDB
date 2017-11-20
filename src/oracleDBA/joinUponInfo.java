package oracleDBA;

import java.util.Date;

public class joinUponInfo extends uponInfo {
    Date tday;
    String ttime;

    public joinUponInfo( int tid, Date tday, String ttime, String pType) {
        super(tid, pType);
        this.tday = tday;
        this.ttime = ttime;
    }


}
