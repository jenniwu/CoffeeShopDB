package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage;
import oracleDBA.makesInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class makes extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    public makes(List<makesInfo> list)
    {
        //headers for the table
        String[] columns = new String[] {
                "rating"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][1];

        for (int x = 0; x < list.size(); x++)
        {
            data[x][0] = list.get(x).getRating();

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

        this.setTitle("Makes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setVisible(true);

        backButton.addActionListener(e -> {
            setVisible(false);
            new mainPage();
        });
    }
}