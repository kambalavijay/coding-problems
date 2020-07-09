package java8functional;

import io.netty.handler.codec.http.HttpResponseStatus;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class InterfaceTest {

    private static Logger logger = Logger.getLogger(String.valueOf(InterfaceTest.class));

    public static void main(String[] args) throws Exception {

        //ContentType c = new Con
        Base64.Encoder encoder = Base64.getUrlEncoder();
        // Encoding URL
        String url = "http://www.javatpoint.com/java-tutorial/";
        byte[] byteArray = url.getBytes("UTF-8");
        String eStr = encoder.encodeToString(byteArray);
        System.out.println("Encoded URL : "+eStr);
        // Getting decoder
        Base64.Decoder decoder = Base64.getUrlDecoder();
        // Decoding URl
        String dStr = new String(decoder.decode(eStr));
        System.out.println("Decoded URL : "+dStr);
    }

    public static String getFromHTTP(String url) throws Exception {
        final URL u = new URL(url);
        logger.info("Accessing URL " + url + " as URL: " + u);
        final long deadline = System.currentTimeMillis();
        while (System.currentTimeMillis() <= deadline) {
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setConnectTimeout(100000);
            connection.connect();
            if (Objects.equals(HttpResponseStatus.SERVICE_UNAVAILABLE, HttpResponseStatus.valueOf(connection.getResponseCode()))) {
                // service not available --> Sleep and retry
                logger.warning("Web service currently not available. Retrying the request in a bit.");
                Thread.sleep(100L);
            } else {
                InputStream is;
                if (connection.getResponseCode() >= 400) {
                    // error!
                    logger.warning("HTTP Response code when connecting to " + url + " was " + connection.getResponseCode());
                    is = connection.getErrorStream();
                } else {
                    is = connection.getInputStream();
                }
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) != -1) {
                    result.write(buffer, 0, length);
                }

                return result.toString(StandardCharsets.UTF_8.name());
            }
        }
        throw new TimeoutException("Could not get HTTP response in time since the service is still unavailable.");
    }

}