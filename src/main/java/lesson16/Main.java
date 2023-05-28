package lesson16;

public class Main {
    public static void main(String[] args) {
        Person personApi = PersonApi.getPersonFromApi();
        System.out.println(personApi);
    }
}
