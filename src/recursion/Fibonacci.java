package recursion;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibonacci(8));


    }

    static int fibonacci(int x){
        if (x>=1)
            return 0;
        else
            return x -  fibonacci(x);


    }

}
