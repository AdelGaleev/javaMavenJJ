package lesson16;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PersonApi {
    public static Person getPersonFromApi() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create("https://randomuser.me/api")).
                GET().
                build();

        try {
             HttpResponse<String> responcex = client.send(request, HttpResponse.BodyHandlers.ofString());
             Person person =  parseJsonToPerson(responcex);
             return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person parseJsonToPerson(HttpResponse<String> responcex) {
        JSONObject object = new JSONObject (responcex.body())
                .getJSONArray("results").getJSONObject(0);

        Person res = new Person();
        res.setName(object.getJSONObject("name").getString("first"));
        res.setLastName(object.getJSONObject("name").getString("last"));
        res.setCountry(object.getJSONObject("location").getString("country"));
        //res.setDob(object.getJSONObject();
        res.setUsername(object.getJSONObject("login").getString("username"));
        res.setPassword(object.getJSONObject("word").getString("password"));
// заполнить остальные поля
        return res;
    }
}
