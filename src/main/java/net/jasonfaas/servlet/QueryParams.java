package net.jasonfaas.servlet;

import net.jasonfaas.utility.Stopwatch;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryParams extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Query Parameters</h1>");

        response.getWriter().println("<br>" + request.getQueryString());
        response.getWriter().println("<br>turndown->" + request.getParameter("turndown"));
        response.getWriter().println("<br>boilerup->" + request.getParameter("boilerup"));
        response.getWriter().println("<br>key3->" + request.getParameter("key3"));
        response.getWriter().println("<br>key3->" + request.getParameter("key3"));


        stopwatch.stop();
        response.getWriter().println("<br><br>Time Taken " + stopwatch.getTimelapse() + " ms");

    }

}
