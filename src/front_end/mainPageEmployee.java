package front_end;

import front_end.import_and_export.make_order;
import front_end.registration.register_VIP;
import front_end.view_information.*;
import oracleDBA.*;

import javax.swing.*;

public class mainPageEmployee {
    private static final int width = 450;
    private static final int height = 650;

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

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerNewVIP = new JButton("Register VIP");
        makeOrder = new JButton("Make Order");
        VIPInformation = new JButton("VIP Information");
        employeeInformation = new JButton("Employee Information");
        productInformation = new JButton("Product Information");
        transactionInformation = new JButton("Transaction Information");
        salaryInformation = new JButton("Salary Information");

        BoxOfButton();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        registerNewVIP.addActionListener(e -> {
            frame.setVisible(false);
            new register_VIP();
        });
        makeOrder.addActionListener(e -> {
            frame.setVisible(false);
            new make_order();
        });

        VIPInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            VIPOra vipOra = new VIPOra();
            new vip(vipOra.getVIPs());
        });
        transactionInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            TransactionsOra transactionOra = new TransactionsOra();
            new transaction(transactionOra.getTransactions());
        });
        productInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            ProductOra productOra = new ProductOra();
            new product(productOra.getProducts());
        });
        employeeInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            EmployeeOra employeeOra = new EmployeeOra();
            new employee(employeeOra.getEmployees());
        });
        salaryInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            SalaryOra salaryOra = new SalaryOra();
            new salary(salaryOra.getSalaries());
        });
    }
}