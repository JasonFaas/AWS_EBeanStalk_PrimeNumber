package net.jasonfaas;


import net.jasonfaas.utility.PrimeNumbers;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeNumbersTest {

    private PrimeNumbers classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new PrimeNumbers();
        classToTest.clearPrimeNumberList();
    }

    @Test
    public void testGet1stPrimeNumberIs2() {
        assertEquals(2, classToTest.getNthPrime(1));
    }

    @Test
    public void testGet2ndPrimeNumberIs3() {
        assertEquals(3, classToTest.getNthPrime(2));
    }

    @Test
    public void testGet3rdPrimeNumberIs5() {
        assertEquals(5, classToTest.getNthPrime(3));
    }

    @Test
    public void testLargestPrimeWithin10Seconds() {
        int secondsToWait = 10;

        int nthPrimeGottenTo = classToTest.getLargestPrime(secondsToWait);
        int nthPrime = classToTest.getNthPrime(nthPrimeGottenTo);

        System.out.println("PrimeGotten:" + nthPrime + ":" + nthPrimeGottenTo);
        Assert.assertTrue(nthPrimeGottenTo > 1000);
        Assert.assertTrue(nthPrimeGottenTo < 1000000);
    }

    private int secondsElapsed(DateTime beforeTime) {
        return (int)new DateTime().minus(beforeTime.getMillis()).getMillis()/1000;
    }

    @Test
    public void testClearPrimeNumbers() throws Exception {
        Assert.assertEquals(0, classToTest.getPrimeNumberList().size());

        assertEquals(5, classToTest.getNthPrime(3));
        Assert.assertEquals(3, classToTest.getPrimeNumberList().size());

        classToTest.clearPrimeNumberList();
        Assert.assertEquals(0, classToTest.getPrimeNumberList().size());
    }
}
