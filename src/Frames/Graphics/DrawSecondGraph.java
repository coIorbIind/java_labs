package Frames.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;

public class DrawSecondGraph extends JComponent {
    private final ArrayList<Float> xData;
    private final ArrayList<Float> yData;
    private final Color defcolor = Color.BLACK;
    double leftX = 50;
    double topY = 50;
    double width = 400;
    double height = 300;

    public DrawSecondGraph(ArrayList<Float> xDataValue, ArrayList<Float> yDataValue) {
        this.xData = xDataValue;
        this.yData = yDataValue;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        float scaleXW = (float) ((Math.log10(Collections.max(xData))) / width);
        float scaleYH = (float) ((Collections.max(yData) - Collections.min(yData)) / height);

        Font EdX = new Font("Arial", Font.PLAIN, 10);
        g2.setFont(EdX);

        for (int i = 0; i < xData.size() - 1; i++) {
            double FirstX;
            double SecondX;

            if (xData.get(i) != 0)
                FirstX = Math.round(Math.log10(xData.get(i)) / scaleXW) + leftX;
            else
                FirstX = leftX;
            SecondX = Math.round(Math.log10(xData.get(i + 1)) / scaleXW + leftX);

            double FirstY = Math.round(height - yData.get(i) / scaleYH + topY);
            double SecondY = Math.round(height - yData.get(i + 1) / scaleYH + topY);


            //Рисуем засечки на осях
//            g2.draw(new Line2D.Double(FirstX, height + topY - 10, FirstX, height + topY + 10));
//            g2.draw(new Line2D.Double(leftX - 10, FirstY, leftX + 10, FirstY));
//
//            //Пишем значения
//            String messageX = xData.get(i).toString();
//            g2.drawString(messageX, (int) FirstX - 5, (int) ((int) height + topY + 20));
//            String messageY = yData.get(i).toString();
//            g2.drawString(messageY, (int) ((int) leftX - 35), (int) FirstY);

            //Устанавливаем цвет.
            //Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур
            g2.setColor(Color.RED);

            //Рисуем квадраты, обозначающие точки
            Rectangle2D rec = new Rectangle2D.Double(FirstX - 3, FirstY - 3, 6, 6);
            g2.draw(rec);
            g2.fill(rec);

            //Соединяем точки линиями
            g2.draw(new Line2D.Double(FirstX, FirstY, SecondX, SecondY));

            //Особо обрабатываем последнюю точку
            if (i == xData.size() - 2) {
                rec = new Rectangle2D.Double(SecondX - 3, SecondY - 3, 6, 6);
                g2.draw(rec);
                g2.fill(rec);
                //Возвращаем цвет к значению по умолчанию
                g2.setColor(defcolor);
                g2.draw(new Line2D.Double(SecondX, height + topY - 10, SecondX, height + topY + 10));
                g2.draw(new Line2D.Double(leftX - 10, SecondY, leftX + 10, SecondY));
//                messageX = xData.get(i + 1).toString();
//                messageY = yData.get(i + 1).toString();
//                g2.drawString(messageX, (int) SecondX - 5, (int) ((int) height + topY + 20));
//                g2.drawString(messageY, (int) ((int) leftX - 35), (int) SecondY);
            }

            //Возвращаем цвет к значению по умолчанию
            g2.setColor(defcolor);

        }
    }
}
