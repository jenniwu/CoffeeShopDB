package front_end.view_information;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import objects.joinSalaryInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class joinedSalary extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    private String back_user_type;

    public joinedSalary(List<joinSalaryInfo> list, String userType)
    {
        this.back_user_type = userType;
        //headers for the table
        String[] columns = new String[] {
                "employee id", "employee name", "position", "tier", "manager id"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][5];

        for (int y = 0; y < list.size(); y++)
        {
            data[y][0] = list.get(y).getEID();
            data[y][1] = list.get(y).getENAME();
            data[y][2] = list.get(y).getPOSITION();
            data[y][3] = list.get(y).getTIER();
            data[y][4] = list.get(y).getMMID();
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

        this.setTitle("Joined Track");
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
            }else if(back_user_type.equals("temp")){
                new mainPageTemp();
            }
        });
    }
}