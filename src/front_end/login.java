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
    private JCheckBox login_VIP;
    private JCheckBox login_Employee;
    private JCheckBox login_Manager;

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

        login_VIP = new JCheckBox("VIP");
        login_Employee = new JCheckBox("Employee");
        login_Manager = new JCheckBox("Manager");

        panelTop.add(labelUserName);
        panelMiddle.add(labelPassword);
        panelMiddle.add(pfPassword);
        panelMiddle.add(enter);
        panelBottom.add(login_VIP);
        panelBottom.add(login_Employee);
        panelBottom.add(login_Manager);
        panelBottom.add(wrong);
        frame.add(panelTop,BorderLayout.NORTH);
        frame.add(panelMiddle,BorderLayout.CENTER);
        frame.add(panelBottom,BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(enter);

        frame.setVisible(true);

        login_VIP.addActionListener(e -> {
            login_Employee.setSelected(false);
            login_Manager.setSelected(false);
        });

        login_Employee.addActionListener(e -> {
            login_VIP.setSelected(false);
            login_Manager.setSelected(false);
        });

        login_Manager.addActionListener(e -> {
            login_VIP.setSelected(false);
            login_Employee.setSelected(false);
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(pfPassword.getPassword());

                if(login_VIP.isSelected() && password.equals("vip")){
                    frame.setVisible(false);
                    new mainPageVIP();
                }else if(login_Employee.isSelected() && password.equals("employee")){
                    frame.setVisible(false);
                    new mainPageEmployee();
                }else if(login_Manager.isSelected() && password.equals("manager")){
                    frame.setVisible(false);
                    new mainPageManager();
                }else if(!login_VIP.isSelected() && !login_Manager.isSelected() && !login_Employee.isSelected()){
                    wrong.setText("Please select login user");
                    wrong.setForeground(Color.red);
                }else {
                    wrong.setText("wrong password");
                    wrong.setForeground(Color.red);
                }
                return;
            }
        });
    }
}
