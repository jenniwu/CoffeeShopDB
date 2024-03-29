package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import objects.VIPInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class vip extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    private String back_user_type;

    public vip(List<VIPInfo> list,String userType)
    {
        back_user_type = userType;
        //headers for the table
        String[] columns = new String[] {
                "phone", "email", "loyalty points", "birthday", "balance", "employee id"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][6];

        for (int x = 0; x < list.size(); x++)
        {
            data[x][0] = list.get(x).getPhone();
            data[x][1] = list.get(x).getEmail();
            data[x][2] = list.get(x).getLotaltypoints();
            data[x][3] = list.get(x).getBirthday();
            data[x][4] = list.get(x).getDollarBalance();
            data[x][5] = list.get(x).getEid();

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

        this.setTitle("VIP");
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