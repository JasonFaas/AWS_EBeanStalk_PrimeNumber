package net.jasonfaas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        PrimeNumbers primeNumbers = new PrimeNumbers();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.getWriter().println("<br>1st Prime Number=" + primeNumbers.getNthPrime(1));
        response.getWriter().println("<br>2nd Prime Number=" + primeNumbers.getNthPrime(2));
        response.getWriter().println("<br>10th Prime Number=" + primeNumbers.getNthPrime(10));

        int largeNumberToTest = 500;
        response.getWriter().println("<br>" + largeNumberToTest + "th Prime Number=" + primeNumbers.getNthPrime(largeNumberToTest));
        primeNumbers.clearPrimeNumberList();

        int secondsToTest = 5;
        int nthPrimeGottenTo = primeNumbers.getLargestPrime(secondsToTest);
        int primeNumberAfterSoManySeconds = primeNumbers.getNthPrime(nthPrimeGottenTo);
        response.getWriter().println("<br>Largest Prime after " + secondsToTest + " seconds=" + primeNumberAfterSoManySeconds);
        primeNumbers.clearPrimeNumberList();

        stopwatch.stop();
        response.getWriter().println("<br><br>Time Taken " + stopwatch.getTimelapse() + " ms");

    }
}
