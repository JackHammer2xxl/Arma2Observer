package de.kayklein.task.impl;


import de.kayklein.classes.IProperties;

import java.text.SimpleDateFormat;

/**
 * Created by kayklein on 17.04.14.
 */
public class RestartTask extends AbsTask {

    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private final IProperties config;

    public RestartTask(IProperties _config) {
        config = _config;
    }

    public void run() {
        new StartTask().startProcess(config.getProperty("path") );  // TODO add command line args
    }

}