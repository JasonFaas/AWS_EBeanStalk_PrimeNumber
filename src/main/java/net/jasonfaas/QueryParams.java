package net.jasonfaas;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QueryParams extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        Map<String, String[]> queryParameters = getQueryParameters(request);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Query Parameters</h1>");

        response.getWriter().println("<br>" + request.getQueryString());
        response.getWriter().println("<br>turndown->" + request.getParameter("turndown"));
        response.getWriter().println("<br>boilerup->" + request.getParameter("boilerup"));
        response.getWriter().println("<br>key3->" + request.getParameter("key3"));


        stopwatch.stop();
        response.getWriter().println("<br><br>Time Taken " + stopwatch.getTimelapse() + " ms");

    }

    public static Map<String, String[]> getQueryParameters(HttpServletRequest request) {
        Map<String, String[]> queryParameters = new HashMap<>();
        String queryString = request.getQueryString();

        if (StringUtils.isEmpty(queryString)) {
            return queryParameters;
        }

        String[] parameters = queryString.split("&");

        for (String parameter : parameters) {
            String[] keyValuePair = parameter.split("=");
            String[] values = queryParameters.get(keyValuePair[0]);
            values = ArrayUtils.add(values, keyValuePair.length == 1 ? "" : keyValuePair[1]); //length is one if no value is available.
            queryParameters.put(keyValuePair[0], values);
        }
        return queryParameters;
    }
}
