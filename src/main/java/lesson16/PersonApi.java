package lesson16;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PersonApi {
    public static Person getPersonFromApi() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().
                uri(URI.create("https://randomuser.me/api")).build();
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
        LocalDateTime dob =
                ZonedDateTime.parse(object.getJSONObject("dob").
                        getString("date")).toLocalDateTime();
        res.setDob(dob);
        res.setUsername(object.getJSONObject("login").getString("username"));
        res.setPassword(object.getJSONObject("login").getString("password"));
        res.setAge(object.getJSONObject("dob").getInt("age"));
        res.setGender(object.getString("gender"));
// заполнить остальные поля
        return res;
    }
    public static List<Person> getPersonFromApi(int count) {

        List<Person> persons = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().
                uri(URI.create("https://randomuser.me/api")).build();
        try {
            for (int i = 0; i < count; i++) {
                HttpResponse<String> responcex = client.send(request, HttpResponse.BodyHandlers.ofString());

                Person person = parseJsonToPerson(responcex);
                persons.add(person);
            }
                return persons;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Person> getPersons (int count) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.
                newBuilder().
                GET().
                uri(URI.create(String.format("https://randomuser.me/api?results=%d", count))).build();
        try {
            HttpResponse<String> responcex = client.send(request, HttpResponse.BodyHandlers.ofString());

            List<Person> persons = jsonParser(responcex);
            return persons;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Person> jsonParser(HttpResponse<String> response) {

        List<Person> res = new ArrayList<>();
        int count = new JSONObject(response.body()).getJSONObject("info").
                getInt("results");

        for (int i = 0; i < count; i++) {
            JSONObject object = new JSONObject(response.body()).
                    getJSONArray("results").getJSONObject(i);

            Person person = new Person();
            person.setName(object.getJSONObject("name").getString("first"));
            person.setLastName(object.getJSONObject("name").getString("last"));
            person.setCountry(object.getJSONObject("location").getString("country"));
            LocalDateTime dob =
                    ZonedDateTime.parse(object.getJSONObject("dob").
                            getString("date")).toLocalDateTime();
            person.setDob(dob);
            person.setUsername(object.getJSONObject("login").getString("username"));
            person.setPassword(object.getJSONObject("login").getString("password"));
            person.setAge(object.getJSONObject("dob").getInt("age"));
            person.setGender(object.getString("gender"));
            res.add(person);

        }
        return res;
    }
}
