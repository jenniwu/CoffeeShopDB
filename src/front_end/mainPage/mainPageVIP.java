package front_end.mainPage;

import front_end.import_and_export.make_order;
import front_end.login;
import front_end.view_information.transaction;
import front_end.view_information.vip;
import oracleDBA.TransactionsOra;
import oracleDBA.VIPOra;

import javax.swing.*;

public class mainPageVIP {
    private static final int width = 450;
    private static final int height = 450;

    private JFrame frame;
    private JPanel panel;
    private JButton makeOrder;
    // TODO: enable to see VIP himself/herslf vip information, we require a new window to type in phone(PK).
    private JButton VIPInformation;
    // TODO: enable to see VIP himself/herslf vip information, we require a new window to type in phone(PK).
    private JButton transactionInformation;
    private JButton logout;

    public mainPageVIP()
    {
        gui();
    }

    public void BoxOfButton(){
        Box box = Box.createVerticalBox();
        box.add(makeOrder);
        box.add(Box.createVerticalStrut(10));
        box.add(VIPInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(transactionInformation);
        box.add(Box.createVerticalStrut(10));
        box.add(logout);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeOrder = new JButton("Make Order");
        VIPInformation = new JButton("VIP Information");
        transactionInformation = new JButton("Transaction Information");
        logout = new JButton("Logout");

        BoxOfButton();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        makeOrder.addActionListener(e -> {
            frame.setVisible(false);
            new make_order("vip");
        });
        VIPInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            VIPOra vipOra = new VIPOra();
            new vip(vipOra.getVIPs(),"vip");
        });
        transactionInformation.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view Salary information
            TransactionsOra transactionOra = new TransactionsOra();
            new transaction(transactionOra.getTransactions(),"vip");
        });
        logout.addActionListener(e -> {
            frame.setVisible(false);
            new login();
        });
    }
}