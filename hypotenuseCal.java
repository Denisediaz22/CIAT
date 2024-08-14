import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hypotenuseCal extends JFrame {
    private JTextField sideAField;
    private JTextField sideBField;
    private JTextField hypotenuseField;
    private JButton calculateButton;

    public hypotenuseCal() {
        super("Hypotenuse Calculator");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Side A:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        sideAField = new JTextField(10);
        add(sideAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Side B:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        sideBField = new JTextField(10);
        add(sideBField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Hypotenuse:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        hypotenuseField = new JTextField(10);
        hypotenuseField.setEditable(false);
        add(hypotenuseField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton, gbc);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                double sideA = Double.parseDouble(sideAField.getText());
                double sideB = Double.parseDouble(sideBField.getText());
                double hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
                hypotenuseField.setText(String.format("%.2f", hypotenuse));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(hypotenuseCal.this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new hypotenuseCal();
            }
        });
    }
}
