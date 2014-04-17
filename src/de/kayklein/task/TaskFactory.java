package de.kayklein.task;

import de.kayklein.log.Log;
import de.kayklein.task.impl.RestartTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

/**
 * Created by kayklein on 17.04.14.
 */
public class TaskFactory {

    private static List<Timer> taskQueue = new ArrayList<Timer>();

    public static void addTask(String hour, String minute) {
        addTask(Integer.parseInt(hour) , Integer.parseInt(minute));
    }

    public static void addTask(int hour, int minute) {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        // date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        date.set(Calendar.HOUR, hour);
        date.set(Calendar.MINUTE, minute);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        // Schedule to run every day at time
        timer.schedule(new RestartTask(), date.getTime(), 1000 * 60 * 60 * 24);
        Log.i("TaskFactory.addTask", String.format("Restart Server at %02d:%02d", hour, minute) );
        taskQueue.add(timer );
    }

    public static void cancelAll(){
        boolean containsTask = false;
        for(Timer timer : taskQueue){
            timer.cancel();
            containsTask = true;
        }
        taskQueue.clear();

        if(containsTask) {
            Log.i("TaskFactory.cancelAll" , String.format("Reset Timings") );
        }
    }

}
