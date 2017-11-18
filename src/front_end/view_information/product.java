package front_end.view_information; /**
 * Created by zhanghuanxin on 2017-11-16.
 */

import front_end.mainPage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class product extends JFrame
{

    private static final int width = 450;
    private static final int height = 400;

    public product(List<List> list)
    {
        String[] columns = new String[] {
                "product id", "price", "stock amount", "return?", "product type"
        };

        Object[][] data = new Object[list.size()][list.get(0).size()];

        for (int x = 0; x < list.size(); x++)
        {
            for(int y = 0; y < list.get(0).size(); y++){
                data[x][y] = list.get(x).get(y);
            }
        }
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton back = new JButton("Back to main page");

        panel.add(back);

        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Product");
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