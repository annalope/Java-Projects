package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Draw {
    private List<Circle> circles = new ArrayList<>();
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Lines> lines = new ArrayList<>();
    private List<Arcs> arcs = new ArrayList<>();
    private Random r = new Random();
    private JButton button1;
    private JCheckBox a1CheckBox;
    private JRadioButton a2RadioButton;
    private JTextField textField1;
    private JPanel buttonPanel;
    private JButton drawCircleButton;
    private JButton drawRectangleButton;
    private JButton drawLineButton;
    private JButton clearButton;
    private JButton drawArcButton;
    private static JFrame frame = new JFrame("Draw");
    private Graphics g = new Graphics() {
        @Override
        public Graphics create() {
            return null;
        }

        @Override
        public void translate(int x, int y) {

        }

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public void setColor(Color c) {

        }

        @Override
        public void setPaintMode() {

        }

        @Override
        public void setXORMode(Color c1) {

        }

        @Override
        public Font getFont() {
            return null;
        }

        @Override
        public void setFont(Font font) {

        }

        @Override
        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        @Override
        public java.awt.Rectangle getClipBounds() {
            return null;
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {

        }

        @Override
        public void setClip(int x, int y, int width, int height) {

        }

        @Override
        public Shape getClip() {
            return null;
        }

        @Override
        public void setClip(Shape clip) {

        }

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {

        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {

        }

        @Override
        public void fillRect(int x, int y, int width, int height) {

        }

        @Override
        public void clearRect(int x, int y, int width, int height) {

        }

        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        public void drawOval(int x, int y, int width, int height) {

        }

        public void fillOval(int x, int y, int width, int height) {

        }

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawString(String str, int x, int y) {

        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {

        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public void dispose() {

        }
    };

    public Draw() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "button clicked");
            }
        });
        a1CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "box clicked");
            }
        });


        drawCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circle();
            }
        });
        drawRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rectangle();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        drawLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                line();
            }
        });
        drawArcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arc();
            }
        });
    }

    private Color getAColor() {
        int color = r.nextInt(10);
        switch (color) {
            case (0):
                return Color.PINK;
            case (1):
                return Color.BLUE;
            case (2):
                return Color.GREEN;
            case (3):
                return Color.BLACK;
            case (4):
                return Color.CYAN;
            case (5):
                return Color.RED;
            case (6):
                return Color.WHITE;
            case (7):
                return Color.MAGENTA;
            case (8):
                return Color.ORANGE;
            default:
                return Color.YELLOW;
        }
    }

    private void clear() {
        rectangles.clear();
        circles.clear();
        lines.clear();
        arcs.clear();
        frame.repaint();
    }

    private void arc() {
        int x = r.nextInt(500);
        int y = r.nextInt(500);
        int radius = (r.nextInt(50) + 50);
        int startAngle = r.nextInt(360);
        int endAngle = r.nextInt(250);
        arcs.add(new Arcs(x, y, radius, startAngle, endAngle, getAColor()));
        frame.repaint();
    }

    private void line() {
        int x1 = r.nextInt(800);
        int x2 = r.nextInt(800);
        int y1 = r.nextInt(800);
        int y2 = r.nextInt(800);
        lines.add(new Lines(x1, y1, x2, y2, getAColor()));
        frame.repaint();
    }

    private void rectangle() {
        int x = r.nextInt(500);
        int y = r.nextInt(500);
        int height = r.nextInt(100);
        int width = r.nextInt(100);
        rectangles.add(new Rectangle(x, y, width, height, getAColor()));
        frame.repaint();
    }

    private void circle() {
        int x = r.nextInt(500);
        int y = r.nextInt(500);
        int radius = r.nextInt(200);
        circles.add(new Circle(x, y, radius, getAColor()));
        frame.repaint();
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        JPanel app = new JPanel();
        draw.canvas.setPreferredSize(new Dimension(800, 800));
        app.add(draw.canvas, 0);
        app.add(draw.buttonPanel, 1);
        frame.setContentPane(app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 1000);
    }

    private JPanel canvas = new JPanel() {
        public void paintComponent(Graphics g) {
            // painting the circles
            for (Circle circle : circles) {
                g.setColor(circle.getColor());
                g.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
            }
            for (Rectangle rectangle : rectangles) {
                g.setColor(rectangle.getColor());
                g.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
            }
            for (Lines lines : lines) {
                g.setColor(lines.getColor());
                g.drawLine(lines.getX1(), lines.getY1(), lines.getX2(), lines.getY2());
            }
            for (Arcs arcs : arcs) {
                g.setColor(arcs.getColor());
                g.fillArc(arcs.getX(), arcs.getY(), arcs.getRadius(), arcs.getRadius(), arcs.getStartAngle(), arcs.getEndAngle());
            }
        }
    };
}
