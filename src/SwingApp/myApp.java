package SwingApp;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.0.1
 * @author MIET. Andrianow A
 */
public class myApp
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new DrawFrame();
                frame.setTitle("DrawTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
