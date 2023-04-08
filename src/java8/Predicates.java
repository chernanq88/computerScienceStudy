package java8;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Predicates {
    static class Customer{

        String nombre;

        public Customer(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

    static Predicate<Customer> predicate = customer -> customer.getNombre().length()>6;
    static Predicate<Customer> isValidName = customer -> customer.getNombre().length()<15;

    static Predicate<Customer> isValidA = customer -> customer.getNombre().contains("a");



    public static void main(String[] args) {

        Customer c1= new Customer("Carlos");
        Customer c2= new Customer("Hernan");
        Customer c3= new Customer("Liliana");
        Customer c4= new Customer("Paola");

        for (Customer customer : List.of(c1, c2, c3, c4)) {
            System.out.println(isValidName.or(predicate).and(isValidA).test(customer));
        }



    }


}
