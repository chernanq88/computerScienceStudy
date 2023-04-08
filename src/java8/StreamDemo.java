package java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamDemo {

    public static void main(String[] args) {

        enum sexo{
            MASCULINO,
            FEMENINO
        };

        class Persona implements Comparable{

            static int contador=0;

            Integer id;
            String nombre;
            String apellido;
            String sexo;

            public Persona(String nombre, String apellido, String sexo) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.sexo = sexo;
                id=++contador;
            }

            public String getSexo() {
                return sexo;
            }

            @Override
            public String toString() {
                return id + " " + nombre + " " + apellido;
            }

            @Override
            public int compareTo(Object o) {
                if (this.id > ((Persona)o).id){
                    return 1;
                }else if(this.id< ((Persona)o).id){
                    return -1;
                }
                return 0;
            }
        }



        Persona p2= new Persona("Carlos", "Quintana", sexo.MASCULINO.name());
        Persona p1 =  new Persona("Hernan", "Quintana", sexo.MASCULINO.name());
        Persona p3 = new Persona("Ana", "Legorreta", sexo.FEMENINO.name());
        Persona p4 = new Persona("Liliana", "Agredo", sexo.FEMENINO.name());
        Persona p5 = new Persona("Lina", "Martinez", sexo.FEMENINO.name());
        Persona p6 = new Persona("Alex", "Narvaez", sexo.FEMENINO.name());
        List<Persona> list= Arrays.asList(p4,p3, p1, p2,p5,p6);

        Map<String, List<Persona>> group =
            list.stream().collect(groupingBy(Persona::getSexo));

        System.out.println(group);

        Collections.sort(list);

        System.out.println("Ordenado");


        int result=
            Collections.binarySearch(list, 5, (o1, o2) -> {
                if (((Persona)o1).id > (Integer)o2){
                    return 1;
                }else if(((Persona)o1).id < (Integer)o2){
                    return -1;
                }
                return 0;
            });

        System.out.println(result);



    }

}
