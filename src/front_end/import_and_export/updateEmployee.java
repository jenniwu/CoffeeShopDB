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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateEmployee {
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

    private JLabel labelEmployeePosition;

    private JLabel labelEmployeeid;

    private JTextField ePosition;
    private JTextField eid;

    private JLabel invalid;


    private String back_user_type;

    public updateEmployee(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("Upadete Employee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPosition = new JPanel(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel("Update Employee Position");

        labelEmployeePosition = new JLabel("position:");

        labelEmployeeid = new JLabel("Employee id:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");

        ePosition = new JTextField(5);
        eid = new JTextField(5);
        invalid = new JLabel();


        panelTop.add(title);

        panelMiddle.add(labelEmployeePosition);
        panelMiddle.add(ePosition);
        panelMiddle.add(panelPosition);
        panelMiddle.add(labelEmployeeid);
        panelMiddle.add(eid);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String position = ePosition.getText();
                String id = eid.getText();
                int idNum = Integer.parseInt(id);
                EmployeeOra employeeOra = new EmployeeOra();
                if(employeeOra.isValidEID(idNum)){
                    employeeOra.updateEmployeePosition(idNum,position);

                    invalid.setText("Update Success");
                    invalid.setForeground(Color.GREEN);
                }else{
                    invalid.setText("Invalid EID");
                    invalid.setForeground(Color.red);
                    return;
                }
                return;
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
