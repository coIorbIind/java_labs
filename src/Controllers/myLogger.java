package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class myLogger {
    private final ArrayList<Exception> ErrList = new ArrayList<>();
    Logger LOGGER;

    public myLogger(String path) throws IOException {
            FileInputStream ins = new FileInputStream(path);
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Controller.class.getName());
    }

    public void addErr(Exception e){
        ErrList.add(e);
        LOGGER.log(Level.WARNING, e.getMessage());
    }
    public void addLog(Level level, String str){
        LOGGER.log(level, str);
    }

    public int getErrCount(){
        return ErrList.size();
    }
}
