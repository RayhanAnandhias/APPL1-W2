package currencyconverter;
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RatePanel extends JPanel {
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    JComboBox currencyList;
    JTextField textbox;
    JLabel convert;
    JButton submit;
    JLabel middle;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel() {
        JLabel intro = new JLabel("Choose Currency Unit : ");
        JLabel title = new JLabel ("How much is that in dollars ?");
        middle = new JLabel("Enter Value to Convert : ");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        intro.setFont (new Font ("Helvetica", Font.BOLD, 20));
        middle.setFont(new Font("Helvetica", Font.BOLD, 20));
        
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        rate = new double [] {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};
        
        result = new JLabel (" ------------ ");
        result.setFont(new Font ("Helvetica", Font.PLAIN, 18));
        currencyList = new JComboBox(currencyName);
        currencyList.setPreferredSize(new Dimension(150,30));
        textbox = new JTextField("", 22);
        convert = new JLabel();
        convert.setFont(new Font("Helvetica", Font.PLAIN, 18));
        submit = new JButton("Submit");
        add(intro);
        add(currencyList);
        add(title);
        add(result);
        add(middle);
        add(textbox);
        add(submit);
        add(convert);
        currencyList.addActionListener(new ComboListener());
        submit.addActionListener(new ComboListener());
        middle.show(false);
        textbox.show(false);
        convert.show(false);
        submit.show(false);
        setBackground(Color.YELLOW);
    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            if(event.getSource().equals(currencyList)) {
                textbox.setText("");
                convert.setText("");
            }
            
            int index = currencyList.getSelectedIndex();
            if(index != 0) {
                
                result.setText ("1 " + currencyName[index] +
                    " = " + rate[index] + " U.S. Dollars");
                middle.show(true);
                textbox.show(true);
                submit.show(true);
                convert.show(true);
                
                if(event.getSource().equals(submit)) {
                    try {
                        double x = Double.parseDouble(textbox.getText());
                        convert.setText((x*rate[index]) + " " + "U.S. Dollars");
                    } catch (Exception e) {
                         convert.setText("Not a Number");
                    }
                } else {
                    //donoting
                }
                
            } else {
                result.setText(" ------------ ");
                middle.show(false);
                textbox.show(false);
                submit.show(false);
                convert.show(false);
            }
        }
    }
}    