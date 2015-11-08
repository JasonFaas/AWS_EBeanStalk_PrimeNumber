package net.jasonfaas;

import org.joda.time.DateTime;

/**
 * Created by jasonfaas on 11/8/15.
 */
public class Stopwatch {
    private DateTime beforeTime = null;
    private DateTime afterTime = null;
    public void start() {
        beforeTime = new DateTime();
    }

    public void stop() {
        afterTime = new DateTime();
    }

    public int getTimelapse() {
        return (int)afterTime.minus(beforeTime.getMillis()).getMillis();
    }

    public int getContinuousTimelapse() {
        return (int)new DateTime().minus(beforeTime.getMillis()).getMillis();
    }
}
