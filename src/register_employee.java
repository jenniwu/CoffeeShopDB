import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11/16/2017.
 */
public class register_employee {
    private static final int width = 450;
    private static final int height = 350;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JPanel panelPosition;
    private JButton button;
    private JLabel title;
    private JLabel labelEmployeeName;
    private JLabel labelSIN;
    private JLabel labelPosition;
    private JTextField eName;
    private JTextField eSIN;
    private JTextField ePosition;

    private JLabel invalid;


    private JCheckBox stuffCheckBox;
    private JCheckBox superStuffCheckBox;

    public register_employee()
    {
        gui();
    }

    private void gui(){
        frame = new JFrame("Auto Chrome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPosition = new JPanel(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel("Employee register         ");
        labelEmployeeName = new JLabel("name:    ");
        labelSIN = new JLabel("SIN #:    ");
        labelPosition = new JLabel("position:                      ");
        button = new JButton("Submit");
        eName = new JTextField(5);
        eSIN = new JPasswordField(5);
        invalid = new JLabel();

        stuffCheckBox = new JCheckBox("stuff");
        superStuffCheckBox = new JCheckBox("super stuff");

        panelTop.add(title);
        panelMiddle.add(labelEmployeeName);
        panelMiddle.add(eName);
        panelMiddle.add(labelSIN);
        panelMiddle.add(eSIN);
        panelMiddle.add(labelPosition);
        panelPosition.add(stuffCheckBox);
        panelPosition.add(superStuffCheckBox);
        panelMiddle.add(panelPosition);
        panelBottom.add(button);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(button);

        frame.setVisible(true);

        stuffCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superStuffCheckBox.setSelected(false);
            }
        });

        superStuffCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stuffCheckBox.setSelected(false);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = eName.getText();
                String password = eSIN.getText();
                if(username.equals("") || password.length()<5) {
                    System.out.println("Invalid inputs");
                    invalid.setText("Missing user info");
                    invalid.setForeground(Color.red);
                    return;
                }
                frame.setVisible(false);
                new mainPage();
            }

        });
    }
}
