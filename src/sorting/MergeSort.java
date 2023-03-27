package sorting;

import java.util.ArrayList;

public class MergeSort {

    // Divide and conquer
    // o n log n worst

    public static void main(String[] args) {




    }


    public static void mergeSort(int[] list, int lowIndex, int highIndex){

        if (lowIndex== highIndex){
            return;
        }else{
            int midIndex= ( lowIndex + highIndex ) /2;
            mergeSort(list, lowIndex, midIndex );
            mergeSort(list, midIndex +1 , highIndex );
            merge(list, lowIndex, midIndex +1, highIndex);

        }

    }

    public static void merge(int[] list, int lowIndex, int midIndex, int highIndex ){


        ArrayList<Integer>result= new ArrayList<>();
        while(lowIndex<highIndex)
            if (list[lowIndex]<=list[highIndex] ) {
                result.add(list[lowIndex]);
                lowIndex++;

            }else if(lowIndex>highIndex){
                result.add(list[highIndex]);
                highIndex++;
            }



    }


}
