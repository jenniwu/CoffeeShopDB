package front_end.import_and_export;

/**
 * Created by zhanghuanxin on 2017-11-19.
 */


import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.EmployeeOra;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class deleteEmployee {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JPanel panelPosition;
    private JButton submitButton;
    private JButton backButton;
    private JLabel title;

    private JLabel labelEmployee;

    private JTextField eID;

    private JLabel invalid;

    private String back_user_type;


    public deleteEmployee(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("Delete Employee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPosition = new JPanel(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel("Delete Employee");

        labelEmployee = new JLabel("Employee id:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");

        eID = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);

        panelMiddle.add(panelPosition);
        panelMiddle.add(labelEmployee);
        panelMiddle.add(eID);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);


        submitButton.addActionListener(e -> {

            String eId = eID.getText();
            int eIDNum = Integer.parseInt(eId);
            EmployeeOra employeeOra = new EmployeeOra();
            if(employeeOra.isValidEID(eIDNum)){
                employeeOra.deleteEmployeeInDB(eIDNum);
            }else{
                invalid.setText("Invalid");
                invalid.setForeground(Color.red);
                return;
            }

            invalid.setText("Success");
            invalid.setForeground(Color.GREEN);
        });

        backButton.addActionListener(e -> {
            frame.setVisible(false);
            if(back_user_type.equals("vip")){
                new mainPageVIP();
            }else if(back_user_type.equals("employee")){
                new mainPageEmployee();
            }else if(back_user_type.equals("manager")){
                new mainPageManager();
            }else {
                new mainPageTemp();
            }
        });
    }
}

