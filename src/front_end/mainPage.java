package front_end;

import front_end.import_and_export.import_product;
import front_end.import_and_export.make_order;
import front_end.registration.register_VIP;
import front_end.registration.register_employee;
import front_end.view_information.*;
import oracleDBA.*;

import javax.swing.*;

/**
 * Created by user on 11/16/2017.
 */
public class mainPage {
    private static final int width = 450;
    private static final int height = 650;

    private JFrame frame;
    private JPanel panel;
    private JButton registerNewEmployee;
    private JButton registerNewVIP;
    private JButton makeOrder;
    private JButton addProduct;
    private JButton VIPInformation;
    private JButton employeeInformation;
    private JButton productInformation;
    private JButton supplierInformation;
    private JButton transactionInformation;
    private JButton salaryInformation;
    private JButton customerInformation;
    private JButton managerInformation;
    private JButton makesInformation;
    private JButton uponInformation;
    private JButton trackInformation;

    public mainPage()
    {
        gui();
    }

    public void BoxOfButton(){
        Box box = Box.createVerticalBox();
        box.add(registerNewEmployee);
        box.add(Box.createVerticalStrut(10));
        box.add(registerNewVIP);
        box.add(Box.createVerticalStrut(10));
        box.add(makeOrder);
        box.add(Box.createVerticalStrut(10));
        box.add(addProduct);
        box.add(Box.createVerticalStrut(10));
        box.add(customerInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(VIPInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(transactionInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(productInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(supplierInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(managerInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(employeeInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(salaryInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(makesInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(uponInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(trackInformation);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        GroupLayout layout = new GroupLayout(panel);
//        panel.setLayout(layout);

        registerNewEmployee = new JButton("Register Employee");
        registerNewVIP = new JButton("Register VIP");
        makeOrder = new JButton("Make Order");
        addProduct = new JButton("Add Product");
        VIPInformation = new JButton("VIP Information");
        employeeInformation = new JButton("Employee Information");
        productInformation = new JButton("Product Information");
        supplierInformation = new JButton("Supplier Information");
        transactionInformation = new JButton("Transaction Information");
        salaryInformation = new JButton("Salary Information");
        customerInformation = new JButton("Customer Information");
        managerInformation = new JButton("Manager Information");
        makesInformation = new JButton("Table <Makes> ???");
        uponInformation = new JButton("Table <Upon> ???");
        trackInformation = new JButton("Table <Track> ???");

//        GroupLayout.SequentialGroup leftToRight = layout.createSequentialGroup();
//
//        GroupLayout.ParallelGroup column1 = layout.createParallelGroup();
//        column1.addComponent(registerNewVIP);
//        column1.addComponent(registerNewEmployee);
//        leftToRight.addGroup(column1);
//        GroupLayout.ParallelGroup column2 = layout.createParallelGroup();
//        column2.addComponent(makeOrder);
//        column2.addComponent(addProduct);
//        leftToRight.addGroup(column2);
//        GroupLayout.ParallelGroup column3 = layout.createParallelGroup();
//        column3.addComponent(VIPInformation);
//        column3.addComponent(employeeInformation);
//        column3.addComponent(productInformation);
//        column3.addComponent(supplierInformation);
//        column3.addComponent(transactionInformation);
//        column3.addComponent(salaryInformation);
//        column3.addComponent(customerInformation);
//
//        GroupLayout.SequentialGroup topToBottom = layout.createSequentialGroup();
//
//        GroupLayout.ParallelGroup row1 = layout.createParallelGroup();
//        row1.addComponent(registerNewVIP);
//        row1.addComponent(makeOrder);
//        row1.addComponent(VIPInformation);
//        topToBottom.addGroup(row1);
//        GroupLayout.ParallelGroup row2 = layout.createParallelGroup();
//        row2.addComponent(registerNewEmployee);
//        row2.addComponent(addProduct);
//        row2.addComponent(employeeInformation);
//        topToBottom.addGroup(row2);
//        topToBottom.addComponent(productInformation);
//        topToBottom.addComponent(supplierInformation);
//        topToBottom.addComponent(transactionInformation);
//        topToBottom.addComponent(salaryInformation);
//        topToBottom.addComponent(customerInformation);
//
//        layout.setHorizontalGroup(leftToRight);
//        layout.setVerticalGroup(topToBottom);

        BoxOfButton();


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        registerNewEmployee.addActionListener(e -> {
            frame.setVisible(false);
            new register_employee();
        });

        registerNewVIP.addActionListener(e -> {
            frame.setVisible(false);
            new register_VIP();
        });
        makeOrder.addActionListener(e -> {
            frame.setVisible(false);
            new make_order();
        });
        addProduct.addActionListener(e -> {
            frame.setVisible(false);
            new import_product();
        });
        customerInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            CustomerOra customerOra = new CustomerOra();
            new customer(customerOra.getCustomer());
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
        supplierInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            SupplierOra supplierOra = new SupplierOra();
            new supplier(supplierOra.getSuppliers());
        });
        managerInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            ManagerOra managerOra = new ManagerOra();
            new manager(managerOra.getManagers());
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
        makesInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            makesOra make = new makesOra();
            new makes(make.getMakes());
        });
        uponInformation.addActionListener(e -> {
            frame.setVisible(false);
//            List<uponInfo> temp = new ArrayList<uponInfo>();
//            uponInfo a = new uponInfo(1,2);
//            temp.add(a);
//            new upon(temp);
            uponOra up = new uponOra();
            new upon(up.getUpons());
        });
        trackInformation.addActionListener(e -> {
            frame.setVisible(false);
            trackOra t = new trackOra();
            new track(t.getTracks());
        });
    }
}