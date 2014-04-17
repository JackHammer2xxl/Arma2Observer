package de.kayklein.task.impl;

import de.kayklein.log.Log;

import java.io.IOException;

/**
 * Created by kayklein on 18.04.14.
 */
public class StartTask extends AbsTask {

    public void startProcess(String executable) {
        Log.i("StartTask.startProcess" , String.format("%s Start Server" , time() ) );
        try {
            start(executable);
        } catch (IOException e) {
            Log.date();
            Log.i("KillTask.killProcess", String.format("Stop %s Failed", executable));
        }
    }

    private void start(String executable) throws IOException {
        Runtime rt = Runtime.getRuntime();
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
            rt.exec(executable);
        } else {
            rt.exec("open " + executable);
        }
    }
}
