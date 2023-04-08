package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {

        Printable p= () -> {
            System.out.println("Lambda example 1");
        };

        Printable p2= () -> {
            System.out.println("Lambda example 2");
        };

        Printable p3= () -> {
            System.out.println("Lambda example 3");
        };

        PrintableV2 p4= (x, y) -> {
            System.out.println(x+y);
        };

        PrintableV2 p5= (x, y) -> {
            System.out.println(x-y);
        };

        PrintableV2 p6= (x, y) -> {
            System.out.println(x*y);
        };

        PrintableV2 p7= (x, y) -> {
            System.out.println(x/y);
        };


        List<Printable> list= new ArrayList<>(Arrays.asList(p,p2,p3));

        List<PrintableV2> list2= new ArrayList<>(Arrays.asList(p4,p5,p6,p7));


        executePrintable(list);

        executePrintableV2(list2);
    }


    static void executePrintable(List<Printable> printable){
        printable.stream().forEach(Printable::print);
    }

    static void executePrintableV2(List<PrintableV2> printable){
        printable.stream().forEach(printableV2 -> printableV2.print(100,10));
    }

}


interface Printable{
 void print();

}

interface PrintableV2{
    void print(Integer x, Integer y);

}