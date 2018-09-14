import test.Property;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class Request {

    static URI buildURI(String query) throws URISyntaxException {
        return new URIBuilder(Property.readProperties().getProperty("testURL"))
            .addParameter("api_key", Property.readProperties().getProperty("apiKey"))
            .addParameter("query", query)
            .build();
    }

    static HttpURLConnection connect(URI myURL) throws IOException {
        return (HttpURLConnection) myURL.toURL().openConnection();
    }

    static JsonElement get(HttpURLConnection connection) throws IOException {
        JsonElement jsonElement = null;
        if (connection.getResponseCode() == 200) {
            connection.connect();
            jsonElement = new JsonParser().parse(new InputStreamReader((InputStream) connection.getContent()));
        } else {
            System.out.println("Response code = " + connection.getResponseCode());
        }
        return jsonElement;
    }
}
