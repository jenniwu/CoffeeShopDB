package front_end.import_and_export;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import oracleDBA.ProductOra;
import oracleDBA.TransactionsOra;
import oracleDBA.uponOra;

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
    private JPanel coffeePanel;
    private JPanel coffeeBeanPanel;
    private JPanel coffeeMachinePanel;
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

    private String back_user_type;

    public make_order(String type)
    {
        this.back_user_type = type;
        gui();
    }

    private void gui(){
        frame = new JFrame("Make Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);
        ProductOra productOra = new ProductOra();
        TransactionsOra transactionsOra = new TransactionsOra();
        uponOra uo = new uponOra();

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(3,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coffeePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coffeeBeanPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coffeeMachinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
        coffeePanel.add(labelCoffee);
        coffeeBeanPanel.add(labelCoffeeBean);
        coffeeMachinePanel.add(labelCoffeeMachine);

        panelMiddle.add(coffeePanel);
        panelMiddle.add(coffee);
        panelMiddle.add(coffeeBeanPanel);
        panelMiddle.add(coffeeBean);
        panelMiddle.add(coffeeMachinePanel);
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
            if(!productOra.isAvailable(a,"coffee")|| !productOra.isAvailable(b,"coffee beans")|| !productOra.isAvailable(c,"coffee machine")){
                invalid.setText("Not enough products in stock");
                invalid.setForeground(Color.red);
                return;
            } else {
                int aPrice = productOra.getPrice("coffee");
                int bPrice = productOra.getPrice("coffee beans");
                int cPrice = productOra.getPrice("coffee machine");
                int aAmount = a*aPrice;
                int bAmount = b*bPrice;
                int cAmount = c*cPrice;
                if (aAmount != 0) {
                    int tid = transactionsOra.generateTID();
                    transactionsOra.insertTransactions(tid, aAmount, 1, 1234);
                    uo.insertUpon(tid, "coffee");
                    productOra.updateStock(-a,"coffee");
                }
                if (bAmount != 0) {
                    int tid = transactionsOra.generateTID();
                    transactionsOra.insertTransactions(tid, bAmount, 1, 1234);
                    uo.insertUpon(tid, "coffee beans");
                    productOra.updateStock(-b,"coffee beans");
                }
                if (cAmount != 0) {
                    int tid = transactionsOra.generateTID();
                    transactionsOra.insertTransactions(tid, cAmount, 1, 1234);
                    uo.insertUpon(tid, "coffee machine");
                    productOra.updateStock(-c,"coffee machine");
                }
            }

            invalid.setText("Make Order Successful");
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
