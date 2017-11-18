import oracleDBA.OracleManager;

/**
 * Created by user on 8/30/2017.
 */
public class main {
       public static void main(String[] args){

        new mainPage();
           OracleManager oraManager = new OracleManager();
           oraManager.buildConnection();

    }
}
