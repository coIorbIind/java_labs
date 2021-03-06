package Controllers;

import Classes.*;
import Models.Model;
import Views.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Controller {
    private static String USER = "";
    private static String PASSWORD = "";
    private static boolean ROOT = false;
    private static boolean DEBUG = false;
    private static boolean TEST = false;
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\config\\log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Controller.class.getName());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Reading config file
     * @throws IOException - errors while reading config file
     */
    public static void Start() throws IOException
    {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\config\\properties.ini")));
        USER = props.getProperty("USER");
        PASSWORD = props.getProperty("PASSWORD");
        ROOT = Boolean.parseBoolean(props.getProperty("ROOT"));
        DEBUG = Boolean.parseBoolean(props.getProperty("DEBUG"));
        TEST = Boolean.parseBoolean(props.getProperty("TEST"));
    }

    /**
     * Trying to enter account
     */
    public static void Enter() {
        String log_pass = View.inputStartData();
        while (!(USER+" "+PASSWORD).equals(log_pass)) {
            View.Out("В доступе отказано! Проверьте введенные данные");
            if (DEBUG)
                LOGGER.log(Level.WARNING, "Попытка входа в аккаунт " + USER);
            log_pass = View.inputStartData();
        }
    }

    /**
     * Main process
     */
    public static void Process(){
        Laundry laundry = new Laundry();
        try {
            Start();
            if (DEBUG)
                LOGGER.log(Level.INFO, "Starting program");
        }
        catch (IOException ex){
            View.Out("Не удалось загрузить файл конфигурации");
            if (DEBUG)
                LOGGER.log(Level.WARNING, "Не удалось загрузить файл конфигурации");
        }
        Enter();
        if (DEBUG)
            LOGGER.log(Level.INFO, "Выполнен вход в аккаунт " + USER);
        if (ROOT && TEST){
            View.Out("AUTO_TESTS");
        }
        else if (ROOT) {
            View.Out("Здравствуйте, Хозяин!");
        }
        else {
            View.Out("Добро пожаловать " + USER);
        }
        int n;
        do {
            View.UserMenu();
            n = View.Number();
            switch (n) {
                case 1 -> {
                    try {
                        laundry = Model.ReadFile();
                        String text = "Файл успешно загружен";
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.INFO, text);
                    }
                    catch (IOException ex){
                        String text = "Возникли ошибки при чтении файла";
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, text);
                    }
                }
                case 2 -> {
                    try {
                        boolean res = laundry.SaveFile("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\files\\laundry.txt");
                        if (res) {
                            View.Out("Файл успешно сохранен");
                            if (DEBUG)
                                LOGGER.log(Level.INFO, "Файл успешно сохранен");
                        } else {
                            String text = "Возникли ошибки при сохранении";
                            View.Out(text);
                            if (DEBUG)
                                LOGGER.log(Level.WARNING, text);
                        }
                    }
                    catch (IOException ex){
                        String text = "Возникли ошибки при сохранении";
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, text);
                    }
                }
                case 3 -> {
                    View.Out(laundry.toString());
                }
                case 4 -> {
                    WashingMachine new_machine = View.InputMachine();
                    boolean flag = laundry.getWashing_machines().contains(new_machine);
                    if (flag) {
                        View.Out("Машина с такими параметрами уже существует");
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, "Безуспешная попытка добавить стиральную машину");
                    }
                    else {
                        String text = "Машина успешно добавлена";
                        laundry.AddMachine(new_machine);
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.INFO, text);
                    }

                }
                case 5 -> {
                    View.Out("Введите параметры стриральной машины, которую нужно удалить");
                    WashingMachine temp = View.InputMachine();
                    boolean flag = false;
                    int index = - 1;
                    for (WashingMachine machine:
                            laundry.getWashing_machines()) {
                        if (machine.equals(temp)){
                            flag = true;
                            index = laundry.getWashing_machines().indexOf(machine);
                            break;
                        }
                    }
                    if (!flag) {
                        View.Out("Машины с такими параметрами нет в прачечной");
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, "Безуспешная попытка удалить стиральную машину");
                    }

                    else {
                        String text = "Машина успешно удалена";
                        laundry.DeleteMachine(index);
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.INFO, text);
                    }
                }
                case 6 -> {
                    ColoredLinen new_linen = View.InputLinen();
                    boolean flag = false;
                    for (WashingMachine machine:
                            laundry.getWashing_machines()) {
                        if (machine.getTemperature() == new_linen.getTemperature_of_washing() && machine.getColor() == new_linen.getColor()){
                            flag = true;
                            machine.addLinen(new_linen);
                            break;
                        }
                    }
                    if (!flag) {
                        View.Out("Машины с такими параметрами нет в прачечной");
                        View.Out("Сначала следует добавить машину для стирки подобного белья");
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, "Безуспешная попытка загрузить белье");
                    }
                    else {
                        String text = "Белье успешно загружено";
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.INFO, text);
                    }
                }
                case 7 -> {
                    try {
                        boolean res = laundry.SaveFile("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\files\\laundry.txt");
                        if (res) {
                            View.Out("Файл успешно сохранен");
                            if (DEBUG)
                                LOGGER.log(Level.INFO, "Файл успешно сохранен");
                        } else {
                            String text = "Возникли ошибки при сохранении";
                            View.Out(text);
                            if (DEBUG)
                                LOGGER.log(Level.WARNING, text);
                        }
                    }
                    catch (IOException ex){
                        String text = "Возникли ошибки при сохранении";
                        View.Out(text);
                        if (DEBUG)
                            LOGGER.log(Level.WARNING, text);
                    }
                    View.Out("До новых встреч!");
                    if (DEBUG)
                        LOGGER.log(Level.INFO, USER + " закончил работу");
                }
                default -> {
                    View.Out("Некорректное число! Попробуйте снова");
                    if (DEBUG)
                        LOGGER.log(Level.WARNING, "Попытка ввести некорректное значение");
                }
            }
        }while (n != 7);
    }
}

