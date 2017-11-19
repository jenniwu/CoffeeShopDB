package front_end.import_and_export;

import front_end.mainPage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class make_order {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton submitButton;
    private JButton backButton;
    private JLabel title;
    private JLabel labelCoffee;
    private JLabel labelCoffeeBean;
    private JLabel labelCoffeeMachine;
    private JTextField coffee;
    private JTextField coffeeBean;
    private JTextField coffeeMachine;

    private JLabel invalid;

    public make_order()
    {
        gui();
    }

    private void gui(){
        frame = new JFrame("Make Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(3,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Make Order");
        labelCoffee = new JLabel("Coffee:");
        labelCoffeeBean = new JLabel("Coffee Bean:");
        labelCoffeeMachine = new JLabel("Coffee Machine:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        coffee = new JTextField(5);
        coffeeBean = new JTextField(5);
        coffeeMachine = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);
        panelMiddle.add(labelCoffee);
        panelMiddle.add(coffee);
        panelMiddle.add(labelCoffeeBean);
        panelMiddle.add(coffeeBean);
        panelMiddle.add(labelCoffeeMachine);
        panelMiddle.add(coffeeMachine);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String amountCOFFEE = coffee.getText();
            String amountCOFFEE_BEAN = coffeeBean.getText();
            String amountCOFFEE_MACHINE = coffeeMachine.getText();

            boolean flag = true;
            int a = 0;
            int b = 0;
            int c = 0;
            try {
                a = Integer.parseInt(amountCOFFEE);
                b = Integer.parseInt(amountCOFFEE_BEAN);
                c = Integer.parseInt(amountCOFFEE_MACHINE);
            }catch (NumberFormatException err){
                flag = false;
            }
            if(!flag || a<0 || b <0 || c<0 || amountCOFFEE.length() == 0 || amountCOFFEE_BEAN.length() == 0 || amountCOFFEE_MACHINE.length() == 0) {
                invalid.setText("Invalid amount");
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