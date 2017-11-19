package front_end;

import front_end.import_and_export.import_product;
import front_end.registration.register_employee;
import front_end.view_information.*;
import oracleDBA.*;

import javax.swing.*;

public class mainPageManager {
    private static final int width = 450;
    private static final int height = 650;

    private JFrame frame;
    private JPanel panel;
    // TODO: ??
    private JButton registerNewEmployee;
    private JButton addProduct;
    private JButton employeeInformation;
    private JButton productInformation;
    private JButton supplierInformation;
    private JButton salaryInformation;
    private JButton managerInformation;
    private JButton makesInformation;
    // TODO: enable to see VIP himself/herslf vip information, we require a new window to type in phone(PK).
    private JButton uponInformation;
    private JButton trackInformation;

    public mainPageManager()
    {
        gui();
    }

    public void BoxOfButton(){
        Box box = Box.createVerticalBox();
        box.add(registerNewEmployee);
        box.add(Box.createVerticalStrut(10));
        box.add(addProduct);
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

        registerNewEmployee = new JButton("Register Employee");
        addProduct = new JButton("Add Product");
        employeeInformation = new JButton("Employee Information");
        productInformation = new JButton("Product Information");
        supplierInformation = new JButton("Supplier Information");
        salaryInformation = new JButton("Salary Information");
        managerInformation = new JButton("Manager Information");
        makesInformation = new JButton("Table <Makes> ???");
        uponInformation = new JButton("Table <Upon> ???");
        trackInformation = new JButton("Table <Track> ???");


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

        addProduct.addActionListener(e -> {
            frame.setVisible(false);
            new import_product();
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
            // TODO: only view salary information
            uponOra up = new uponOra();
            new upon(up.getUpons());
        });
        trackInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            trackOra t = new trackOra();
            new track(t.getTracks());
        });
    }
}