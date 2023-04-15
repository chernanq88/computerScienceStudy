package java8;

import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {

        IntStream.rangeClosed(0,10).skip(4).forEach(System.out::println);

    }
}
