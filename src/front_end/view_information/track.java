package front_end.view_information;

import front_end.mainPage;
import oracleDBA.trackInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class track extends JFrame
{
    private static final int width = 450;
    private static final int height = 400;

    public track(List<trackInfo> list)
    {
        //headers for the table
        String[] columns = new String[] {
                "product id","phone","mid"
        };
        Object[][] data = new Object[list.size()][3];

        for (int y = 0; y < list.size(); y++)
        {
            data[y][0] = list.get(y).getPid();
            data[y][1] = list.get(y).getSphone();
            data[y][2] = list.get(y).getMmid();
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

        this.setTitle("Track");
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