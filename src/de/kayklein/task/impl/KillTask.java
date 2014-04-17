package de.kayklein.task.impl;

import de.kayklein.log.Log;

import java.io.IOException;

/**
 * Created by kayklein on 18.04.14.
 */
public class KillTask extends AbsTask{

    public void killProcess(String executable){
        Log.i("KillTask.killProcess" , String.format("%s Stop Server" , time() ) );
        try {
            kill(executable);
        } catch (IOException e) {
            Log.date();
            Log.i("KillTask.killProcess" , String.format("Stop %s Failed" , executable ) );
        }
    }

    private void kill(String executable) throws IOException {
        Runtime rt = Runtime.getRuntime();
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
            rt.exec("taskkill " + executable);
        }else {
            rt.exec("pkill -9 " + executable);
        }
    }
}
