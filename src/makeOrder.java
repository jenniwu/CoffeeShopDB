import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11/16/2017.
 */
public class makeOrder {
    private static final int width = 450;
    private static final int height = 350;

    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton button;
    private JLabel title;
    private JLabel labelCoffee;
    private JLabel labelCoffeeBean;
    private JLabel labelCoffeeMachine;
    private JTextField coffee;
    private JTextField coffeeBean;
    private JTextField coffeeMachine;

    private JLabel invalid;

    public makeOrder()
    {
        gui();
    }

    private void gui(){
        frame = new JFrame("Auto Chrome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMiddle = new JPanel(new GridLayout(3,2));
        panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Make Order           ");
        labelCoffee = new JLabel("Coffee:                ");
        labelCoffeeBean = new JLabel("Coffee Bean:      ");
        labelCoffeeMachine = new JLabel("Coffee Machine:");
        button = new JButton("Submit");
        coffee = new JTextField(5);
        coffeeBean = new JTextField(5);
        coffeeMachine = new JTextField(5);
        invalid = new JLabel();

        panelTop.add(title);
        panelMiddle.add(labelCoffee);
        panelMiddle.add(coffee);
        panelMiddle.add(labelCoffeeBean);
        panelMiddle.add(coffeeBean);
        panelMiddle.add(labelCoffeeMachine);
        panelMiddle.add(coffeeMachine);
        panelBottom.add(button);
        panelBottom.add(invalid);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelMiddle, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(button);

        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String COFFEE = coffee.getText();
                String COFFEE_BEAN = coffeeBean.getText();
                String COFFEE_MACHINE = coffeeMachine.getText();

                boolean flag = true;
                try {
                    Integer.parseInt(COFFEE);
                    Integer.parseInt(COFFEE_BEAN);
                    Integer.parseInt(COFFEE_MACHINE);
                }catch (NumberFormatException err){
                    flag = false;
                }
                if(flag) {
                    invalid.setText("Amount is invalid");
                    invalid.setForeground(Color.red);
                    return;
                }
                frame.setVisible(false);
                new mainPage();
            }

        });
    }
}
