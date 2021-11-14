package SwingApp;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DrawFrame() {

        //Формируем заголовок-описание графика
        GrafDataTitle GTitle_A = new GrafDataTitle("Array list", "", 0, 0, 0, 0, "ед", "мс");
        GrafDataTitle GTitle_L = new GrafDataTitle("Linked List", "", 0, 0, 0, 0, "ед", "мс");
        //Формируем данные для построения графика
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

        ArrayList <Float> X_L = new ArrayList<Float>();
        X_L.add(0F);
        X_L.add(10F);
        X_L.add(100F);
        X_L.add(1000F);
        X_L.add(10000F);

        ArrayList <Float> Y_L = new ArrayList<Float>();
        Y_L.add(32.400F);
        Y_L.add(110.700F);
        Y_L.add(940.100F);
        Y_L.add(5026.300F);
        Y_L.add(45419.200F);

        DrawGraf DG_A = new DrawGraf(new GrafData(GTitle_A, X_A, Y_A, X_L, Y_L), true, false, new Color(255, 0, 0), new Color(0, 0, 255));
        add(DG_A);
        pack();
    }

}
