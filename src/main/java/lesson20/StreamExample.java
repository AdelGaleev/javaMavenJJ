package lesson20;

import lesson16.Person;
import lesson16.PersonApi;
import lesson18.TestEmploe;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonFromApi(10);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
        System.out.println("===================================================================");

//        List<Person> iran = personFromApi.stream().
//                filter(person -> person.getCountry().equals("Iran"))
//                .collect(Collectors.toList());




        // вывести женжин старше 20 лет
        personFromApi.stream()
                .filter(person -> (person.getAge() > 20))
                .filter(person -> (person.getGender().equals("female")))
//                .sorted(Comparator.comparing(Person::getAge)
//                .thenComparing(Person::getGender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
        System.out.println("=======================================================");
        // найти мужчин младше 18 лет и вывести значение в виде ФИО дата рождения
        // (пример Мухаметов дамир шокирович 01.01.2222)
        //здесь я поднял возраст до 30, потому что до 18 лет почти не выдает результаты
        personFromApi.stream()
                .filter(person -> (person.getAge() < 30))
                .filter(person -> (person.getGender().equals("male")))
                .collect(Collectors.toList());
        for (Person person : personFromApi) {
            System.out.println(person.getName() + " " + person.getLastName() + " " + person.getDob());
        }
        System.out.println();
        System.out.println("=======================================================");

        // найти всех кто старше 50 и сохранить этих людей в отдельный лист

        List<Person> collect = personFromApi.stream()
                .filter(person -> (person.getAge() > 50))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println();
        System.out.println("=======================================================");

        //вывести всех у кого Длина фио меньше 30 символов

        personFromApi.stream()
                .filter(person -> (person.getName().length() + person.getLastName().length()) < 30)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    }

