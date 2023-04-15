import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class SetsExample {
    static class Employee{

        public Employee(String name) {
            this.name = name;
        }

        private String name;
        private LocalDate dob;
        private boolean enabled;

        @Override
        public int hashCode() {
            return name.length();
        }

        //@Override
        public boolean equals(Object obj) {


            if (obj instanceof Employee){
                Employee e=(Employee)obj;
                if (this.name.equalsIgnoreCase(e.name)){
                    return true;
                }
            }
            return false;

        }

    }

    public static void main(String[] args) {

        Employee e1 = new Employee("Carlos Quintana");
        Employee e2 = new Employee("Ana Legorreta");
        Employee e3 = new Employee("Liliana Agredo");


        Set<Employee> set = new HashSet<>();

        set.add(e1);
        set.add(e2);
        set.add(e3);


        Employee e4 = new Employee("Liliana Agredo");
        System.out.println(set.contains(e4));





        set.stream().forEach(SetsExample::printElement);


    }

    static void printElement(Employee e){}


    static Supplier<Integer> getRandom(){
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random m=new Random();
                return m.nextInt();
            }
        };
    }

}
