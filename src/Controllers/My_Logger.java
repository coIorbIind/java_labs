package Controllers;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class My_Logger {
    private static ArrayList<Exception> ErrList = new ArrayList<>();
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\config\\log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Controller.class.getName());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void addErr(Exception e){
        ErrList.add(e);
    }
}
