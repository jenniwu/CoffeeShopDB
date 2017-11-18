package front_end;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton enter;
    private JLabel labelUserName;
    private JLabel labelPassword;
    private JPasswordField pfPassword;

    private JLabel wrong;

    public login()
    {
        gui();
    }

    public void gui(){
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelUserName = new JLabel("No Idea Coffee Shop");
        labelPassword = new JLabel("Password:");
        enter = new JButton("Login");
        wrong = new JLabel();
        pfPassword = new JPasswordField(5);

        panelTop.add(labelUserName);
        panelMiddle.add(labelPassword);
        panelMiddle.add(pfPassword);
        panelMiddle.add(enter);
        panelBottom.add(wrong);
        frame.add(panelTop,BorderLayout.NORTH);
        frame.add(panelMiddle,BorderLayout.CENTER);
        frame.add(panelBottom,BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(enter);

        frame.setVisible(true);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(pfPassword.getPassword());
                if(!password.equals("bla")) {
                    wrong.setText("wrong password!");
                    wrong.setForeground(Color.red);
                    return;
                }else {
                    frame.setVisible(false);
                    new mainPage();
                }
            }

        });
    }
}
