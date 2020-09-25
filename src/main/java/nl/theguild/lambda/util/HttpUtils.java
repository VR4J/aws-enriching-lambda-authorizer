package nl.theguild.lambda.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public static HttpURLConnection get(String endpoint) throws IOException {
        URL url = new URL(endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Execute HTTP Call
        connection.getResponseCode();

        return connection;
    }

    public static HttpURLConnection post(String endpoint, String message) throws IOException {
        URL url = new URL(endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        connection.setDoOutput(true);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(message);

        out.flush();
        out.close();

        // Execute HTTP Call
        connection.getResponseCode();

        return connection;
    }
}
