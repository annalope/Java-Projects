import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BakeACake {

    private static JFrame frame = new JFrame("Bake a Cake");
    private JPanel cakePanel = new JPanel();

    private ImageIcon leftArrow = new ImageIcon(getClass().getResource("left arrow.png"));
    private ImageIcon rightArrow = new ImageIcon(getClass().getResource("right arrow.png"));
    private ImageIcon transparent = new ImageIcon(getClass().getResource("transparent.png"));
    private String[] plates = {"blue plate.png", "green plate.png", "orange plate.png", "purple plate.png", "red plate.png", "yellow plate.png"};
    private int plateNum = 0;
    private String[] frostings = {"blueberry frosting.png", "caramel frosting.png", "chocolate frosting.png", "lemon frosting.png", "raspberry frosting.png", "strawberry frosting.png", "vanilla frosting.png"};
    private int frostingNum = 0;

    private JButton leftFrosting = new JButton(leftArrow);
    private JLabel frostingLabel = new JLabel("frosting");
    private JButton rightFrosting = new JButton(rightArrow);

    private JLabel layer1Label = new JLabel("layer 1:");
    private JComboBox<String> layer1Flavors = new JComboBox<>();
    private JLabel layer2Label = new JLabel("layer 2:");
    private JComboBox<String> layer2Flavors = new JComboBox<>();
    private JLabel layer3Label = new JLabel("layer 3:");
    private JComboBox<String> layer3Flavors = new JComboBox<>();

    private JButton leftPlate = new JButton(leftArrow);
    private JLabel plateLabel = new JLabel("plate");
    private JButton rightPlate = new JButton(rightArrow);

    private JCheckBox topping1Check = new JCheckBox("topping 1");
    private JCheckBox topping2Check = new JCheckBox("topping 2");
    private JCheckBox topping3Check = new JCheckBox("topping 3");
    private JComboBox<String> topping1Choice = new JComboBox<>();
    private JComboBox<String> topping2Choice = new JComboBox<>();
    private JComboBox<String> topping3Choice = new JComboBox<>();

    private JLabel topping1First = new JLabel(new ImageIcon(getClass().getResource("m&ms.png")));
    private JLabel topping1Second = new JLabel();
    private JLabel topping2First = new JLabel(new ImageIcon(getClass().getResource("lemon slices.png")));
    private JLabel topping2Second = new JLabel();
    private JLabel topping3First = new JLabel();
    private JLabel topping3Second = new JLabel();

    private JLabel frosting = new JLabel(new ImageIcon(getClass().getResource(frostings[frostingNum])));

    private JLabel layer1 = new JLabel();
    private JLabel layer2 = new JLabel();
    private JLabel layer3 = new JLabel();

    private JLabel plate = new JLabel(new ImageIcon(getClass().getResource(plates[plateNum])));

    /**
     * To do:
     * new blueberries image, cherries higher
     * **/

    public BakeACake() {
        leftFrosting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frostingNum -= 1;
                if (frostingNum == -1) {
                    frostingNum = frostings.length - 1;
                }

                frosting.setIcon(new ImageIcon(getClass().getResource(frostings[frostingNum])));
            }
        });
        rightFrosting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frostingNum++;
                if (frostingNum == frostings.length) {
                    frostingNum = 0;
                }

                frosting.setIcon(new ImageIcon(getClass().getResource(frostings[frostingNum])));
            }
        });
        topping1Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping1Choice.setVisible(topping1Check.isSelected());
                if (topping1Check.isSelected()) {
                    topping1First.setIcon(new ImageIcon(getClass().getResource( topping1Choice.getSelectedItem() + ".png")));
                    topping1Second.setIcon(new ImageIcon(getClass().getResource( topping1Choice.getSelectedItem() + ".png")));
                } else {
                    topping1First.setIcon(transparent);
                    topping1Second.setIcon(transparent);
                }
            }
        });
        topping2Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping2Choice.setVisible(topping2Check.isSelected());
                if (topping2Check.isSelected()) {
                    topping2First.setIcon(new ImageIcon(getClass().getResource( topping2Choice.getSelectedItem() + ".png")));
                    topping2Second.setIcon(new ImageIcon(getClass().getResource( topping2Choice.getSelectedItem() + ".png")));
                } else {
                    topping2First.setIcon(transparent);
                    topping2Second.setIcon(transparent);
                }
            }
        });
        topping3Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping3Choice.setVisible(topping3Check.isSelected());
                if (topping3Check.isSelected()) {
                    topping3First.setIcon(new ImageIcon(getClass().getResource( topping3Choice.getSelectedItem() + ".png")));
                    topping3Second.setIcon(new ImageIcon(getClass().getResource( topping3Choice.getSelectedItem() + ".png")));
                } else {
                    topping3First.setIcon(transparent);
                    topping3Second.setIcon(transparent);
                }
            }
        });
        rightPlate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateNum++;
                if (plateNum == plates.length) {
                    plateNum = 0;
                }

                plate.setIcon(new ImageIcon(getClass().getResource(plates[plateNum])));
            }
        });
        leftPlate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateNum -= 1;
                if (plateNum == -1) {
                    plateNum = plates.length - 1;
                }

                plate.setIcon(new ImageIcon(getClass().getResource(plates[plateNum])));
            }
        });
        layer1Flavors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layer1.setIcon(new ImageIcon(getClass().getResource( layer1Flavors.getSelectedItem() + " batter.png")));
            }
        });
        layer2Flavors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layer2.setIcon(new ImageIcon(getClass().getResource( layer2Flavors.getSelectedItem() + " batter.png")));
            }
        });
        layer3Flavors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layer3.setIcon(new ImageIcon(getClass().getResource( layer3Flavors.getSelectedItem() + " batter.png")));
            }
        });
        topping1Choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping1First.setIcon(new ImageIcon(getClass().getResource( topping1Choice.getSelectedItem() + ".png")));
                topping1Second.setIcon(new ImageIcon(getClass().getResource( topping1Choice.getSelectedItem() + ".png")));

            }
        });
        topping2Choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping2First.setIcon(new ImageIcon(getClass().getResource( topping2Choice.getSelectedItem() + ".png")));
                topping2Second.setIcon(new ImageIcon(getClass().getResource( topping2Choice.getSelectedItem() + ".png")));

            }
        });
        topping3Choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping3First.setIcon(new ImageIcon(getClass().getResource( topping3Choice.getSelectedItem() + ".png")));
                topping3Second.setIcon(new ImageIcon(getClass().getResource( topping3Choice.getSelectedItem() + ".png")));

            }
        });
    }

    public static void main(String[] args) {
        BakeACake bakeACake = new BakeACake();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(513, 350));
        bakeACake.initializeDisplay();
        frame.setContentPane(bakeACake.cakePanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeDisplay() {
        cakePanel.setLayout(null);
        //frosting selection
        leftFrosting.setPreferredSize(new Dimension(30, 30));
        Dimension size = leftFrosting.getPreferredSize();
        leftFrosting.setBounds(80, 30, size.width, size.height);
        leftFrosting.setOpaque(false);
        leftFrosting.setContentAreaFilled(false);
        leftFrosting.setBorderPainted(false);
        cakePanel.add(leftFrosting);
        size = frostingLabel.getPreferredSize();
        frostingLabel.setBounds(115, 36, size.width, size.height);
        cakePanel.add(frostingLabel);
        rightFrosting.setPreferredSize(new Dimension(30, 30));
        size = rightFrosting.getPreferredSize();
        rightFrosting.setBounds(170, 30, size.width, size.height);
        rightFrosting.setOpaque(false);
        rightFrosting.setContentAreaFilled(false);
        rightFrosting.setBorderPainted(false);
        cakePanel.add(rightFrosting);
        //batter layer selection
        populateBatterFlavors();
        size = layer1Label.getPreferredSize();
        layer1Label.setBounds(30, 72, size.width, size.height);
        cakePanel.add(layer1Label);
        size = layer1Flavors.getPreferredSize();
        layer1Flavors.setBounds(80, 68, size.width, size.height);
        cakePanel.add(layer1Flavors);
        size = layer2Label.getPreferredSize();
        layer2Label.setBounds(30, 102, size.width, size.height);
        cakePanel.add(layer2Label);
        size = layer2Flavors.getPreferredSize();
        layer2Flavors.setBounds(80, 98, size.width, size.height);
        cakePanel.add(layer2Flavors);
        size = layer3Label.getPreferredSize();
        layer3Label.setBounds(30, 132, size.width, size.height);
        cakePanel.add(layer3Label);
        size = layer3Flavors.getPreferredSize();
        layer3Flavors.setBounds(80, 128, size.width, size.height);
        cakePanel.add(layer3Flavors);
        //set default batter
        layer1Flavors.setSelectedItem("chocolate");
        layer2Flavors.setSelectedItem("vanilla");
        layer3Flavors.setSelectedItem("strawberry");
        //plate selection
        leftPlate.setPreferredSize(new Dimension(30, 30));
        size = leftPlate.getPreferredSize();
        leftPlate.setBounds(80, 160, size.width, size.height);
        leftPlate.setOpaque(false);
        leftPlate.setContentAreaFilled(false);
        leftPlate.setBorderPainted(false);
        cakePanel.add(leftPlate);
        size = plateLabel.getPreferredSize();
        plateLabel.setBounds(123, 166, size.width, size.height);
        cakePanel.add(plateLabel);
        rightPlate.setPreferredSize(new Dimension(30, 30));
        size = rightPlate.getPreferredSize();
        rightPlate.setBounds(170, 160, size.width, size.height);
        rightPlate.setOpaque(false);
        rightPlate.setContentAreaFilled(false);
        rightPlate.setBorderPainted(false);
        cakePanel.add(rightPlate);
        //toppings choice
        populateToppings();
        size = topping1Check.getPreferredSize();
        topping1Check.setBounds(5, 220, size.width, size.height);
        cakePanel.add(topping1Check);
        size = topping1Choice.getPreferredSize();
        topping1Choice.setBounds(100, 220, size.width, size.height);
        cakePanel.add(topping1Choice);
        size = topping2Check.getPreferredSize();
        topping2Check.setBounds(255, 220, size.width, size.height);
        cakePanel.add(topping2Check);
        size = topping2Choice.getPreferredSize();
        topping2Choice.setBounds(350, 220, size.width, size.height);
        cakePanel.add(topping2Choice);
        size = topping3Check.getPreferredSize();
        topping3Check.setBounds(100, 260, size.width, size.height);
        cakePanel.add(topping3Check);
        size = topping3Choice.getPreferredSize();
        topping3Choice.setBounds(195, 260, size.width, size.height);
        cakePanel.add(topping3Choice);
        topping1Choice.setVisible(false);
        topping2Choice.setVisible(false);
        topping3Choice.setVisible(false);
        // topping layer
        size = topping1First.getPreferredSize();
        topping1First.setBounds(260, 0, size.width, size.height);
        cakePanel.add(topping1First);
        size = topping1Second.getPreferredSize();
        topping1Second.setBounds(355, 0, size.width, size.height);
        cakePanel.add(topping1Second);
        topping1Choice.setSelectedItem("m&ms");
        size = topping2First.getPreferredSize();
        topping2First.setBounds(292, 0, size.width, size.height);
        cakePanel.add(topping2First);
        size = topping2Second.getPreferredSize();
        topping2Second.setBounds(387, 0, size.width, size.height);
        cakePanel.add(topping2Second);
        topping2Choice.setSelectedItem("lemon slices");
        size = topping3First.getPreferredSize();
        topping3First.setBounds(325, 0, size.width, size.height);
        cakePanel.add(topping3First);
        size = topping3Second.getPreferredSize();
        topping3Second.setBounds(420, 0, size.width, size.height);
        cakePanel.add(topping3Second);
        topping3Choice.setSelectedItem("oreo cookies");
        topping1First.setIcon(transparent);
        topping1Second.setIcon(transparent);
        topping2First.setIcon(transparent);
        topping2Second.setIcon(transparent);
        topping3First.setIcon(transparent);
        topping3Second.setIcon(transparent);
        // frosting layer
        size = frosting.getPreferredSize();
        frosting.setBounds(283, 10, size.width, size.height);
        cakePanel.add(frosting);
        // batter layers
        size = layer1.getPreferredSize();
        layer1.setBounds(285, 25, size.width, size.height);
        cakePanel.add(layer1);
        size = layer2.getPreferredSize();
        layer2.setBounds(285, 56, size.width, size.height);
        cakePanel.add(layer2);
        size = layer3.getPreferredSize();
        layer3.setBounds(285, 87, size.width, size.height);
        cakePanel.add(layer3);
        // plate layer
        size = plate.getPreferredSize();
        plate.setBounds(270, 108, size.width, size.height);
        cakePanel.add(plate);

        JLabel lightBackground = new JLabel(new ImageIcon(getClass().getResource("light background.png")));
        size = lightBackground.getPreferredSize();
        lightBackground.setPreferredSize(new Dimension(size.width, 200));
        size = lightBackground.getPreferredSize();
        lightBackground.setBounds(265, 0, size.width, size.height);
        cakePanel.add(lightBackground);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("background.png")));
        size = background.getPreferredSize();
        background.setBounds(0, 0, size.width, size.height);
        cakePanel.add(background);
    }

    private void populateBatterFlavors() {
        String[] flavors = {"chocolate", "vanilla", "strawberry", "lemon", "mint chocolate chip", "blueberry", "rocky road", "cookies and cream"};
        for (String fla : flavors) {
            layer1Flavors.addItem(fla);
            layer2Flavors.addItem(fla);
            layer3Flavors.addItem(fla);
        }

    }

    private void populateToppings() {
        String[] toppings = {"strawberries", "chocolate chips", "blueberries", "raspberries", "lemon slices", "oreo cookies", "m&ms", "gummy bears", "cherries", "pretzel"};
        for (String top : toppings) {
            topping1Choice.addItem(top);
            topping2Choice.addItem(top);
            topping3Choice.addItem(top);
        }
    }

}
