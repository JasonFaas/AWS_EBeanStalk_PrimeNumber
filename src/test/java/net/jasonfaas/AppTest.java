package net.jasonfaas;


import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testPrimeNumbers() {
        assertEquals(2, new App().getPrimeNumber(1));
    }

    @Test
    public void get2ndPrimeNumberShouldReturn3() {
        assertEquals(3, new App().getPrimeNumber(2));
    }

    @Test
    public void get3rdPrimeNumberShouldReturn5() {
        assertEquals(5, new App().getPrimeNumber(3));
    }

    @Test
    public void testLargestPrimeWithin10Seconds() {
        DateTime beforeTime = new DateTime();
        int i = 1;
        for (; secondsElapsed(beforeTime) < 10; i++) {
            new App().getPrimeNumber(i);
        }
        System.out.println("PrimeGotten:"+new App().getPrimeNumber(i) +":"+i);
    }

    private int secondsElapsed(DateTime beforeTime) {
        return (int)new DateTime().minus(beforeTime.getMillis()).getMillis()/1000;
    }
}
