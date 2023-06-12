package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<Person> list = PersonApi.getPersonFromApi(10);
//        for (Person person : list) {
//            System.out.println(person);
//        }
//        System.out.println("================================");
//        Stream.of(1,2,5,7,21,33,46,54,63)
//                .skip(5)
//                .limit(7)
//                .forEach(System.out::println);

//1) запросить 100 персонажей.
        List<Person> list = PersonApi.getPersonFromApi(100);
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println();
        System.out.println();
        System.out.println("================================");

// раскидать гендерно и получить  2 листа с мужчинами и женщинами
        Map<String, List<Person>> sortByGender = list.stream().collect(
                Collectors.groupingBy(Person::getGender));
        for(Map.Entry<String, List<Person>> item : sortByGender.entrySet()){
            System.out.println(item.getKey());
            for(Person person : item.getValue()){
                System.out.println(person);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("================================");

        //от этих листов, так же найти самого/самую взрослого и самого молодого, Вывести .
        Optional<Person> MinOfFemale = list.stream()
                .filter(person -> (person.getGender().equals("female")))
                .min(Comparator.comparing(Person::getAge));
        System.out.println(MinOfFemale);

        Optional<Person> MaxOfFemale = list.stream()
                .filter(person -> (person.getGender().equals("female")))
                .max(Comparator.comparing(Person::getAge));
        System.out.println(MaxOfFemale);

        Optional<Person> MinOfMale = list.stream()
                .filter(person -> (person.getGender().equals("male")))
                .min(Comparator.comparing(Person::getAge));
        System.out.println(MinOfMale);

        Optional<Person> MaxOfMale = list.stream()
                .filter(person -> (person.getGender().equals("male")))
                .max(Comparator.comparing(Person::getAge));
        System.out.println(MaxOfMale);


        System.out.println();
        System.out.println();
        System.out.println("================================");


        //посчитать количество в каждом списке.

        long male = list.stream()
                .filter(person -> (person.getGender().equals("male")))
                .count();
        System.out.println(male);
        System.out.println("================================");

        long female = list.stream()
                .filter(person -> (person.getGender().equals("female")))
                .count();
        System.out.println(female);

        System.out.println();
        System.out.println();
        System.out.println("================================");

        // 5)вывести средний возраст мужчин и отдельно срежний возраст жегщин.

        double female1 = list.stream()
                .filter(person -> (person.getGender().equals("female")))
                .mapToDouble(Person::getAge).average().getAsDouble();
        System.out.println(female1);

        double male1 = list.stream()
                .filter(person -> (person.getGender().equals("male")))
                .mapToDouble(Person::getAge).average().getAsDouble();
        System.out.println(male1);

        System.out.println();
        System.out.println();
        System.out.println("================================");

//      6) посчитать общий возраст мужчин.
// женщин посчитать общий возраст

        double female2 = list.stream()
                .filter(person -> (person.getGender().equals("female")))
                .mapToDouble(Person::getAge).sum();
        System.out.println(female2);

        double male2 = list.stream()
                .filter(person -> (person.getGender().equals("male")))
                .mapToDouble(Person::getAge).sum();
        System.out.println(male2);
    }
}
