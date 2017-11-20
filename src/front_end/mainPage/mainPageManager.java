package front_end.mainPage;

import front_end.extra_window.transaction_for_manager;
import front_end.import_and_export.import_product;
import front_end.login;
import front_end.registration.register_employee;
import front_end.view_information.employee;
import front_end.view_information.manager;
import front_end.view_information.salary;
import oracleDBA.EmployeeOra;
import oracleDBA.ManagerOra;
import oracleDBA.SalaryOra;

import javax.swing.*;

public class mainPageManager {
    private static final int width = 450;
    private static final int height = 300;

    private JFrame frame;
    private JPanel panel;
    // TODO: ??
    private JButton registerNewEmployee;
    private JButton addProduct;
    private JButton employeeInformation;
    private JButton salaryInformation;
    private JButton managerInformation;
    private JButton trackInformation;
    private JButton transactionView;
    private JButton logout;

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
        box.add(managerInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(employeeInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(salaryInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(trackInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(transactionView);
        box.add(Box.createVerticalStrut(10));
        box.add(logout);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerNewEmployee = new JButton("Register Employee");
        addProduct = new JButton("Add Product");
        employeeInformation = new JButton("Employee Information");
        salaryInformation = new JButton("Salary Information");
        managerInformation = new JButton("Manager Information");
        trackInformation = new JButton("Table <Product> and <Supplier> Information");
        transactionView = new JButton("View Transactions");
        logout = new JButton("Logout");

        BoxOfButton();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        registerNewEmployee.addActionListener(e -> {
            frame.setVisible(false);
            new register_employee("manager");
        });

        addProduct.addActionListener(e -> {
            frame.setVisible(false);
            new import_product("manager");
        });
        managerInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            ManagerOra managerOra = new ManagerOra();
            new manager(managerOra.getManagers(),"manager");
        });
        employeeInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            EmployeeOra employeeOra = new EmployeeOra();
            new employee(employeeOra.getEmployees(),"manager");
        });
        salaryInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            SalaryOra salaryOra = new SalaryOra();
            new salary(salaryOra.getSalaries(),"manager");
        });
        trackInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            new front_end.mainPage.track_for_manager();
        });
        transactionView.addActionListener(e -> {
            frame.setVisible(false);
            new transaction_for_manager("manager");
        });
        logout.addActionListener(e -> {
            frame.setVisible(false);
            new login();
        });
    }
}