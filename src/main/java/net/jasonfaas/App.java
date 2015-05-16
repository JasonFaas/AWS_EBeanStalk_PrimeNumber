package net.jasonfaas;

import java.util.ArrayList;

public class App 
{

    private static ArrayList<Integer> primeNumberList = new ArrayList();

    public int getPrimeNumber(int nthPrime) {

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
}
