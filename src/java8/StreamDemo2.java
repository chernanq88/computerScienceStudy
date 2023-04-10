package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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




    }

}
