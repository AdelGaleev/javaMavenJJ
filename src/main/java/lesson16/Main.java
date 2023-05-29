package lesson16;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person personFromApi = PersonApi.getPersonFromApi();
//        System.out.println(System.getProperty("java.home"));

        List<Person> personFromApi = PersonApi.getPersons(10);

        for (Person person : personFromApi) {
            System.out.println(person);
        }

    }
}
