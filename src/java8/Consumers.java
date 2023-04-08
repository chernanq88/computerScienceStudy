package java8;

import java.util.function.Consumer;

public class Consumers {

    public static void main(String[] args) {

        welcomeCustomer.accept(new Customer("Carlos"));
    }

    static class Customer{
        Customer(String name){
            this.name=name;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static Consumer<Customer> welcomeCustomer = customer -> {

        System.out.println("Welcome " + customer.getName());

    };

}
