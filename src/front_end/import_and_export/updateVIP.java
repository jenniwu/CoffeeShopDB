package front_end.import_and_export;

import front_end.mainPage.mainPageEmployee;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class updateVIP {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton submitButton;
    private JButton backButton;
    private JLabel title;

    private JLabel labelvBalance;
    private JLabel labelvPoints;
    private JLabel labelphone;
    private JLabel labelemail;

    private JTextField vBalance;
    private JTextField vPhone;
    private JTextField vEmail;
    private JTextField vPoints;

    private JLabel invalid;

    public updateVIP()
    {
        gui();
    }

    private void gui(){
        frame = new JFrame("Update VIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Update VIP ");

        labelvBalance = new JLabel("balance:");
        labelphone = new JLabel("phone #:");
        labelemail = new JLabel("email:");
        labelvPoints=new JLabel("LoyalPoints:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");

        vBalance = new JTextField(5);
        vPhone = new JTextField(5);
        vEmail = new JTextField(5);
        vPoints= new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);

        panelMiddle.add(labelvBalance);
        panelMiddle.add(vBalance);
        panelMiddle.add(labelphone);
        panelMiddle.add(vPhone);
        panelMiddle.add(labelemail);
        panelMiddle.add(vEmail);
        panelMiddle.add(labelvPoints);
        panelMiddle.add(vPoints);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {

            try{
                int balance = Integer.parseInt(vBalance.getText());

            }catch (NumberFormatException ex){

                System.out.println("Invalid inputs");
                invalid.setForeground(Color.red);
                return;
            }


            frame.setVisible(false);
            new mainPageEmployee();
        });

        backButton.addActionListener(e -> {
            frame.setVisible(false);
            new mainPageEmployee();
        });
    }
}
