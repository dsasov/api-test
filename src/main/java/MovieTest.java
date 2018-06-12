import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.Assert;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;

public class MovieTest {

    @Test
    public void testMovieTitle() throws Exception {
        URI testURL = Request.buildURI("pulp+fiction");

        // Creating HTTP connection
        HttpURLConnection connection = Request.connect(testURL);

        // Making GET request to the test URL and writing JSON response into JsonElement object
        JsonElement response = Request.get(connection);

        // Getting the necessary information about movies and putting that array into JsonArray
        JsonArray results = response.getAsJsonObject().get("results").getAsJsonArray();

        Deserialization des = new Deserialization();
        ArrayList<Movie> movies = des.deserialize(results);

        for(Movie m : movies) {
            if (m.getTitle().equals("Pulp Fiction")) {
                Assert.assertEquals("Pulp Fiction", m.getTitle());
                Assert.assertEquals(680, (int) m.getId());
            }
        }
    }

}