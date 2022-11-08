package com.example.appspringlearning.stream.example;

import com.example.appspringlearning.stream.beans.Car;
import com.example.appspringlearning.stream.beans.Person;
import com.example.appspringlearning.stream.beans.PersonDTO;
import com.example.appspringlearning.stream.mocData.MocData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetStarted {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Ali", "Alex", "Alesha"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );
    List<String> names = new ArrayList<>();

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MocData.getPeople();
        List<Person> young = new ArrayList<>();
        int limit = 10;
        int count = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                young.add(person);
                count++;
                if (count == limit) {
                    break;
                }
            }
        }
        young.forEach(System.out::println);
    }

    @Test
    public void declarativeApproach() throws IOException {
        List<Person> people = MocData.getPeople();
        List<Person> young = people
                .stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList());

        young.forEach(System.out::println);
    }

    @Test
    public void rangeInt() throws IOException {
        List<Person> people = MocData.getPeople();
        IntStream
                .range(0, people.size())
                .forEach(index -> System.out.println(people.get(index)));
    }

    @Test
    public void iterate() {
        IntStream
                .iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void min() {
        List<Integer> numbers = List.of(88, -44, 5, 1, 676, 3, 1, 5, 6);

//          min
//        int min = numbers
//                .stream()
//                .min((Comparator.naturalOrder())).get();
//        System.out.println(min);


//        distinct 1
//        List<Integer> distinct = numbers
//                .stream()
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(distinct);


//        distinct 2
//        Set<Integer> collect = new HashSet<>(numbers);
//        System.out.println(collect);

    }

    @Test
    public void filter() throws IOException {
        List<Person> people = MocData.getPeople();

//        Stream.of(88, -44, 5, 1, 676, 3, 1, 5, 6)
//                .filter(i -> i % 2 == 0)
//                .forEach(i -> System.out.print(i + " "));
//
//        System.out.println();
//
//        Stream.of(88, -44, 4, 1, 676, 3, 1, 5, 6)
//                .takeWhile(i -> i % 2 == 0)
//                .forEach(i -> System.out.print(i + " "));

        people.stream()
                .filter(person -> person.getAge() <= 18)
                .forEach(System.out::println);

        System.out.println();

        people.stream()
                .takeWhile(person -> person.getAge() <= 18)
                .forEach(System.out::println);

        System.out.println();

        people.stream()
                .dropWhile(person -> person.getAge() <= 18)
                .forEach(System.out::println);
    }

    @Test
    public void match() throws IOException {
        List<Person> people = MocData.getPeople();

        boolean allMatch = people.stream().allMatch(person -> person.getAge() == 50);
        System.out.println(allMatch);

        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() == 50);
        System.out.println(anyMatch);
    }

    @Test
    public void mapping() throws IOException {

        List<Person> people = MocData.getPeople();

        Function<Person, PersonDTO> dtoFunction = person -> new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge());

//        System.out.println(dtos.size());

//        List<PersonDTO> list = people.stream()
//                .map(Person::toDTO)
//                .collect(Collectors.toList());

//        list.forEach(System.out::println);
    }

    @Test
    public void reduce() {
        List<Integer> integers = List.of(88, -44, 5, 1, 676, 3, 1, 5, 6);

        Integer sum = integers.stream()
                .reduce(0, (a, b) -> a - b);

        Integer sum2 = integers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(sum2);
    }

    @Test
    public void floatMap() throws IOException {
        List<String> names = new ArrayList<>();

        List<String> list = arrayListOfNames
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        arrayListOfNames.forEach(names::addAll);

        System.out.println(names);
        System.out.println(list);

        List<Integer> integerList = new ArrayList<>();

        List<Object> collect = MocData.getCars()
                .stream()
                .map(car -> integerList.add(car.getYear()))
                .collect(Collectors.toList());

    }

    @Test
    public void count() throws IOException {
        List<Car> cars = MocData.getCars();

        long count = cars
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .count();

        System.out.println(count);
    }

    @Test
    public void minAndMax() throws IOException {
        List<Car> cars = MocData.getCars();
//
//        double min = cars
//                .stream()
//                .mapToDouble(Car::getPrice)
//                .min()
//                .orElse(-1);
//
//        System.out.println(min);
//
//        double max = cars
//                .stream()
//                .mapToDouble(Car::getPrice)
//                .max()
//                .orElse(-1);
//
//        System.out.println(max);
//
//        Optional<Car> maxCar = cars.stream()
//                .max(Comparator.comparing(Car::getPrice));
//
//        System.out.println(maxCar);
//
//        Optional<Car> minCar = cars.stream()
//                .min(Comparator.comparing(Car::getPrice));
//
//        System.out.println(minCar);
//
//        double average = cars.stream()
//                .mapToDouble(Car::getPrice)
//                .average()
//                .orElse(-1);
//
//        System.out.println(average);
//
//        double sum = cars.stream()
//                .mapToDouble(Car::getPrice)
//                .sum();
//
//        System.out.println(BigDecimal.valueOf(sum));

        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(BigDecimal.valueOf(statistics.getSum()));
    }

    @Test
    public void groupBy() {
        List<Object> list = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Map<Object, Long> map1 = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<Object, Long> map2 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map1);
        System.out.println(map2);
    }

    @Test
    public void sorting() throws IOException {
        List<Person> people = MocData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Person> sortedObject = people.stream()
                .sorted(Comparator
                        .comparing(Person::getFirstName)
                        .reversed()
                        .thenComparing(Person::getEmail))
                .collect(Collectors.toList());

        sortedObject.forEach(System.out::println);
    }

    @Test
    public void exercise() throws IOException {

        List<Car> cars = MocData.getCars();

        List<Car> blue = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice)
                        .reversed())
                .limit(10)
                .collect(Collectors.toList());

        blue.forEach(System.out::println);
    }

    @Test
    public void joiningStream() throws IOException {
        List<Person> people = MocData.getPeople();

        StringBuilder join1 = new StringBuilder();
        people.forEach(person -> {
            join1.append(person.getFirstName().substring(0, 1).toLowerCase())
                    .append(person.getFirstName().substring(1))
                    .append(", ");
        });
//        System.out.println(join1);


        String join2 = people.stream()
                .map(person -> person.getFirstName().substring(0, 1).toLowerCase() + person.getFirstName().substring(1))
                .collect(Collectors.joining(", "));

        System.out.println(join2);
    }

    @Test
    public void lazy() throws Exception {
        //                            System.out.println("mapping car " + car);
        System.out.println(
                MocData.getCars()
                        .stream()
                        .filter(car -> {
//                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(Car::getPrice)
                        .map(price -> {
//                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())


        );
    }
}
