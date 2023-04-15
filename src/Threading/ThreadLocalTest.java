package Threading;

import java.time.LocalDate;

public class ThreadLocalTest {

    static ThreadLocal<MiObjeto> threadLocal= new ThreadLocal<>();
    static record MiObjeto(String nombre, LocalDate fecha){};
    public static void main(String[] args) {



        threadLocal.set(new MiObjeto("Quintana", LocalDate.now()));

        stackmethod1();

    }

    static void stackmethod1(){
        System.out.println("Thread stack method 1");
        stackmethod2();
    }

    static void stackmethod2(){
        System.out.println("Thread stack method 1");
        MiObjeto miObj= threadLocal.get();
        System.out.println(miObj.toString());
    }

}
