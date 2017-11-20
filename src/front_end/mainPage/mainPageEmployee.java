package front_end.mainPage;

import front_end.extra_window.employee_identify_for_infor;
import front_end.extra_window.employee_identify_for_salary;
import front_end.import_and_export.make_order;
import front_end.login;
import front_end.registration.register_VIP;
import front_end.view_information.product;
import front_end.view_information.transaction;
import front_end.view_information.vip;
import oracleDBA.ProductOra;
import oracleDBA.TransactionsOra;
import oracleDBA.VIPOra;

import javax.swing.*;

public class mainPageEmployee {
    private static final int width = 450;
    private static final int height = 450;

    private JFrame frame;
    private JPanel panel;
    private JButton registerNewVIP;
    private JButton makeOrder;
    private JButton VIPInformation;
    // TODO: enable to see employee himself/herslf employee information, we require a new window to type in eid.
    private JButton employeeInformation;
    private JButton productInformation;
    private JButton transactionInformation;
    // TODO: enable to see employee himself/herslf salary information, we require a new window to type in eid.
    private JButton salaryInformation;
    private JButton logout;

    public mainPageEmployee()
    {
        gui();
    }

    public void BoxOfButton(){
        Box box = Box.createVerticalBox();
        box.add(registerNewVIP);
        box.add(Box.createVerticalStrut(10));
        box.add(makeOrder);
        box.add(Box.createVerticalStrut(10));
        box.add(VIPInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(transactionInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(productInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(employeeInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(salaryInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(logout);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerNewVIP = new JButton("Register VIP");
        makeOrder = new JButton("Make Order");
        VIPInformation = new JButton("VIP Information");
        employeeInformation = new JButton("Employee Information (yourself)");
        productInformation = new JButton("Product Information");
        transactionInformation = new JButton("Transaction Information");
        salaryInformation = new JButton("Salary Information (yourself)");
        logout = new JButton("Logout");

        BoxOfButton();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        registerNewVIP.addActionListener(e -> {
            frame.setVisible(false);
            new register_VIP("employee");
        });
        makeOrder.addActionListener(e -> {
            frame.setVisible(false);
            new make_order("employee");
        });

        VIPInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            VIPOra vipOra = new VIPOra();
            new vip(vipOra.getVIPs(),"employee");
        });
        transactionInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            TransactionsOra transactionOra = new TransactionsOra();
            new transaction(transactionOra.getTransactions(),"employee");
        });
        productInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            ProductOra productOra = new ProductOra();
            new product(productOra.getProducts(),"employee");
        });
        employeeInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            new employee_identify_for_infor("employee");
        });
        salaryInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            new employee_identify_for_salary("employee");
        });
        logout.addActionListener(e -> {
            frame.setVisible(false);
            new login();
        });
    }
}