package front_end.view_information;

import front_end.mainPage;
import oracleDBA.SalaryInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class salary extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    public salary(List<SalaryInfo> list)
    {
        //headers for the table
        String[] columns = new String[] {
                "tier", "frequency", "bonus"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[list.size()][3];

        for (int y = 0; y < list.size(); y++)
        {
            data[y][0] = list.get(y).getTIER();
            data[y][1] = list.get(y).getFREQUENCY();
            data[y][2] = list.get(y).getBONUS();
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

        this.setTitle("Salary");
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