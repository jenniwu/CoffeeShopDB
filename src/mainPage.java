import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/16/2017.
 */
public class mainPage {
    private static final int width = 450;
    private static final int height = 350;

    private JFrame frame;
    private JPanel panel;
    private JButton registerNewEmployee;
    private JButton registerNewVIP;
    private JButton makeOrder;
    private JButton VIPInformation;
    private JButton employeeInformation;
    private JButton productInformation;
    private JButton supplierInformation;
    private JButton transcationInformation;

    //private JCheckBox compassButton;
    //private JCheckBox ubcLibraryButton;

    public mainPage()
    {
        gui();
    }

    public void BoxOfButtom(){
        Box box = Box.createVerticalBox();
        box.add(registerNewEmployee);
        box.add(Box.createVerticalStrut(10));
        box.add(registerNewVIP);
        box.add(Box.createVerticalStrut(10));
        box.add(makeOrder);
        box.add(Box.createVerticalStrut(10));
        box.add(VIPInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(employeeInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(productInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(supplierInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(transcationInformation);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panel = new JPanel();

        registerNewEmployee = new JButton("register employee");
        registerNewVIP = new JButton("register VIP");
        makeOrder = new JButton("make order");
        VIPInformation=new JButton("vip information");
        employeeInformation =new JButton("Employee Information");
        productInformation=new JButton("Product Information");
        supplierInformation=new JButton("Supplier Information");
        transcationInformation=new JButton("Transcation Information");

        BoxOfButtom();

        frame.add(panel);
        frame.setVisible(true);

        registerNewEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new register_employee();
            }
        });

        registerNewVIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new register_VIP();
            }
        });
        makeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new makeOrder();
            }
        });

        VIPInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new transaction_information(list);
            }
        });
        employeeInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new transaction_information(list);
            }
        });
        productInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new product_information(list);
            }
        });
        supplierInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new supplier_information(list);
            }
        });
        transcationInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new transaction_information(list);
            }
        });

    }
}