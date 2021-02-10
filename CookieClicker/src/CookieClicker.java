import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class CookieClicker {

    private static JFrame frame = new JFrame("Cookie Clicker");
    private JPanel cookiePanel = new JPanel();
    private JTextField name = new JTextField("Name", 25);
    private JLabel upgradesTitle = new JLabel("UPGRADES:");
    private JLabel statsTitle = new JLabel("    STATS:");
    private JButton cursorUpgrade = new JButton("Cu");
    private JButton farmUpgrade = new JButton("Fa");
    private JButton mineUpgrade = new JButton("Mi");
    private JButton bankUpgrade = new JButton("Ba");
    private JButton templeUpgrade = new JButton("Te");
    private JButton wizardTowerUpgrade = new JButton("WT");
    private JLabel buildingsHeading = new JLabel("                         STORE:");
    private JButton buyCursor = new JButton("Cursor - 10");
    private JButton buyFarm = new JButton("Farm - 100");
    private JButton buyMine = new JButton("Mine - 500");
    private JButton buyBank = new JButton("Bank - 1000");
    private JButton buyTemple = new JButton("Temple - 5000");
    private JButton buyWizardTower = new JButton("Wizard Tower - 10000");
    private JLabel totalBuildings = new JLabel("| Total Buildings: 0");
    private JLabel numCursors = new JLabel("| Cursors: 0");
    private JLabel numFarms = new JLabel("| Farms: 0");
    private JLabel numMines = new JLabel("| Mines: 0");
    private JLabel numBanks = new JLabel("| Banks: 0");
    private JLabel numTemples = new JLabel("| Temples: 0");
    private JLabel numTowers = new JLabel("| Wizard Towers: 0");
    private JLabel cookiesPerSecond = new JLabel("| Cookies per second: 0");
    private JLabel cookieDisplay = new JLabel("0");
    private JLabel cookieCaption = new JLabel("cookies");

    private JLabel spacer = new JLabel("                    ");
    private JLabel line1 = new JLabel("______________");
    private JLabel line2 = new JLabel("______________");
    private JLabel line3 = new JLabel("______________");
    private JLabel line4 = new JLabel("______________");
    private JLabel line5 = new JLabel("______________");
    private JLabel line6 = new JLabel("______________");
    private JLabel line7 = new JLabel("______________");

    private ImageIcon icon = new ImageIcon(getClass().getResource("cookietransparent.png"));
    private JButton cookie = new JButton(icon);

    private long numCookies = 0;
    private int cursorCount = 0;
    private int farmCount = 0;
    private int mineCount = 0;
    private int bankCount = 0;
    private int templeCount = 0;
    private int towerCount = 0;

    private int cursorProduction = 1;
    private int farmProduction = 25;
    private int mineProduction = 100;
    private int bankProduction = 250;
    private int templeProduction = 1000;
    private int towerProduction = 5000;


    public CookieClicker() {
        cookie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCookies += cursorProduction;
                cookieDisplay.setText(numCookies + "");
            }
        });
        cursorUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 100) {
                    numCookies -= 100;
                    cookieDisplay.setText(numCookies + "");
                    cursorProduction = (int) Math.ceil(cursorProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor upgrade. You need " + (100 - numCookies) + " more cookies.");
                }
            }
        });
        farmUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 500) {
                    numCookies -= 500;
                    cookieDisplay.setText(numCookies + "");
                    farmProduction = (int) Math.ceil(farmProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a farm upgrade. You need " + (500 - numCookies) + " more cookies.");
                }
            }
        });
        mineUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 750) {
                    numCookies -= 750;
                    cookieDisplay.setText(numCookies + "");
                    mineProduction = (int) Math.ceil(mineProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor upgrade. You need " + (750 - numCookies) + " more cookies.");
                }
            }
        });
        bankUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 1200) {
                    numCookies -= 1200;
                    cookieDisplay.setText(numCookies + "");
                    bankProduction = (int) Math.ceil(bankProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor upgrade. You need " + (1200 - numCookies) + " more cookies.");
                }
            }
        });
        templeUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 1500) {
                    numCookies -= 1500;
                    cookieDisplay.setText(numCookies + "");
                    templeProduction = (int) Math.ceil(templeProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor upgrade. You need " + (1500 - numCookies) + " more cookies.");
                }
            }
        });
        wizardTowerUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 2500) {
                    numCookies -= 2500;
                    cookieDisplay.setText(numCookies + "");
                    towerProduction = (int) Math.ceil(towerProduction * 1.1);
                    cookieDisplay.setText(numCookies + "");
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor upgrade. You need " + (2500 - numCookies) + " more cookies.");
                }
            }
        });
        buyCursor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 10) {
                    numCookies -= 10;
                    cookieDisplay.setText(numCookies + "");
                    cursorCount++;
                    numCursors.setText("| Cursors: " + cursorCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a cursor. You need " + (10 - numCookies) + " more cookies.");
                }
            }
        });
        buyFarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 100) {
                    numCookies -= 100;
                    cookieDisplay.setText(numCookies + "");
                    farmCount++;
                    numFarms.setText("| Farms: " + farmCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a farm. You need " + (100 - numCookies) + " more cookies.");
                }
            }
        });
        buyMine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 500) {
                    numCookies -= 500;
                    mineCount++;
                    cookieDisplay.setText(numCookies + "");
                    numMines.setText("| Mines: " + mineCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a mine. You need " + (500 - numCookies) + " more cookies.");
                }
            }
        });
        buyBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 1000) {
                    numCookies -= 1000;
                    bankCount++;
                    cookieDisplay.setText(numCookies + "");
                    numBanks.setText("| Banks: " + bankCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a bank. You need " + (1000 - numCookies) + " more cookies.");
                }
            }
        });
        buyTemple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 5000) {
                    numCookies -= 5000;
                    cookieDisplay.setText(numCookies + "");
                    templeCount++;
                    numTemples.setText("| Temples: " + templeCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a temple. You need " + (5000 - numCookies) + " more cookies.");
                }
            }
        });
        buyWizardTower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numCookies >= 10000) {
                    numCookies -= 10000;
                    towerCount++;
                    cookieDisplay.setText(numCookies + "");
                    numTowers.setText("| Wizard Towers: " + towerCount);
                    totalBuildings.setText("| Total buildings: " + calcBuildings());
                    cookiesPerSecond.setText("| Cookies per second: " + calcCPS());
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot afford a wizard tower. You need " + (10000 - numCookies) + " more cookies.");
                }
            }
        });

    }

    public static void main(String[] args) {
        CookieClicker cookieClicker = new CookieClicker();
        frame.setContentPane(cookieClicker.cookiePanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(975, 550));
        cookieClicker.initializeDisplay();
        frame.pack();
        frame.setVisible(true);
        cookieClicker.runCookieCycle();
    }

    private void runCookieCycle() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                numCookies += calcCPS();
                cookieDisplay.setText(numCookies + "");
            }
        };

        timer.schedule(task, 1000, 1000);
    }

    private int calcCPS() {
        int cps = cursorProduction * cursorCount;
        cps += farmProduction * farmCount;
        cps += bankProduction * bankCount;
        cps += mineProduction * mineCount;
        cps += templeProduction * templeCount;
        cps += towerProduction * towerCount;
        return cps;
    }

    private int calcBuildings() {
        return cursorCount + farmCount + mineCount + bankCount + templeCount + towerCount;
    }

    private void initializeDisplay() {
        cookie.setPreferredSize(new Dimension(413, 413));
        name.setBounds(5, 5, name.getWidth(), name.getHeight());
        cookiePanel.add(name);
        cookiePanel.add(spacer);
        cookiePanel.add(upgradesTitle);
        cookiePanel.add(cursorUpgrade);
        cookiePanel.add(farmUpgrade);
        cookiePanel.add(mineUpgrade);
        cookiePanel.add(bankUpgrade);
        cookiePanel.add(templeUpgrade);
        cookiePanel.add(wizardTowerUpgrade);
        cookiePanel.add(statsTitle);
        cookiePanel.add(totalBuildings);
        cookiePanel.add(cookiesPerSecond);
        cookiePanel.add(numCursors);
        cookiePanel.add(numFarms);
        cookiePanel.add(numMines);
        cookiePanel.add(numBanks);
        cookiePanel.add(numTemples);
        cookiePanel.add(numTowers);
        cookiePanel.add(buildingsHeading);
        cookiePanel.add(buyCursor);
        cookiePanel.add(buyFarm);
        cookiePanel.add(buyMine);
        cookiePanel.add(buyBank);
        cookiePanel.add(buyTemple);
        cookiePanel.add(buyWizardTower);
        cookiePanel.add(cookie);
        cookieDisplay.setSize(new Dimension(200, 50));
        cookiePanel.add(cookieDisplay);
        cookiePanel.add(cookieCaption);
    }

}
