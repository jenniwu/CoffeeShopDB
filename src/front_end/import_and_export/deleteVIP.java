package front_end.import_and_export;

/**
 * Created by zhanghuanxin on 2017-11-19.
 */

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.VIPOra;

import javax.swing.*;
import java.awt.*;




public class deleteVIP {
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


    private JTextField vPhone;

    private JLabel invalid;

    private String back_user_type;

    public deleteVIP(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("delete VIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(3,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("delete VIP");

        labelphone = new JLabel("phone #:");

        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");

        vPhone = new JTextField(5);

        invalid = new JLabel();

        panelTop.add(title);

        panelMiddle.add(labelphone);
        panelMiddle.add(vPhone);

        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {

            String p = vPhone.getText();
            VIPOra vipOra = new VIPOra();
            if(vipOra.isValidPhone(p)){
                vipOra.deleteVipInDB(p);
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

