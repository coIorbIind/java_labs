package Views;

import Classes.Color;
import Classes.ColoredLinen;
import Classes.Temperature;
import Classes.WashingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    /**
     * Try to enter program
     * @return login + password
     */
    public static String inputStartData() {
        Scanner sn = new Scanner(System.in);
        Out("Введите логин");
        String login = sn.next();
        Out("Введите пароль");
        String password = sn.next();
        return login + " " + password;
    }

    /**
     *
     * @param str - string for output
     */
    public static void Out(String str) {
        System.out.println(str);
    }

    /**
     * Integer Input
     * @return integer number
     */
    public static int Number(){
        Scanner sn = new Scanner(System.in);
        String str;
        int n;
        while (true){
            str = sn.next();
            try {
                n = Integer.parseInt(str);
                break;
            }
            catch (NumberFormatException ex)
            {
                View.Out("Неккорректный ввод! Требуется целое число");
            }
        }
        return n;
    }

    /**
     * Menu for user
     */
    public static void UserMenu(){
        View.Out("Для чтения данных из файла нажмите .........1");
        View.Out("Для записи данных в файл нажмите ...........2");
        View.Out("Для вывода информации о прачечной нажмите ..3");
        View.Out("Для добавление стиральной машины нажмите ...4");
        View.Out("Для удаления стиральной машины нажмите .....5");
        View.Out("Для загрузки стирального белья нажмите .....6");
        View.Out("Для выхода нажмите .........................7");
    }

    /**
     * washing machine input
     * @return new washing machine
     */
    public static WashingMachine InputMachine(){
        Scanner sn = new Scanner(System.in);
        View.Out("Введите название порошка");
        String powder = sn.next();
        View.Out("Введите название кондиционера");
        String soft = sn.next();
        View.Out("Введите цвет белья");
        String temp;
        Temperature temperature;
        Color color;
        while (true){
            temp = sn.next();
            try{
                color = Color.valueOf(temp);
                break;
            }
            catch (IllegalArgumentException ex){
                View.Out("Можно использовать только один вариант из WHITE, BLACK, COLORS");
            }
        }
        View.Out("Введите температуру стирки");
        while (true){
            temp = sn.next();
            try{
            temperature = Temperature.valueOf(temp);
            break;
            }
            catch (IllegalArgumentException ex){
                View.Out("Можно использовать только один вариант из COLD, MIDDLE, HOT");
            }
        }
        return new WashingMachine(powder, soft, color, temperature, new ArrayList<ColoredLinen>());
    }

    /**
     * temperature input
     * @return temperature
     */
    public static Temperature InputTemp(){
        Scanner sn = new Scanner(System.in);
        String temp;
        Temperature temperature;
        View.Out("Введите температуру стирки");
        while (true){
            temp = sn.next();
            try{
                temperature = Temperature.valueOf(temp);
                break;
            }
            catch (IllegalArgumentException ex){
                View.Out("Можно использовать только один вариант из COLD, MIDDLE, HOT");
            }
        }
        return temperature;
    }

    /**
     * color input
     * @return color value
     */
    public static Color InputColor(){
        Scanner sn = new Scanner(System.in);
        View.Out("Введите цвет белья");
        String temp;
        Color color;
        while (true){
            temp = sn.next();
            try{
                color = Color.valueOf(temp);
                break;
            }
            catch (IllegalArgumentException ex){
                View.Out("Можно использовать только один вариант из WHITE, BLACK, COLORS");
            }
        }
        return color;
    }

    /**
     * input new linen
     * @return new colored linen for addition
     */
    public static ColoredLinen InputLinen(){
        Scanner sn = new Scanner(System.in);
        Temperature temp = InputTemp();
        int n;
        Out("Введите температуру глажки");
        while (true){
            n = Number();
            if (n > 0)
                break;
            else
                View.Out("Температура глажки должна быть больше 0");
        }
        Color color = InputColor();
        return new ColoredLinen(temp, n, color);
    }
}
