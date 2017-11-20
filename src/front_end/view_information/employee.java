package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.EmployeeInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class employee extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    private String back_user_type;

    public employee(List<EmployeeInfo> list,String userType)
    {
        this.back_user_type = userType;

        //headers for the table
        String[] columns = new String[] {
                "employee id", "name", "tier", "position", "manager id"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][5];

        for (int x = 0; x < list.size(); x++)
        {
            data[x][0] = list.get(x).getEID();
            data[x][1] = list.get(x).getENAME();
            data[x][2] = list.get(x).getTIER();
            data[x][3] = list.get(x).getPOSITION();
            data[x][4] = list.get(x).getMMID();

        }

        //create table with data
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Back to main page");
        panel.add(backButton);
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);

        this.setTitle("Employee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setVisible(true);

        backButton.addActionListener(e -> {
            setVisible(false);
            if(back_user_type.equals("vip")){
                new mainPageVIP();
            }else if(back_user_type.equals("employee")){
                new mainPageEmployee();
            }else if(back_user_type.equals("manager")){
                new mainPageManager();
            }else {
                new mainPageTemp();
            }
        });
    }
}