package acceptance;

import org.junit.Assert;
import org.junit.Test;


public class ServerAcceptance {

    @Test
    public void testQueryParams() throws Exception {
        String url = "http://localhost:8080";
//        String url = "http://default-environment-zvvmdifi8c.elasticbeanstalk.com/";
//        String url = "http://2015-11-08-10-31.elasticbeanstalk.com/";
        String mainPart = "/queryParams?turndown=forwhat&boilerup=hammerdown&key3=value3";
        String clientCall = new NetClientGet().getClientCall(url + mainPart);
        System.out.println(clientCall);
        Assert.assertTrue(clientCall.contains("turndown->forwhat"));
        Assert.assertTrue(clientCall.contains("boilerup->hammerdown"));
        Assert.assertTrue(clientCall.contains("key3->value3"));
    }

    @Test
    public void testPrimeNumberParams() throws Exception {
        String url = "http://localhost:8080";
//        String url = "http://default-environment-zvvmdifi8c.elasticbeanstalk.com/";
//        String url = "http://2015-11-08-10-31.elasticbeanstalk.com/";
        String mainPart = "/hello?byTime=3&byNth=11";
        String clientCall = new NetClientGet().getClientCall(url + mainPart);
        System.out.println(clientCall);

        Assert.assertTrue(clientCall.contains("11th Prime Number=31"));
        Assert.assertTrue(clientCall.contains("Largest Prime after 3 seconds="));
    }
}