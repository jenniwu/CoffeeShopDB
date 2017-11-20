package front_end.extra_window;

import front_end.mainPage.mainPageEmployee;
import front_end.mainPage.mainPageManager;
import front_end.mainPage.mainPageTemp;
import front_end.mainPage.mainPageVIP;
import front_end.view_information.transaction;
import oracleDBA.EmployeeOra;
import oracleDBA.TransactionsOra;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 11/16/2017.
 */
public class transaction_for_manager {
    private static final int width = 450;
    private static final int height = 400;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton submitButton;
    private JButton backButton;
    private JButton viewAll;
    private JLabel labelid;
    private JLabel labelfrom;
    private JLabel labelto;
    private JTextField eId;
    private JTextField eFrom;
    private JTextField eTo;

    private JLabel invalid;

    private String back_user_type;

    public transaction_for_manager(String userType)
    {
        this.back_user_type = userType;
        gui();
    }

    private void gui(){
        frame = new JFrame("View Transaction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(5,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        labelid = new JLabel("employee id:");
        labelfrom = new JLabel("from:");
        labelto = new JLabel("to:");
        submitButton = new JButton("Submit");
        backButton = new JButton("Back to main page");
        viewAll = new JButton("View All Transactions");
        eId = new JTextField(5);
        eFrom = new JTextField(5);
        eTo = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(viewAll);
        panelMiddle.add(labelid);
        panelMiddle.add(eId);
        panelMiddle.add(labelfrom);
        panelMiddle.add(eFrom);
        panelMiddle.add(labelto);
        panelMiddle.add(eTo);
        panelBottom.add(submitButton);
        panelBottom.add(backButton);
        panelBottom.add(invalid,BorderLayout.AFTER_LINE_ENDS);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);

        viewAll.addActionListener(e -> {
            TransactionsOra transactionsOra = new TransactionsOra();

            frame.setVisible(false);
            if(back_user_type.equals("vip")){
                new transaction(transactionsOra.getTransactions(),"vip");
            }else if(back_user_type.equals("employee")){
                new transaction(transactionsOra.getTransactions(),"employee");
            }else if(back_user_type.equals("manager")){
                new transaction(transactionsOra.getTransactions(),"manager");
            }else if(back_user_type.equals("temp")){
                new transaction(transactionsOra.getTransactions(),"temp");
            }
        });

        submitButton.addActionListener(e -> {
            String id = eId.getText();
            String from = eFrom.getText();
            String to = eTo.getText();

            TransactionsOra transactionsOra = new TransactionsOra();
            EmployeeOra employeeOra = new EmployeeOra();

            if(id.length() != 0 && from.length() != 0 && to.length() != 0){
                int idNum = Integer.parseInt(id);
                java.sql.Date fromDate = java.sql.Date.valueOf(from);
                java.sql.Date tpDate = java.sql.Date.valueOf(to);
                if(employeeOra.isValidEID(idNum)){
                    transactionsOra.getTransactionsEmpDate(idNum,fromDate,tpDate);
                }else {
                    invalid.setText("Invalid Employee ID");
                    invalid.setForeground(Color.red);
                    return;
                }
            }else if (id.length() != 0) {
                int idNum = Integer.parseInt(id);
                if(employeeOra.isValidEID(idNum)){
                    frame.setVisible(false);
                    new transaction(transactionsOra.getTransactionsByEmployee(idNum),"manager");
                }else {
                    invalid.setText("Invalid Employee ID");
                    invalid.setForeground(Color.red);
                    return;
                }
            } else if(from.length() != 0 && to.length() != 0){
                java.sql.Date fromDate = java.sql.Date.valueOf(from);
                java.sql.Date tpDate = java.sql.Date.valueOf(to);
                frame.setVisible(false);
                new transaction(transactionsOra.getTransactionsByDate(fromDate,tpDate),"manager");
            }else {
                invalid.setText("Please enter enough information.");
                invalid.setForeground(Color.red);
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
            }else if(back_user_type.equals("temp")){
                new mainPageTemp();
            }
        });
    }
}
