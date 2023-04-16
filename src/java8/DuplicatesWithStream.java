package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicatesWithStream {

    public static void main(String[] args) {

        Stream<Integer> list=Stream.of(1,2,3,4,5,6,1,2,7,8,45,56,34,56);

        List<Integer> result= list
                .collect(Collectors.groupingBy(Integer::intValue)).entrySet()
                .stream()
                .filter(integerListEntry -> integerListEntry.getValue().size()>1).collect(Collectors.toList())
                .stream().flatMap(integerListEntry -> integerListEntry.getValue().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);


    }

}
