package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class upon extends JFrame
{
    // TODO: table makes only have one attribute, I think we need to create view and then do rating

    private static final int width = 450;
    private static final int height = 400;

    public upon(List<List> list)
    {
        //headers for the table
        String[] columns = new String[] {
                "transaction id","product id"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][list.get(0).size()];

        for (int x = 0; x < list.size(); x++)
        {
            for(int y = 0; y < list.get(0).size(); y++){
                data[x][y] = list.get(x).get(y);
            }
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

        this.setTitle("Makes");
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