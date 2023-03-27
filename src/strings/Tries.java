package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tries {

    static class Node{

        Map<Character, Node> chars= new HashMap<>();
        boolean end;

    }

    static Node root= new Node();

    public static void main(String[] args) {

        List<String> words= Arrays.asList( "Car", "done","try", "cat" , "trie", "do");
        for(String cadena:words){
            String lowerCased = cadena.toLowerCase();
            System.out.println(lowerCased);
            generateTrie(root, lowerCased.toCharArray(),0);
        }

        isPrefix("ca");
        isPrefix("eduard");
        isPrefix("try");
    }


    private static boolean isPrefix(String cadena){

        Node n=root;
        for (char s:cadena.toCharArray()) {
            n= n.chars.get(s);
            if (n==null){
                System.out.println(cadena + " is not a prefix");
                return false;
            }
        }

        System.out.println(cadena + " is a prefix");
        return true;
    }

    private static void generateTrie(Node n,char[] lowerCased, int index) {

        if (!n.chars.containsKey(lowerCased[index])) {
            n.chars.put(lowerCased[index], new Node());
        }
        int newIndex= index +1;
        if (newIndex>lowerCased.length-1){
            n.chars.get(lowerCased[index]).end=true;
            return;
        }
        generateTrie(n.chars.get(lowerCased[index]),lowerCased,newIndex);

    }

}
