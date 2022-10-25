package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String text="jeje";
        String resultado=
                Optional.ofNullable(text).map(String::toUpperCase).orElse("VACIO");

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //list=null;
        List<Integer> listResult=
            Optional.ofNullable(list).orElse(new ArrayList<Integer>()).stream().filter(x->x<5).collect(Collectors.toList());

   //     listResult.forEach(System.out::println);

 //       System.out.println(resultado);

        Optional<List<Integer>> list2=
            Optional.ofNullable(list).or(() -> Optional.of(new ArrayList<>()));

        Optional.ofNullable(list).or(() -> Optional.of(new ArrayList<>()));


   //     Stream.ofNullable(list).forEach(System.out::println);








        Persona persona1= new Persona("Juanito", "Perez");

        Persona persona2= new Persona(null, null);
        Persona persona3= new Persona(null, null);



        List<Persona> personas=List.of(persona1,persona2,persona3);

        personas.forEach(System.out::println);


    }
}