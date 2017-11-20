package front_end.view_information;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import objects.joinUponInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class joinedUpon extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    private String back_user_type;

    public joinedUpon(List<joinUponInfo> list, String userType)
    {
        this.back_user_type = userType;
        //headers for the table
        String[] columns = new String[] {
                "transaction day", "transaction time", "price"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][3];

        for (int y = 0; y < list.size(); y++)
        {
            data[y][0] = list.get(y).getTday();
            data[y][1] = list.get(y).getTtime();
            data[y][2] = list.get(y).getPrice();
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

        this.setTitle("Joined Upon");
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
            }else if(back_user_type.equals("mansager")){
                new mainPageManager();
            }else if(back_user_type.equals("temp")){
                new mainPageTemp();
            }
        });
    }
}