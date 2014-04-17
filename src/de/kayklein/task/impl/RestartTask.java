package de.kayklein.task.impl;

import java.util.TimerTask;

/**
 * Created by kayklein on 17.04.14.
 */
public class RestartTask extends TimerTask {

    public void run() {
        System.out.println("Restart server" );
    }

}