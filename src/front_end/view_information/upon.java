package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import objects.uponInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class upon extends JFrame
{
    // TODO: table makes only have one attribute, I think we need to create view and then do rating

    private static final int width = 450;
    private static final int height = 400;

    private String back_user_type;

    public upon(List<uponInfo> list,String userType)
    {
        this.back_user_type = userType;
        //headers for the table
        String[] columns = new String[] {
                "transaction id","product id"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][2];

        for (int y = 0; y < list.size(); y++)
        {
            data[y][0] = list.get(y).getTid();
            data[y][1] = list.get(y).getPid();
        }

        //create table with data
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton back = new JButton("Back to main page");

        panel.add(back);

        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);

        this.setTitle("Upon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setVisible(true);

        back.addActionListener(e -> {
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