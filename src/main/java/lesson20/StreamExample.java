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




        // ������� ������ ������ 20 ���
        personFromApi.stream()
                .filter(person -> (person.getAge() > 20))
                .filter(person -> (person.getGender().equals("female")))
//                .sorted(Comparator.comparing(Person::getAge)
//                .thenComparing(Person::getGender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
        System.out.println("=======================================================");
        // ����� ������ ������ 18 ��� � ������� �������� � ���� ��� ���� ��������
        // (������ ��������� ����� ��������� 01.01.2222)
        //����� � ������ ������� �� 30, ������ ��� �� 18 ��� ����� �� ������ ����������
        personFromApi.stream()
                .filter(person -> (person.getAge() < 30))
                .filter(person -> (person.getGender().equals("male")))
                .collect(Collectors.toList());
        for (Person person : personFromApi) {
            System.out.println(person.getName() + " " + person.getLastName() + " " + person.getDob());
        }
        System.out.println();
        System.out.println("=======================================================");

        // ����� ���� ��� ������ 50 � ��������� ���� ����� � ��������� ����

        List<Person> collect = personFromApi.stream()
                .filter(person -> (person.getAge() > 50))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println();
        System.out.println("=======================================================");

        //������� ���� � ���� ����� ��� ������ 30 ��������

        personFromApi.stream()
                .filter(person -> (person.getName().length() + person.getLastName().length()) < 30)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    }

