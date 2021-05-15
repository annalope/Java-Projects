import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterBillCalculator {

    private static JFrame frame = new JFrame("Monthly Water Bill Calculator");
    private JPanel waterPanel = new JPanel();
    private JLabel meterSizePrompt = new JLabel("Meter Size (inches):");
    private JComboBox<String> meterSize = new JComboBox<>();
    private JLabel galUsedPrompt = new JLabel("Gallons of Water Used:");
    private JTextField gallonsUsed = new JTextField(8);
    private JLabel units = new JLabel("gal");
    private JButton calculate = new JButton("Calculate");
    private JLabel price = new JLabel("Price: _________");
    private JLabel disclaimer = new JLabel("* Based on prices quoted by Duke Energy.");

    public WaterBillCalculator() {
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double waterGalUsed = Double.parseDouble(gallonsUsed.getText());
                    if (waterGalUsed >= 0) {
                        float bill = calculateWaterBill(waterGalUsed);
                        price.setText("Price: $" + round(bill));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please ensure the number you entered for gallons used is greater than 0.");
                    }
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(frame, "Please ensure that you have entered a number for the gallons used.");
                }
            }
        });
    }

    public static void main(String[] args) {
        WaterBillCalculator wbc =  new WaterBillCalculator();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(400, 270));
        wbc.initializeDisplay();
        frame.setContentPane(wbc.waterPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeDisplay() {
        String[] meterSizes = {"5/8", "3/4 Domestic & Fire Combo", "1", "1 Domestic & Fire Combo", "1 1/2", "2", "3", "4", "6", "8"};
        waterPanel.setLayout(null);
        for (int i = 0; i < meterSizes.length; i++) {
            meterSize.addItem(meterSizes[i]);
        }
        Dimension dim = meterSizePrompt.getPreferredSize();
        meterSizePrompt.setBounds(20, 19, dim.width, dim.height);
        waterPanel.add(meterSizePrompt);
        dim = meterSize.getPreferredSize();
        meterSize.setBounds(142, 15, dim.width, dim.height);
        waterPanel.add(meterSize);
        dim = galUsedPrompt.getPreferredSize();
        galUsedPrompt.setBounds(60, 69, dim.width, dim.height);
        waterPanel.add(galUsedPrompt);
        dim = gallonsUsed.getPreferredSize();
        gallonsUsed.setBounds(215, 65, dim.width, dim.height);
        waterPanel.add(gallonsUsed);
        dim = units.getPreferredSize();
        units.setBounds(324, 69, dim.width, dim.height);
        waterPanel.add(units);
        dim = calculate.getPreferredSize();
        calculate.setBounds(150, 115, dim.width, dim.height);
        waterPanel.add(calculate);
        price.setPreferredSize(new Dimension(150, 15));
        dim = price.getPreferredSize();
        price.setBounds(150, 165, dim.width, dim.height);
        waterPanel.add(price);
        dim = disclaimer.getPreferredSize();
        disclaimer.setBounds(133, 227, dim.width, dim.height);
        waterPanel.add(disclaimer);
    }

    private float calculateWaterBill(double waterGalUsed) {
        int sizeOfMeter = meterSize.getSelectedIndex();
        float waterServiceCharge = 0;
        float sewerServiceCharge = 0;
        float volCharge;
        float sewerVolCharge;

        switch (sizeOfMeter) {
            case (0):
                waterServiceCharge = (float) 15.78;
                sewerServiceCharge = (float) 12.85;
                break;
            case (1):
                waterServiceCharge = (float) 16.28;
                sewerServiceCharge = (float) 12.85;
                break;
            case (2):
                waterServiceCharge = (float) 31.63;
                sewerServiceCharge = (float) 22.07;
                break;
            case (3):
                waterServiceCharge = (float) 32.16;
                sewerServiceCharge = (float) 22.07;
                break;
            case (4):
                waterServiceCharge = (float) 68.39;
                sewerServiceCharge = (float) 38.05;
                break;
            case (5):
                waterServiceCharge = (float) 103.22;
                sewerServiceCharge = (float) 57.53;
                break;
            case (6):
                waterServiceCharge = (float) 212.29;
                sewerServiceCharge = (float) 108.79;
                break;
            case (7):
                waterServiceCharge = (float) 346.55;
                sewerServiceCharge = (float) 166.30;
                break;
            case (8):
                waterServiceCharge = (float) 754.69;
                sewerServiceCharge = (float) 304.91;
                break;
            case (9):
                waterServiceCharge = (float) 1073.21;
                sewerServiceCharge = (float) 520.31;
                break;
            default:
        }

        if (waterGalUsed < 3000) {
            volCharge = (float) 2.82;
        } else if (waterGalUsed < 6000) {
            volCharge = (float) 6.84;
        } else if (waterGalUsed < 11000) {
            volCharge = (float) 8.39;
        } else if (waterGalUsed < 16000) {
            volCharge = (float) 11.72;
        } else {
            volCharge = (float) 21.20;
        }

        if (waterGalUsed < 15000) {
            sewerVolCharge = (float) 6.94;
        } else {
            sewerVolCharge = (float) 0.0;
        }

        return (waterServiceCharge + sewerServiceCharge + volCharge + sewerVolCharge);
    }

    private float round(float num) {
        num = Math.round(num * 100);
        num = num / 100;
        return num;
    }

}