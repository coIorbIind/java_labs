package Frames.Panels;

import Frames.Graphics.DrawGraphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class LeftPanel extends JPanel{



    public LeftPanel(){
        ArrayList <Float> X_A = new ArrayList<Float>();
        X_A.add(0F);
        X_A.add(10F);
        X_A.add(100F);
        X_A.add(1000F);
        X_A.add(10000F);

        ArrayList <Float> Y_A = new ArrayList<Float>();
        Y_A.add(1895.800F);
        Y_A.add(0360.800F);
        Y_A.add(2784.400F);
        Y_A.add(6124.400F);
        Y_A.add(34491.700F);

        ArrayList <Float> Y_L = new ArrayList<Float>();
        Y_L.add(32.400F);
        Y_L.add(110.700F);
        Y_L.add(940.100F);
        Y_L.add(5026.300F);
        Y_L.add(45419.200F);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 40));

        JLabel topLabel = new JLabel();
        topLabel.setVerticalTextPosition(JLabel.CENTER);
        topLabel.setFont(new Font("Arial", Font.BOLD, 25));
        topLabel.setForeground(Color.BLACK);
        topLabel.setText("Addition");

        Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
        topPanel.setBorder(border);
        topPanel.add(topLabel);

        JPanel lowPanel = new JPanel();
        lowPanel.setPreferredSize(new Dimension(500, 40));
        JLabel lowLabel = new JLabel();
        lowLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lowLabel.setForeground(Color.BLACK);
        lowLabel.setText("Array List's graphic is blue, Linked List's - red");
        lowPanel.add(lowLabel);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(lowPanel, BorderLayout.SOUTH);
        this.add(new DrawGraphics("ед", "мкс", X_A, Y_A, Y_L));
//        this.add(new Frames.Graphics.DrawSecondGraph(X_L, Y_L));
    }

//    public static class LowPanel extends JPanel{
//        LowPanel(){
//            super();
//            this.setPreferredSize(new Dimension(500, 40));
//            this.setBackground(Color.WHITE);
//            this.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
//        }
//
//        public void paint(Graphics g){
//            Graphics g2D = (Graphics) g;
//
//            g2D.setColor(Color.BLUE);
//            g2D.fillRect(10, 5, 10, 10);
//        }
//    }
}
