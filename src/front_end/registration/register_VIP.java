package front_end.registration;

import front_end.mainPage;

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
    private JLabel labelvName;
    private JLabel labelphone;
    private JLabel labelemail;
    private JTextField vName;
    private JTextField vPhone;
    private JTextField vEmail;

    private JLabel invalid;

    public register_VIP()
    {
        gui();
    }

    private void gui(){
        frame = new JFrame("Register VIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(3,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("VIP Register");
        labelvName = new JLabel("name:");
        labelphone = new JLabel("phone #:");
        labelemail = new JLabel("email:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        vName = new JTextField(5);
        vPhone = new JTextField(5);
        vEmail = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);
        panelMiddle.add(labelvName);
        panelMiddle.add(vName);
        panelMiddle.add(labelphone);
        panelMiddle.add(vPhone);
        panelMiddle.add(labelemail);
        panelMiddle.add(vEmail);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String VIPname = vName.getText();
            String VIPphone = vPhone.getText();
            if(VIPname.equals("") || VIPphone.length()!=10) {
                System.out.println("Invalid inputs");
                invalid.setText("Missing user info");
                invalid.setForeground(Color.red);
                return;
            }
            frame.setVisible(false);
            new mainPage();
        });

        backButton.addActionListener(e -> {
            frame.setVisible(false);
            new mainPage();
        });
    }
}
