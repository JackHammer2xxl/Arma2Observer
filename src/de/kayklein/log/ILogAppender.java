package de.kayklein.log;

/**
 * Created by kayklein on 17.04.14.
 */
public interface ILogAppender {

    public abstract void append(String message);

    public abstract void logDate();
}
