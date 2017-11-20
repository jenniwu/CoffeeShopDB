package front_end.extra_window;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.VIPOra;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class VIP_identify_for_info {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JButton submitButton;
    private JButton backButton;
    private JLabel labelEmployeeId;
    private JTextField eId;

    private JLabel invalid;

    private String back_user_type;

    public VIP_identify_for_info(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("VIP Identification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new GridLayout(5,2));
        panelMiddle = new JPanel(new FlowLayout(FlowLayout.CENTER));

        labelEmployeeId = new JLabel("phone numebr:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        eId = new JTextField(5);
        invalid = new JLabel();


        panelTop.add(labelEmployeeId);
        panelTop.add(eId);
        panelMiddle.add(submitButton);
        panelMiddle.add(backButton);
        panelMiddle.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String id = eId.getText();
            int eId = Integer.parseInt(id);
            VIPOra vipOra = new VIPOra();

//            if() {
//                invalid.setText("Invalid Phone");
//                invalid.setForeground(Color.red);
//                return;
//            }else {
//                new vip(employeeOra.getEmployeeByOwn(eId),"employee");
//            }

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
