package front_end.registration;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.EmployeeOra;
import oracleDBA.ManagerOra;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class register_employee {
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
    private JLabel labelEmployeeName;
    private JLabel labelEmployeePosition;
    private JLabel labelEmployeeTier;
    private JLabel labelEmployeeManager;
    private JTextField eName;
    private JTextField ePosition;
    private JTextField eManager;

    private JLabel invalid;


    private JCheckBox tierOneCheckBox;
    private JCheckBox tierTwoCheckBox;
    private JCheckBox tierThreeCheckBox;

    private String back_user_type;

    public register_employee(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("Register Employee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPosition = new JPanel(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel("Employee Register");
        labelEmployeeName = new JLabel("name:");
        labelEmployeePosition = new JLabel("position:");
        labelEmployeeTier = new JLabel("tier:");
        labelEmployeeManager = new JLabel("manager id:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        eName = new JTextField(5);
        ePosition = new JTextField(5);
        eManager = new JTextField(5);
        invalid = new JLabel();

        tierOneCheckBox = new JCheckBox("tier 1");
        tierTwoCheckBox = new JCheckBox("tier 2");
        tierThreeCheckBox = new JCheckBox("tier 3");

        panelTop.add(title);
        panelMiddle.add(labelEmployeeName);
        panelMiddle.add(eName);
        panelMiddle.add(labelEmployeePosition);
        panelMiddle.add(ePosition);
        panelMiddle.add(labelEmployeeTier);
        panelPosition.add(tierOneCheckBox);
        panelPosition.add(tierTwoCheckBox);
        panelPosition.add(tierThreeCheckBox);
        panelMiddle.add(panelPosition);
        panelMiddle.add(labelEmployeeManager);
        panelMiddle.add(eManager);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        tierOneCheckBox.addActionListener(e -> {
            tierTwoCheckBox.setSelected(false);
            tierThreeCheckBox.setSelected(false);
        });

        tierTwoCheckBox.addActionListener(e -> {
            tierOneCheckBox.setSelected(false);
            tierThreeCheckBox.setSelected(false);
        });

        tierThreeCheckBox.addActionListener(e -> {
            tierOneCheckBox.setSelected(false);
            tierTwoCheckBox.setSelected(false);
        });

        submitButton.addActionListener(e -> {
            String name = eName.getText();
            String position = ePosition.getText();
            String managerID = eManager.getText();
            int mIDInt = Integer.parseInt(managerID);
            ManagerOra managerOra = new ManagerOra();
            EmployeeOra employeeOra = new EmployeeOra();

            if(name.length() == 0|| position.length() == 0 || !managerOra.isValidMID(mIDInt)) {
                System.out.println("Invalid inputs");
                invalid.setText("Missing user info");
                invalid.setForeground(Color.red);
                return;
            }else {
                int tierNum = 0;
                if(tierOneCheckBox.isSelected()){
                    tierNum = 1;
                }else if(tierTwoCheckBox.isSelected()){
                    tierNum = 2;
                }else if(tierThreeCheckBox.isSelected()){
                    tierNum = 3;
                }else {
                    invalid.setText("Please select tier");
                    return;
                }
                employeeOra.insertEmployee(name,position,tierNum,mIDInt);

                invalid.setText("Register Employee Successfully");
                invalid.setForeground(Color.GREEN);
            }

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
