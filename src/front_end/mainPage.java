package front_end;

import front_end.import_and_export.import_product;
import front_end.import_and_export.make_order;
import front_end.registration.register_VIP;
import front_end.registration.register_employee;
import front_end.view_information.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("1");
            list1.add("A. Anna");
            list1.add("778-681-4862");
            List list2 = new ArrayList();
            list2.add("2");
            list2.add("B. Ben");
            list2.add("778-674-5692");
            list.add(list1);
            list.add(list2);
            new customer(list);
        });

        VIPInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("778-681-4862");
            list1.add("anna@gmail.com");
            list1.add("21");
            list1.add("1996-1-11");
            list1.add("100");
            list1.add("1234");
            List list2 = new ArrayList();
            list2.add("778-674-5692");
            list2.add("ben@gmail.com");
            list2.add("50");
            list2.add("1995-1-21");
            list2.add("10");
            list2.add("3077");
            list.add(list1);
            list.add(list2);
            new vip(list);
        });
        transactionInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("12345");
            list1.add("2017-11-15");
            list1.add("20:20:20");
            list1.add("1");
            list1.add("1234");
            List list2 = new ArrayList();
            list2.add("23456");
            list2.add("2017-11-02");
            list2.add("18:30:00");
            list2.add("2");
            list2.add("9504");
            list.add(list1);
            list.add(list2);
            new transaction(list);
        });
        productInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("123456");
            list1.add("20");
            list1.add("10");
            list1.add("NO");
            list1.add("coffee");
            List list2 = new ArrayList();
            list2.add("234567");
            list2.add("150");
            list2.add("10");
            list2.add("YES");
            list2.add("coffee bean");
            List list3 = new ArrayList();
            list3.add("345678");
            list3.add("5");
            list3.add("50");
            list3.add("YES");
            list3.add("coffee machine");
            list.add(list1);
            list.add(list2);
            list.add(list3);
            new product(list);
        });
        supplierInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("778-693-3079");
            list1.add("Swagger");
            List list2 = new ArrayList();
            list2.add("778-803-5783");
            list2.add("Malcom");
            list.add(list1);
            list.add(list2);
            new supplier(list);
        });
        managerInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("123");
            list1.add("Knorr");
            List list2 = new ArrayList();
            list2.add("206");
            list2.add("Mike");
            list.add(list1);
            list.add(list2);
            new manager(list);
        });
        employeeInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("1234");
            list1.add("A");
            list1.add("2");
            list1.add("stuff");
            list1.add("123");
            List list2 = new ArrayList();
            list2.add("2234");
            list2.add("B");
            list2.add("1");
            list2.add("super stuff");
            list2.add("123");
            list.add(list1);
            list.add(list2);
            new employee(list);
        });
        salaryInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("1");
            list1.add("monthly");
            list1.add("100");
            List list2 = new ArrayList();
            list2.add("2");
            list2.add("weekly");
            list2.add("50");
            list.add(list1);
            list.add(list2);
            new salary(list);
        });
        makesInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("10");
            List list2 = new ArrayList();
            list2.add("6");
            list.add(list1);
            list.add(list2);
            new makes(list);
        });
        uponInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("12345");
            list1.add("123456");
            List list2 = new ArrayList();
            list2.add("23456");
            list2.add("234567");
            list.add(list1);
            list.add(list2);
            new upon(list);
        });
        trackInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO:  mock object need to be replaced
            List list = new ArrayList();
            List list1 = new ArrayList();
            list1.add("123456");
            list1.add("778-893-3079");
            list1.add("123");
            List list2 = new ArrayList();
            list2.add("234567");
            list2.add("778-893-3079");
            list2.add("123");
            list.add(list1);
            list.add(list2);
            new track(list);
        });
    }
}