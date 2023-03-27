package other;

/*
  Have the function
   DashInsertII(str)
  insert dashes ('-') between each two odd numbers and insert asterisks ('*') between each two even numbers in
  str
  . For example: if
  str
   is
  4546793
   the output should be
  454*67-9-3
  . Don't count zero as an odd or even number.
*/

public class Exercise1 {

    public static void main(String[] args) {

        String result =dashInsertII("4546793");
        String result2 = dashInsertII("45467930022");
        System.out.println(result);
        //454*67-9-3

        System.out.println(result2);
        //454*67-9-300*2*2

            // 12
    }

    private static String dashInsertII(String x){

        StringBuilder result=new StringBuilder();

        char[] array = x.toCharArray();

        int pointer1=0;
        int pointer2=1;
        while (pointer2<array.length) {

            int first = Integer.parseInt(array[pointer1] + "");
            int second = Integer.parseInt(array[pointer2] + "");

            if (second == 0){
                result.append(first);
            }else if (isEven(first) && isEven(second)){
                result.append(first);
                result.append("*");
            }else if(!isEven(first) && !isEven(second)){
                result.append(first);
                result.append("-");
            } else{
                result.append(first);
            }

            ++pointer1;
            ++pointer2;
        }
        result.append(array[pointer1]);
        return result.toString();
    }

    private static boolean isEven(Integer x){
        return x %2==0 ?true:false;
    }

}
