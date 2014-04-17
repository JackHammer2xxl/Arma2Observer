package de.kayklein.log;


import java.util.Date;

/**
 * Created by kayklein on 17.04.14.
 */
public class Log {


    private static ILogAppender appender;


    public static void i(String clazz, String log) {
        if(appender != null)
            appender.append(log );
    }

    public static void date(){
        appender.logDate();
    }

    public static void setAppender(ILogAppender appender) {
        Log.appender = appender;
    }
}
