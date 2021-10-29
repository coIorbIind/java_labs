package Controllers;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class My_Logger {
    private static final ArrayList<Exception> ErrList = new ArrayList<>();
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\config\\log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Controller.class.getName());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void addErr(Exception e){
        ErrList.add(e);
        LOGGER.log(Level.WARNING, e.getMessage());
    }
    public static void addLog(Level level, String str){
        LOGGER.log(level, str);
    }

    public static int getErrCount(){
        return ErrList.size();
    }
}
