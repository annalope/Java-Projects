import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectricityBillCalculator {

    private static JFrame frame = new JFrame("Monthly Electricity Bill Calculator");
    private JPanel electricPanel = new JPanel();
    private JLabel currentMonthPrompt = new JLabel("Current Month:");
    private JComboBox<String> months = new JComboBox<>();
    private JLabel kwhUsedPrompt = new JLabel("Kilowatts Used This Month:");
    private JTextField kwhUsed = new JTextField(10);
    private JLabel units = new JLabel("kwh");
    private JButton calculate = new JButton("Calculate");
    private JLabel price = new JLabel("Price: ______");
    private JLabel disclaimer = new JLabel("* Based on prices quoted by Duke Energy.");

    public ElectricityBillCalculator() {
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double elecKWHUsed = Double.parseDouble(kwhUsed.getText());
                    if (elecKWHUsed >= 0) {
                        float bill = calculateBill(elecKWHUsed);
                        price.setText("Price: $" + round(bill));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please ensure the number you entered for kwh used is greater than 0.");
                    }
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(frame, "Please ensure that you have entered a number for the kwh used.");
                }
            }
        });
    }

    public static void main(String[] args) {
        ElectricityBillCalculator ebc = new ElectricityBillCalculator();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 270));
        frame.setResizable(false);
        ebc.initializeDisplay();
        frame.setContentPane(ebc.electricPanel);
        frame.pack();
        frame.setVisible(true);

    }

    private void initializeDisplay() {
        String[] monthOptions = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        electricPanel.setLayout(null);
        for (int i = 0; i < monthOptions.length; i++) {
            months.addItem(monthOptions[i]);
        }
        Dimension dim = currentMonthPrompt.getPreferredSize();
        currentMonthPrompt.setBounds(70, 19, dim.width, dim.height);
        electricPanel.add(currentMonthPrompt);
        dim = months.getPreferredSize();
        months.setBounds(192, 15, dim.width, dim.height);
        electricPanel.add(months);
        dim = kwhUsedPrompt.getPreferredSize();
        kwhUsedPrompt.setBounds(30, 69, dim.width, dim.height);
        electricPanel.add(kwhUsedPrompt);
        dim = kwhUsed.getPreferredSize();
        kwhUsed.setBounds(205, 65, dim.width, dim.height);
        electricPanel.add(kwhUsed);
        dim = units.getPreferredSize();
        units.setBounds(334, 69, dim.width, dim.height);
        electricPanel.add(units);
        dim = calculate.getPreferredSize();
        calculate.setBounds(150, 115, dim.width, dim.height);
        electricPanel.add(calculate);
        price.setPreferredSize(new Dimension(150, 15));
        dim = price.getPreferredSize();
        price.setBounds(150, 165, dim.width, dim.height);
        electricPanel.add(price);
        dim = disclaimer.getPreferredSize();
        disclaimer.setBounds(133, 227, dim.width, dim.height);
        electricPanel.add(disclaimer);
    }

    private float calculateBill(double usedKwh) {
        float rate;
        if (months.getSelectedIndex() >= 7 && months.getSelectedIndex() <= 10) {
            rate = (float) 0.10123;
        } else {
            rate = (float) 0.09650;
        }
        return 14 + (float) usedKwh * rate;
    }

    private float round(float num) {
        num = Math.round(num * 100);
        num = num / 100;
        return num;
    }

}
