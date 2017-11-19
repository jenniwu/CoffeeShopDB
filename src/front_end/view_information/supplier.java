package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage;
import oracleDBA.SupplierInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class supplier extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    public supplier(List<SupplierInfo> list)
    {
        //headers for the table
        String[] columns = new String[] {
                "phone", "company name"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][2];

        for (int x = 0; x < list.size(); x++)
        {
            data[x][0] = list.get(x).getSphone();
            data[x][1] = list.get(x).getSname();

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

        this.setTitle("Supplier");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setVisible(true);

        back.addActionListener(e -> {
            setVisible(false);
            new mainPage();
        });
    }
}