package Frames.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;

public class DrawGraphics extends JComponent {
    private final String xTitle;
    private final String yTitle;
    private final ArrayList<Float> xData;
    private final ArrayList<Float> yDataArray;
    private final ArrayList<Float> yDataLinked;
    private final Color defcolor = Color.BLACK;
    double leftX = 50;
    double topY = 50;
    double width = 400;
    double height = 300;

    public DrawGraphics(String xTitleValue, String yTitleValue, ArrayList<Float> xDataValue, ArrayList<Float> yDataValue, ArrayList<Float> yDataLinkedValue) {
        this.xData = xDataValue;
        this.yDataArray = yDataValue;
        this.xTitle = xTitleValue;
        this.yTitle = yTitleValue;
        this.yDataLinked = yDataLinkedValue;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        ArrayList<Float> allY = new ArrayList<Float>(yDataArray);
        allY.addAll(yDataLinked);
        float scaleXW = (float) ((Math.log10(Collections.max(xData))) / width);
        float scaleYH = (float) ((Collections.max(allY) - Collections.min(allY)) / height);


        //Рисуем рамку для графика
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        //Рисуем подпись графика
        g2.drawString(xTitle, (int) (leftX + width), (int) (topY + height + 30));
        g2.drawString(yTitle, (int) (leftX - 35), (int) (topY - 15));
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

            double FirstY1 = Math.round(height - yDataArray.get(i) / scaleYH + topY);
            double SecondY1 = Math.round(height - yDataArray.get(i + 1) / scaleYH + topY);
            double FirstY2 = Math.round(height - yDataLinked.get(i) / scaleYH + topY);
            double SecondY2 = Math.round(height - yDataLinked.get(i + 1) / scaleYH + topY);

            //Рисуем засечки на осях
            g2.draw(new Line2D.Double(FirstX, height + topY - 10, FirstX, height + topY + 10));
            g2.draw(new Line2D.Double(leftX - 10, FirstY1, leftX + 10, FirstY1));
            g2.draw(new Line2D.Double(leftX - 10, FirstY2, leftX + 10, FirstY2));

            //Пишем значения
            String messageX = xData.get(i).toString();
            g2.drawString(messageX, (int) FirstX - 5, (int) ((int) height + topY + 20));
            String messageY1 = yDataArray.get(i).toString();
            g2.drawString(messageY1, (int) ((int) leftX - 35), (int) FirstY1);
            String messageY2 = yDataLinked.get(i).toString();
            g2.drawString(messageY2, (int) ((int) leftX - 35), (int) FirstY2);

            //Устанавливаем цвет.
            //Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур
            g2.setColor(Color.BLUE);

            //Рисуем квадраты, обозначающие точки
            Rectangle2D rec = new Rectangle2D.Double(FirstX - 3, FirstY1 - 3, 6, 6);
            g2.draw(rec);
            g2.fill(rec);

            //Соединяем точки линиями
            g2.draw(new Line2D.Double(FirstX, FirstY1, SecondX, SecondY1));

            //Устанавливаем цвет.
            //Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур
            g2.setColor(Color.RED);

            //Рисуем квадраты, обозначающие точки
            Rectangle2D rec2 = new Rectangle2D.Double(FirstX - 3, FirstY2 - 3, 6, 6);
            g2.draw(rec2);
            g2.fill(rec2);

            //Соединяем точки линиями
            g2.draw(new Line2D.Double(FirstX, FirstY2, SecondX, SecondY2));

            //Особо обрабатываем последнюю точку
            if (i == xData.size() - 2) {
                g2.setColor(Color.BLUE);
                rec = new Rectangle2D.Double(SecondX - 3, SecondY1 - 3, 6, 6);
                g2.draw(rec);
                g2.fill(rec);
                g2.setColor(Color.RED);
                rec2 = new Rectangle2D.Double(SecondX - 3, SecondY2 - 3, 6, 6);
                g2.draw(rec2);
                g2.fill(rec2);
                //Возвращаем цвет к значению по умолчанию
                g2.setColor(defcolor);
                g2.draw(new Line2D.Double(SecondX, height + topY - 10, SecondX, height + topY + 10));
                g2.draw(new Line2D.Double(leftX - 10, SecondY1, leftX + 10, SecondY1));
                g2.draw(new Line2D.Double(leftX - 10, SecondY2, leftX + 10, SecondY2));
                messageX = xData.get(i + 1).toString();
                messageY1 = yDataArray.get(i + 1).toString();
                messageY2 = yDataLinked.get(i + 1).toString();
                g2.drawString(messageX, (int) SecondX - 5, (int) ((int) height + topY + 20));
                g2.drawString(messageY1, (int) ((int) leftX - 35), (int) SecondY1);
                g2.drawString(messageY2, (int) ((int) leftX - 35), (int) SecondY2);
            }

            //Возвращаем цвет к значению по умолчанию
            g2.setColor(defcolor);

        }
    }
}

