package net.jasonfaas;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jasonfaas on 11/8/15.
 */
public class StopwatchTest {

    @Test
    public void testStartAndStopTimerWorksInLessThanOneHundredMsAndGreatherThan1Ms() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        stopwatch.stop();

        int actualTimelapse = stopwatch.getTimelapse();
        System.out.println("AB:" + actualTimelapse);
        Assert.assertTrue(actualTimelapse < 100);
        Assert.assertTrue(actualTimelapse >= 0);
    }

    @Test
    public void testStopwatchResolvesInLessThan2000MsAndGreatherThan1000MsWith1000MsSleep() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Thread.sleep(100);
        stopwatch.stop();

        int actualTimelapse = stopwatch.getTimelapse();
        System.out.println("CD:" + actualTimelapse);
        Assert.assertTrue(actualTimelapse > 99);
        Assert.assertTrue(actualTimelapse < 200);

        Thread.sleep(100);
        Assert.assertEquals(stopwatch.getTimelapse(), actualTimelapse);
    }

    @Test
    public void testContinuousTimelapse() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        int firstContinuousTimelapse = stopwatch.getContinuousTimelapse();
        Thread.sleep(100);
        int secondContinuousTimelapse = stopwatch.getContinuousTimelapse();

        Assert.assertTrue(firstContinuousTimelapse < secondContinuousTimelapse);
    }

}
