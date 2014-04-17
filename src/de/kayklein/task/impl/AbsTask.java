package de.kayklein.task.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by kayklein on 18.04.14.
 */
public abstract class AbsTask extends TimerTask {


    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    protected String time(){
        return format.format(new Date());
    }

    @Override
    public void run() {/*Empty*/}
}
