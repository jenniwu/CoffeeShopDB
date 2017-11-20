package front_end.mainPage;

import front_end.import_and_export.import_product;
import front_end.registration.register_employee;
import front_end.view_information.*;
import oracleDBA.*;

import javax.swing.*;

public class track_for_manager {
    private static final int width = 450;
    private static final int height = 300;

    private JFrame frame;
    private JPanel panel;

    private JButton track_product;
    private JButton track_supplier;

    public track_for_manager()
    {
        gui();
    }

    public void BoxOfButton(){
        Box box = Box.createVerticalBox();

        box.add(track_product);
        box.add(Box.createVerticalStrut(10));
        box.add(track_supplier);

        panel.add(box);
    }

    private void gui(){
        frame = new JFrame("Main");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        track_product = new JButton("View Product Information");
        track_supplier = new JButton("View Supplier Information");


        BoxOfButton();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        track_product.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            ProductOra productOra = new ProductOra();
            new product(productOra.getProducts(),"manager");
        });
        track_supplier.addActionListener(e -> {
            frame.setVisible(false);
            // TODO: only view salary information
            SupplierOra supplierOra = new SupplierOra();
            new supplier(supplierOra.getSuppliers(),"manager");
        });
    }
}