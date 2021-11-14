package SwingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrafData {
    /**
     * Класс содержит данные для построения графика
     */

    private String temp = "";
    private boolean Correct = false;
    private GrafDataTitle Title;
    /**
     * Описание графика
     */
    private Map <String, ArrayList> DataValues;
    /**
     * Данные графика
     */

    GrafData() {
        this.Title = null;
        this.DataValues = null;
        this.Correct = false;
    }

    /**
     * Создаем объект данных графика из описания и двух массивов
     * @param Title
     * @param X1
     * @param Y1
     * @param X2
     * @param Y2
     */
    GrafData(GrafDataTitle Title, ArrayList <Float> X1, ArrayList <Float> Y1, ArrayList <Float> X2, ArrayList <Float> Y2) {

        if( checkTitle(Title) && !X1.isEmpty() && !Y1.isEmpty() && X1.size() == Y1.size() && !X2.isEmpty() && !Y2.isEmpty() && X2.size() == Y2.size()) {
            this.Title = Title;
            this.DataValues = new HashMap <String, ArrayList>();
            DataValues.put("X1", X1);
            DataValues.put("Y1", Y1);
            DataValues.put("X2", X2);
            DataValues.put("Y2", Y2);
            makeTitleFromDataArray();
            this.Correct = true;
        }
    }


    //------------------ set ------------------

    /**
     * Проверяем переданное описание графика
     * @param Title
     * @return
     */
    private boolean checkTitle(GrafDataTitle Title) {
        boolean Result = true;
        if(Title.getName().equals("") || Title.getName()==null) {
            Result = false;
        }
        return Result;
    }


    //------------------ get ------------------

    /**
     * Возвращаем описание данных графика
     * @return
     */
    public GrafDataTitle getTitle() {
        return this.Title;
    }

    public ArrayList <Float> getGrafDataX_1() {
        return this.DataValues.get("X1");
    }

    public ArrayList <Float> getGrafDataY_1() {
        return this.DataValues.get("Y1");
    }

    public ArrayList <Float> getGrafDataX_2() {
        return this.DataValues.get("X2");
    }

    public ArrayList <Float> getGrafDataY_2() {
        return this.DataValues.get("Y2");
    }

    public Map <String, ArrayList> getValues() {
        return this.DataValues;
    }



    //------------------ status ------------------

    boolean isCorrect() {
        return this.Correct;
    }



    //------------------ private ------------------

    /**
     * Метод устанавливает максимальные и минимальные значения в title
     */
    private void makeTitleFromDataArray() {
        ArrayList <Float> X1 = this.DataValues.get("X1");
        ArrayList <Float> Y1 = this.DataValues.get("Y1");
        ArrayList <Float> X2 = this.DataValues.get("X2");
        ArrayList <Float> Y2 = this.DataValues.get("Y2");
        float min = X1.get(0);
        float max = X1.get(X1.size()-1);

        for(float temp : X1) {
            if( temp < min ) min = temp;
            if( temp > max ) max = temp;
        }

        for(float temp : X2) {
            if( temp < min ) min = temp;
            if( temp > max ) max = temp;
        }

        this.Title.setMaxX(max);
        this.Title.setMinX(min);

        min = Y1.get(0);
        max = Y1.get(Y1.size()-1);

        for(float temp : Y1) {
            if( temp < min ) min = temp;
            if( temp > max ) max = temp;
        }

        for(float temp : Y2) {
            if( temp < min ) min = temp;
            if( temp > max ) max = temp;
        }

        this.Title.setMaxY(max);
        this.Title.setMinY(min);
    }
}

