package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingAndCollecting {

    public static void main(String[] args) {

        record Employee(String name, int age, double salary){};

        List<Employee> employee = List.of(new Employee("Carlos",34, 5000),
                                              new Employee("Ana",34, 25000),
                                              new Employee("Liliana",56,10000));

        employee.stream().mapToDouble(Employee::salary).sum();

        employee.stream().sorted(Comparator.comparing(Employee::age,Comparator.reverseOrder())).forEach(System.out::println);

        System.out.println("""
                """);


        employee.stream().sorted(Comparator.comparing(Employee::age)).forEach(System.out::println);

        System.out.println("""
                """);

        employee.stream().dropWhile(employee1 -> employee1.age==34).forEach(System.out::println);

        System.out.println("""
                """);

        Map<Integer,List<Employee>>  map= employee.stream().collect(Collectors.groupingBy(Employee::age));

        map.entrySet().stream().forEach(integerListEntry -> {

            System.out.println(integerListEntry.getKey());
            integerListEntry.getValue().forEach(i-> System.out.println(" " + i));
        });
    }

}
