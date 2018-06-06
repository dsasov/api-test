import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.ArrayList;

class Deserialization {

    ArrayList<Movie> deserialize(JsonArray results) {
        // Creating ArrayList for movies
        ArrayList<Movie> movies = new ArrayList<>();

        // Creating new Movie object for every JSON entry and deserializing the content into objects
        for (int i = 0; i < results.size(); i++) {
            movies.add(new Movie());
            movies.set(i, new Gson().fromJson(results.get(i), Movie.class));
        }
        return movies;
    }

}
