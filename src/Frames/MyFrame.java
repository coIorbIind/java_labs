package Frames;

import javax.swing.*;
import java.awt.*;

import Frames.Panels.LeftPanel;
import Frames.Panels.RightPanel;

public class MyFrame extends JFrame {

    LeftPanel leftPanel;

    public MyFrame(){
        this.setTitle("My Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(new GridLayout());
        this.setVisible(true);
        this.setResizable(false);

        this.add(new LeftPanel());
        this.add(new RightPanel());

        this.pack();
    }
}
