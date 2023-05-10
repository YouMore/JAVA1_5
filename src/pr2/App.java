package pr2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    List<Human> people;

    public List<Human> getPeople() {
        return people;
    }

    public App() {
        people = new ArrayList<>();
        people.add(new Human(
                "Ivan",
                "Ivanov",
                LocalDate.of(2003, Month.MARCH, 29),
                81));
        people.add(new Human(
                "Petr",
                "Petrov",
                LocalDate.of(2000, Month.NOVEMBER, 14),
                75));
        people.add(new Human(
                "Alex",
                "Petrov",
                LocalDate.of(1999, Month.APRIL, 3),
                79));
        people.add(new Human(
                "Dmitry",
                "Ivanov",
                LocalDate.of(2004, Month.AUGUST, 17),
                72));
    }

    //1) Сортировка по имени, фильтрация по дате рождения большей, чем 24
    //июня 2000, сортировка по фамилии, нахождение суммы всех возрастов.
    public static void main(String[] args) {
        App app = new App();

        System.out.println("BEFORE-----------------------------------------------");
        Stream<Human> stream0 = app.getPeople().stream();
        stream0.forEach(System.out::println);

        System.out.println("SORTING----------------------------------------------");
        Stream<Human> stream1 = app.getPeople().stream();
        stream1.sorted(Comparator.comparing(Human::getFirstName)).forEach(System.out::println);

        System.out.println("FILTERING-------------------------  -------------------");
        Stream<Human> stream2 = app.getPeople().stream();
        stream2.filter(o-> o.getBirthDate().isAfter(LocalDate.of(2000, Month.JULY, 24))).forEach(System.out::println);

        System.out.println("SORTING LASTNAME----------------------------------------------");
        Stream<Human> stream3 = app.getPeople().stream();
        stream3.sorted(Comparator.comparing(Human::getLastName)).forEach(System.out::println);

        System.out.println("SUMM AGE----------------------------------------");
        Stream<Human> stream4 = app.getPeople().stream();
        int sumOfAges = stream4.mapToInt(Human::getAge).sum();
        System.out.println(sumOfAges);

    }
}

