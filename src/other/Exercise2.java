package other;

import java.util.*;

public class Exercise2 {

    public static void main(String[] args) {

        System.out.println(consecutiveNumbersMissing(Arrays.asList(1,10,20)));
        //System.out.println(consecutiveNumbersMissing(Arrays.asList(8,5,3,1)));
        //System.out.println(consecutiveNumbersMissing(Arrays.asList(12,6,4,7)));
    }

    private static List<Integer> consecutiveNumbersMissing(List<Integer> asList) {

        List<Integer> result= new ArrayList<>();
        Collections.sort(asList);

        for(int i = 0 ; i+1< asList.size(); i++){
            int min= asList.get(i);
            int max= asList.get(i+1);
            result.addAll(generateConsecutives(min, max));
        }

        return result;
    }


    private static List<Integer> generateConsecutives(Integer min, Integer max){
        List<Integer> results= new ArrayList<>();
        for(int i= min+1; i<max; i++){
            results.add(i);
        }
        return results;
    }

}
