package Controllers;

import Classes.*;
import Models.Model;
import Views.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;


public class Controller {
    private static String USER = "";
    private static String PASSWORD = "";
    private static boolean ROOT = false;
    private static boolean DEBUG = false;
    private static boolean TEST = false;
    private static String LOG_CONFIG = "";
//    static Logger LOGGER;
//    static {
//        try(FileInputStream ins = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\config\\log.config")){
//            LogManager.getLogManager().readConfiguration(ins);
//            LOGGER = Logger.getLogger(Controller.class.getName());
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }

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
        LOG_CONFIG = props.getProperty("LOG_CONFIG");
    }

    /**
     * Trying to enter account
     */
    public static void Enter(myLogger my_logger) {
        String log_pass = View.inputStartData();
        while (!(USER+" "+PASSWORD).equals(log_pass)) {
            View.Out("В доступе отказано! Проверьте введенные данные");
            if (DEBUG)
//                LOGGER.log(Level.WARNING, "Попытка входа в аккаунт " + USER);
                my_logger.addLog(Level.WARNING, "Попытка входа в аккаунт " + USER);
            log_pass = View.inputStartData();
        }
    }

    /**
     * Main process
     */
    public static int Process() {
        Laundry laundry = new Laundry();
        try {
            Start();
        } catch (IOException ex) {
            View.Out("Не удалось загрузить файл конфигурации");
            return 0;
        }
        myLogger my_logger;
        try {
            my_logger = new myLogger(LOG_CONFIG);
        }
        catch (IOException e) {
            View.Out("Не удалось загрузить файл настроек логера");
            return 0;
        }
        Enter(my_logger);
        if (DEBUG)
            my_logger.addLog(Level.INFO, "Выполнен вход в аккаунт " + USER);
        if (ROOT && TEST) {
            View.Out("Testing ArrayList");
            my_logger.addLog(Level.INFO, "Testing ArrayList");
            for (int j = 0; j < 5; j++) {
                long allTime = 0;
                my_logger.addLog(Level.INFO, "Testing ArrayList " + Math.pow(10, j + 1));
//                long startTime = System.nanoTime();
                for (int i = 0; i < Math.pow(10, j + 1); i++) {
                    long currentStart = System.nanoTime();
                    laundry.GenerateElementToTheArrayList();
                    long currentEnd = System.nanoTime();
                    long oneTime = currentEnd - currentStart;
                    allTime += oneTime;
                    my_logger.addLog(Level.INFO, "add, ID = " + i + ", " + oneTime);
                }
//                long endTime = System.currentTimeMillis();
                String text = "Процесс заполнения ArrayList, состоящий из " + Math.pow(10, j + 1) + " занял " +
                        (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1);
                View.Out(text);
                my_logger.addLog(Level.INFO, text);

                allTime = 0;
//                startTime = System.currentTimeMillis();
                for (int i = 0; i < Math.pow(10, j + 1) / 10; i++) {
                    long currentStart = System.nanoTime();
                    laundry.RemoveElementFromTheArrayList(i);
                    long currentEnd = System.nanoTime();
                    long oneTime = currentEnd - currentStart;
                    allTime += oneTime;
                    my_logger.addLog(Level.INFO, "remove, ID = " + i + ", " + oneTime);
                }
//                endTime = System.currentTimeMillis();
                text = "Процесс удаления из ArrayList " + Math.pow(10, j + 1) / 10 + " элементов занял " +
                        (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1) / 10;
                View.Out(text);
                my_logger.addLog(Level.INFO, text);
            }

            View.Out("Testing LinkedList");
            my_logger.addLog(Level.INFO, "Testing LinkedList");
            for (int j = 0; j < 5; j++) {
                long allTime = 0;
                my_logger.addLog(Level.INFO, "Testing LinkedList " + Math.pow(10, j + 1));
//                long startTime = System.currentTimeMillis();
                for (int i = 0; i < Math.pow(10, j + 1); i++) {
                    long currentStart = System.nanoTime();
                    laundry.GenerateElementToTheLinkedList();
                    long currentEnd = System.nanoTime();
                    long oneTime = currentEnd - currentStart;
                    allTime += oneTime;
                    my_logger.addLog(Level.INFO, "add, ID = " + i + ", " + oneTime);
                }
//                long endTime = System.currentTimeMillis();
                String text = "Процесс заполнения LinkedList, состоящий из " + Math.pow(10, j + 1) + " занял " +
                        (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1);
                View.Out(text);
                my_logger.addLog(Level.INFO, text);

//                startTime = System.currentTimeMillis();
                for (int i = 0; i < Math.pow(10, j + 1) / 10; i++) {
                    long currentStart = System.nanoTime();
                    laundry.RemoveElementFromTheLinkedList(i);
                    long currentEnd = System.nanoTime();
                    long oneTime = currentEnd - currentStart;
                    allTime += oneTime;
                    my_logger.addLog(Level.INFO, "remove, ID = " + i + ", " + oneTime);
                }
//                endTime = System.currentTimeMillis();
                text = "Процесс удаления из LinkedList " + Math.pow(10, j + 1) / 10 + " элементов занял " +
                        (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1) / 10;
                View.Out(text);
                my_logger.addLog(Level.INFO, text);
            }
        } else if (ROOT) {
            View.Out("Здравствуйте, Хозяин!");
        } else {
            View.Out("Добро пожаловать " + USER);
        }
        if (!(ROOT && TEST)) {
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
                                my_logger.addLog(Level.INFO, text);
                        } catch (IOException ex) {
                            String text = "Возникли ошибки при чтении файла";
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addErr(new IOException(text));
                            return 0;
                        }
                    }
                    case 2 -> {
                        try {
                            boolean res = laundry.SaveFile("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\files\\laundry.txt");
                            if (res) {
                                View.Out("Файл успешно сохранен");
                                if (DEBUG)
                                    my_logger.addLog(Level.INFO, "Файл успешно сохранен");
                            } else {
                                String text = "Возникли ошибки при сохранении";
                                View.Out(text);
                                if (DEBUG)
                                    my_logger.addLog(Level.WARNING, text);
                            }
                        } catch (IOException ex) {
                            String text = "Возникли ошибки при сохранении";
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addErr(new IOException(text));
                        }
                    }
                    case 3 -> {
                        View.Out(laundry.toString());
                    }
                    case 4 -> {
                        WashingMachine new_machine = View.InputMachine();
                        boolean flag = laundry.getWashing_machines_array().contains(new_machine);
                        if (flag) {
                            View.Out("Машина с такими параметрами уже существует");
                            if (DEBUG)
                                my_logger.addLog(Level.WARNING, "Безуспешная попытка добавить стиральную машину");
                        } else {
                            String text = "Машина успешно добавлена";
                            laundry.AddMachine(new_machine);
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addLog(Level.INFO, text);
                        }

                    }
                    case 5 -> {
                        View.Out("Введите параметры стриральной машины, которую нужно удалить");
                        WashingMachine temp = View.InputMachine();
                        boolean flag = false;
                        int index = -1;
                        for (WashingMachine machine :
                                laundry.getWashing_machines_array()) {
                            if (machine.equals(temp)) {
                                flag = true;
                                index = laundry.getWashing_machines_array().indexOf(machine);
                                break;
                            }
                        }
                        if (!flag) {
                            View.Out("Машины с такими параметрами нет в прачечной");
                            if (DEBUG)
                                my_logger.addLog(Level.WARNING, "Безуспешная попытка удалить стиральную машину");
                        } else {
                            String text = "Машина успешно удалена";
                            laundry.DeleteMachine(index);
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addLog(Level.INFO, text);
                        }
                    }
                    case 6 -> {
                        ColoredLinen new_linen = View.InputLinen();
                        boolean flag = false;
                        for (WashingMachine machine :
                                laundry.getWashing_machines_array()) {
                            if (machine.getTemperature() == new_linen.getTemperature_of_washing() && machine.getColor() == new_linen.getColor()) {
                                flag = true;
                                machine.addLinen(new_linen);
                                break;
                            }
                        }
                        if (!flag) {
                            View.Out("Машины с такими параметрами нет в прачечной");
                            View.Out("Сначала следует добавить машину для стирки подобного белья");
                            if (DEBUG)
                                my_logger.addLog(Level.WARNING, "Безуспешная попытка загрузить белье");
                        } else {
                            String text = "Белье успешно загружено";
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addLog(Level.INFO, text);
                        }
                    }
                    case 7 -> {
                        try {
                            boolean res = laundry.SaveFile("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\files\\laundry.txt");
                            if (res) {
                                View.Out("Файл успешно сохранен");
                                if (DEBUG)
                                    my_logger.addLog(Level.INFO, "Файл успешно сохранен");
                            } else {
                                String text = "Возникли ошибки при сохранении";
                                View.Out(text);
                                if (DEBUG)
                                    my_logger.addLog(Level.WARNING, text);
                            }
                        } catch (IOException ex) {
                            String text = "Возникли ошибки при сохранении";
                            View.Out(text);
                            if (DEBUG)
                                my_logger.addErr(new IOException(text));
                        }
                        View.Out("До новых встреч!");
                        if (DEBUG)
                            my_logger.addLog(Level.INFO, USER + " закончил работу");
                    }
                    default -> {
                        View.Out("Некорректное число! Попробуйте снова");
                        if (DEBUG)
                            my_logger.addLog(Level.WARNING, "Попытка ввести некорректное значение");
                    }
                }
            } while (n != 7);
        }
        return 0;
    }
}

