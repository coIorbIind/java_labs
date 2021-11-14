package SwingApp.Controllers;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class myApp {
    public static final Map<String, Object> Frames = new HashMap<String, Object>();
    public static final Map<String, Object> Keys = new HashMap<String, Object>();

    public static final String PFrame = "PFrame";
    public static final String desktopPanePFrame = "desktopPanePFrame";
    public static final String PPrefix = PFrame + "/" + desktopPanePFrame;

    private static String StatusKey = PPrefix + "/FrameAppStatus/panel/scrollJTA/JTA";

    public static final boolean putStatus(String str){
        if (!str.isEmpty() && Frames.get(StatusKey) != null){
            JTextArea JTA = (JTextArea) Frames.get(StatusKey);
            JTA.setText(JTA.getText() + "\n" + str);
            return true;
        }
        return false;
    }

    //Прототип обработки запроса
    public static String getResponse(Map<String, Object> request){
        return "";
    }
}
