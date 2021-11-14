package SwingApp.Lol;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class RightPanel extends JPanel{

    RightPanel(){

        ArrayList<Float> X_A = new ArrayList<Float>();
        X_A.add(0F);
        X_A.add(10F);
        X_A.add(100F);
        X_A.add(1000F);
        X_A.add(10000F);

        ArrayList <Float> Y_A = new ArrayList<Float>();
        Y_A.add(6.300F);
        Y_A.add(4.600F);
        Y_A.add(57.500F);
        Y_A.add(2111.200F);
        Y_A.add(98093.600F);

        ArrayList <Float> Y_L = new ArrayList<Float>();
        Y_L.add(58.400F);
        Y_L.add(117.200F);
        Y_L.add(1004.600F);
        Y_L.add(7063.500F);
        Y_L.add(270176.000F);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 40));

        JLabel topLabel = new JLabel();
        topLabel.setVerticalTextPosition(JLabel.CENTER);
        topLabel.setFont(new Font("Arial", Font.BOLD, 25));
        topLabel.setForeground(Color.BLACK);
        topLabel.setText("Remove");

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
        this.add(new DrawGraphics("ед", "мс", X_A, Y_A, Y_L));
    }
}
