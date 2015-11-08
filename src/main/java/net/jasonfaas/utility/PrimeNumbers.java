package net.jasonfaas.utility;

import net.jasonfaas.utility.Stopwatch;

import java.util.ArrayList;

public class PrimeNumbers
{

    private static ArrayList<Integer> primeNumberList = new ArrayList();

    public ArrayList<Integer> getPrimeNumberList() {
        return primeNumberList;
    }

    public int getNthPrime(int nthPrime) {

        if (primeNumberList.size() == 0) {
            primeNumberList.add(2);
        }

        for (int i = primeNumberList.get(primeNumberList.size() - 1) + 1; primeNumberList.size() < nthPrime; i++) {
            if (isValuePrime(i, primeNumberList)) {
                primeNumberList.add(i);
            }
        }

        return primeNumberList.get(nthPrime - 1);

    }

    private boolean isValuePrime(int value, ArrayList<Integer> primeNumberList) {
        for (Integer listValue:primeNumberList) {
            if (value % listValue == 0) {
                return false;
            }
        }
        return true;
    }

    public void clearPrimeNumberList() {
        primeNumberList = new ArrayList<>();
    }

    public int getLargestPrime(int secondsToWait) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        int nthPrimeGottenTo = 1;
        for (; stopwatch.getContinuousTimelapse() / 1000 < secondsToWait; nthPrimeGottenTo++) {
            getNthPrime(nthPrimeGottenTo);
        }
        return nthPrimeGottenTo;
    }
}
