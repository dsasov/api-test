import test.Property;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

class Serialization {
    void serialize(ArrayList<Movie> movies) {
        // Serializing all movies into "response" file
        try (Writer writer = new FileWriter(Property.readProperties().getProperty("responseFile"))) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(movies, writer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
