import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Steps {

    private URI testURL;
    private HttpURLConnection connection;
    private JsonArray results;

    @Before
    public void beforeMethod(){
        System.out.println("before");
    }

    @Given("^user searches for (.*)$")
    public void searchRequest(String query) throws URISyntaxException {
        System.out.println("info");
        testURL = Request.buildURI(query);
    }

    @When("^user sends request$")
    public void sendGetRequest() throws IOException {
        connection = Request.connect(testURL);
    }

    @Then("^user receives JSON response$")
    public void validateResponseCode() throws IOException {
        JsonElement response = Request.get(connection);

        results = response.getAsJsonObject().get("results").getAsJsonArray();

        Assert.assertEquals(200, connection.getResponseCode());
    }

    @Then("^JSON contains (.*)$")
    public void validateMovieName(String movieName) {
        Deserialization des = new Deserialization();
        ArrayList<Movie> movies = des.deserialize(results);

        for (Movie m : movies) {
            if (m.getTitle().equals(movieName)) {
                Assert.assertEquals("ffffff", m.getTitle());
                Assert.assertEquals(680, (int) m.getId());
            }
        }
    }
}
