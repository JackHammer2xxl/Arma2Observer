package de.kayklein.classes;


import java.util.Arrays;
import java.util.List;

/**
 * Created by kayklein on 17.04.14.
 */
public class TimingsParser {


    public boolean isValid(String strTimings) {
        boolean isValid = false;
        if (strTimings != null) {
            List<String> times = Arrays.asList(strTimings.split(";"));
            for (String strTime : times) {
                String[] time = strTime.split(":");
                if(time.length > 1) {
                    String hour = time[0];
                    String minute = time[1];
                    boolean isValidHour = hour.matches("[1-9]|1[0-2]");
                    boolean isValidMinute = minute.matches("[0-5]\\d");
                    if(isValidHour && isValidMinute){
                        isValid = true;
                        continue;
                    }
                }
                isValid = false;

            }
        }
        return isValid;
    }

}
