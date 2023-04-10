package java8;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {

        System.out.println(IntStream.rangeClosed(1,10).sum());

        List<Object> list=List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println(
        list.stream()
                .mapToInt(object-> (Integer)object)
                .reduce(0,(a, b) -> a+b ));

        System.out.println(
            String.join(",",list.toString()));


        List<Employee> employees= List.of(new Employee("Carlos Quintana", 150000.0, "A"),
                        new Employee("Ana Leina", 120000.0, "a"),
                        new Employee("Antonia Julio", 4000.0, "B"));


        Double result=
         employees.stream()
                 .filter(employee -> "A".equalsIgnoreCase(employee.grade))
                 .mapToDouble(employee-> employee.salary)
                 .average()
                 .orElse(0.0);

        System.out.println(result);





    }

    record Employee (String name, Double salary, String grade){ }




}
