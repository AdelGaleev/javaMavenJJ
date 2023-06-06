package lesson19;

import lesson16.Person;
import lesson16.PersonApi;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = PersonApi.getPersons(10);
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("_________________________________________");
//       LamdaExample.sortLamda(persons, new Predicato<Person>() {
//           @Override
//          public boolean test(Person person) {
//               return person.getCountry().equals("Spain");            }
//        });
//        System.out.println("________________________________________________");


        // ����� �� ������� ��, ��� �� �������� (Person person)
        // -> - ���������� �������
        // ������ - ���������


//        LamdaExample.sortLamda(persons, (Person person) -> { return person.getCountry().equals("Spain");});
//        System.out.println("____________________________________________");
//        LamdaExample.sortLamda(persons, p -> p.getCountry().equals("Spain"));

        // ����� 1 ���� ����� ��� ������
        // ������ 1 ����, ����������� ������� ������
        // ����� ���� ���������� ��������� ->
        // ���� ������ �������� ������, ����������� ������ ���� return
        // �������� ������ �������� ���� ����� ��������� ��������� ��������
        // ���� ��� �������� ������ ����� �� ��� ��������� � return
//        persons.stream().filter(p -> p.getCountry().equals("Spain")).forEach(System.out::println);

//        LambdaExample.sortLambda(persons, p -> p.getCountry().equals("Iran"),
//                pp -> {
//                    pp.setCountry("QWE");
//                    System.out.println(pp);
//                },
//                p -> p.length()
//        );
//    }

        @FunctionalInterface // �������������� ���������
        interface Predicato<T> {
            boolean test(T t);
        }

        interface Consumerito<T> {
            void accept(T t);

        }

        class LamdaExample {
            public static void sortLamda(List<Person> list,
                                         Predicato<Person> p,
                                         Consumerito<Person> c,
                                         Function<String, Integer> f) {
                for (Person person : list) {
                    if (p.test(person)) c.accept(person);
                    f.apply(person.getCountry());
                }
            }
        }
    }
}