package net.jasonfaas.servlet;

import net.jasonfaas.utility.PrimeNumbers;
import net.jasonfaas.utility.Stopwatch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();


        response.getWriter().println("<form name=\"loginForm\" method=\"post\" action=\"hello\">");


        PrimeNumbers primeNumbers = new PrimeNumbers();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.getWriter().println("<br>1st Prime Number=" + primeNumbers.getNthPrime(1));
        response.getWriter().println("<br>2nd Prime Number=" + primeNumbers.getNthPrime(2));

        int largeNumberToTest = 10;
        if (request.getParameter("byNth") != null) {
            largeNumberToTest = Integer.parseInt(request.getParameter("byNth"));
        }
        response.getWriter().println("<br>" + largeNumberToTest + "th Prime Number=" + primeNumbers.getNthPrime(largeNumberToTest));
        primeNumbers.clearPrimeNumberList();
        response.getWriter().println("<input type=\"text\" name=\"byNth\" value=\"" + largeNumberToTest + "\"/> ");

        int secondsToTest = 2;
        if (request.getParameter("byTime") != null) {
            secondsToTest = Integer.parseInt(request.getParameter("byTime"));
        }
        int nthPrimeGottenTo = primeNumbers.getLargestPrime(secondsToTest);
        int primeNumberAfterSoManySeconds = primeNumbers.getNthPrime(nthPrimeGottenTo);
        response.getWriter().println("<br>Largest Prime after " + secondsToTest + " seconds=" + primeNumberAfterSoManySeconds);
        primeNumbers.clearPrimeNumberList();
        response.getWriter().println("<input type=\"text\" name=\"byTime\" value=\"" + secondsToTest + "\"/> ");

        response.getWriter().println("<p><input type=\"submit\" value=\"Submit\">");
        response.getWriter().println("<p><button class=\"btn\" value=\"save\"  id=\"action\" onclick=\"submitForm(this)\"></button>");


        response.getWriter().println("</form>");

        stopwatch.stop();
        response.getWriter().println("<br><br>Time Taken " + stopwatch.getTimelapse() + " ms");

    }
}
