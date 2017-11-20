package front_end.extra_window;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import front_end.view_information.vip;
import oracleDBA.VIPOra;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class vip_identify_for_infor {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JButton submitButton;
    private JButton backButton;
    private JLabel lablePhone;
    private JTextField phone;

    private JLabel invalid;

    private String back_user_type;

    public vip_identify_for_infor(String userType)
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

        lablePhone = new JLabel("vip phone:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        phone=new JTextField(5);
        invalid = new JLabel();


        panelTop.add(lablePhone);
        panelTop.add(phone);
        panelMiddle.add(submitButton);
        panelMiddle.add(backButton);
        panelMiddle.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String p = phone.getText();

            VIPOra vipOra = new VIPOra();

            if(!vipOra.isValidPhone(p)) {
                invalid.setText("Invalid phone");
                invalid.setForeground(Color.red);
                return;
            }else {
                new vip(vipOra.getVipFromOwn(p),"vip");
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
