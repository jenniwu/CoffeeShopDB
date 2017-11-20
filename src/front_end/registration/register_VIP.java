package front_end.registration;

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
public class register_VIP {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton submitButton;
    private JButton backButton;
    private JLabel title;
    private JLabel labelphone;
    private JLabel labelemail;
    private JLabel labelBirthday;
    private JTextField vPhone;
    private JTextField vEmail;
    private JTextField vBirthday;

   private JLabel invalid;

    private String back_user_type;

    public register_VIP(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("Register VIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(4,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("VIP Register");
        labelphone = new JLabel("phone #:");
        labelemail = new JLabel("email:");
        labelBirthday = new JLabel("birthday:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        vPhone = new JTextField(5);
        vEmail = new JTextField(5);
        vBirthday = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);
        panelMiddle.add(labelphone);
        panelMiddle.add(vPhone);
        panelMiddle.add(labelemail);
        panelMiddle.add(vEmail);
        panelMiddle.add(labelBirthday);
        panelMiddle.add(vBirthday);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String VIPphone = vPhone.getText();
            String VIPEmail = vEmail.getText();
            String VIPBirthday = vBirthday.getText();
            java.sql.Date sqlDate = java.sql.Date.valueOf(VIPBirthday);

            if(VIPphone.length() == 0 || VIPEmail.length() == 0 || VIPBirthday.length() == 0) {
                System.out.println("Invalid inputs");
                invalid.setText("Missing user info");
                invalid.setForeground(Color.red);
                return;
            }

            VIPOra vipOra = new VIPOra();
            vipOra.addVip(VIPphone,VIPEmail,0,sqlDate,0,1234);
            invalid.setText("Register Successfully");
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
