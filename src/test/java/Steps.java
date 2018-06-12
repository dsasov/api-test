import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Steps {

    private URI testURL;
    private HttpURLConnection connection;
    private JsonArray results;

    private final Logger logger = LogManager.getRootLogger();

    @Given("^user searches for (.*)$")
    public void searchRequest(String query) throws URISyntaxException {
        logger.info("Given user searches for " + query);
        testURL = Request.buildURI(query);
    }

    @When("^user sends request$")
    public void sendGetRequest() throws IOException {
        logger.info("When user sends request");
        connection = Request.connect(testURL);
    }

    @Then("^user receives JSON response$")
    public void validateResponseCode() throws IOException {
        logger.info("Then user receives JSON response");
        JsonElement response = Request.get(connection);
        results = response.getAsJsonObject().get("results").getAsJsonArray();

        Assert.assertEquals(200, connection.getResponseCode());
    }

    @And("^JSON contains (.*)$")
    public void validateMovieName(String movieName) {
        logger.info("And JSON contains " + movieName);
        Deserialization des = new Deserialization();
        ArrayList<Movie> movies = des.deserialize(results);

        for (Movie m : movies) {
            if (m.getTitle().equals(movieName)) {
                Assert.assertEquals("Pulp Fiction", m.getTitle());
                Assert.assertEquals(680, (int) m.getId());
            }
        }
    }
}
