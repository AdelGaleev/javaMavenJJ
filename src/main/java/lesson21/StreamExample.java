package lesson21;

import lesson16.Person;
import lesson16.PersonApi;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> persons = PersonApi.getPersonFromApi(10);
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("===================================================================");

        //Stream<Object> objectStream = persons.stream().flatMap(person -> person.getName());

        persons.stream()
                .map(person -> person.getAge())
                .reduce((acc,x) -> acc+x);

        persons.stream()
                        .sorted( (o1,o2) ->
                                {
                                    if(!o1.getName().equals(o2.getName()))
                                   return o1.getName().compareTo(o2.getName());
                                   return 0;
                                })
                                .forEach(System.out::println);



        System.out.println( Stream.of(1, 2, 3, 4, 5, 6)
                .reduce(33,(accumullyator, peremennaya_lista) ->
                        accumullyator + peremennaya_lista));

        //TreeSet<Person> treeSet = new TreeSet<>();


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> integerStream1 = Stream.of(11, 12, 13, 14, 15, 16,6);
        Stream.concat(integerStream, integerStream1)
                .distinct()
        .peek(System.out::println)
                .count();
    }
}
