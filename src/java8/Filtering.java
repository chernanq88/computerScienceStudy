package java8;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Filtering {

    public static void main(String[] args) {

        System.out.println(longestWord("I love dogs"));

        System.out.println(intersection("1,2,3,4,5,6,7,8", "1,2,3"));
        System.out.println(intersection("1,3,4,7,13", "1,2,4,13,15"));

        System.out.println(factorial(4));


        System.out.println(bitwiseOperation("010101", "101010"));
        System.out.println(bitwiseOperation("000101", "000000"));


        System.out.println(firstReverseOrder("I love to code"));
        //   "edoc ot evol i"

        System.out.println(bracketsValidator("(This brackets() are okay)"));
        System.out.println(bracketsValidator("(This brackets()) are no okay)"));
        System.out.println(bracketsValidator("(This brackets() are () okay())"));
        System.out.println(bracketsValidator("(This brackets() are () okay())"));

        System.out.println("username " + usernameValidator("chernanq88"));
        System.out.println("username " + usernameValidator("chernanq_88"));
        System.out.println("username " + usernameValidator("chernanq88_"));
        System.out.println("username " + usernameValidator("1chernanq88_"));
        System.out.println("username " + usernameValidator("qqq"));


        System.out.println("Animal es Palindromo?" + isPalindrome("animal"));
        System.out.println("Radar es Palindromo?" + isPalindrome("radar"));
        System.out.println("Reconocer es Palindromo?" + isPalindrome("reconocer"));
        System.out.println("Oso es Palindromo?" + isPalindrome("oso"));
        System.out.println("Identificacion es Palindromo?" + isPalindrome("Identificacion"));


        System.out.println(caracterMasusado("Vamos a validar cual es el caracter mas usado"));

        System.out.println(contarVocales("Vamos a validar cual es el caracter mas usado"));


        System.out.println("Es un anagrama? " + anagrama("sergio", "riesgo"));
        System.out.println("Es un anagrama? " + anagrama("amor", "roma"));
        System.out.println("Es un anagrama? " + anagrama("eeeeee", "aaaaaa"));
        System.out.println("Es un anagrama? " + anagrama("aventura", "risa"));

        System.out.println("Convertir a mayusculas: " + conversorAMayusculas("este muchacho esta pensando mucho el dia de hoy"));


        myfibonacci(10);

        calcularDias(920);

        removerElementosDuplicados("esta es una prueba para validar los elementos duplicados");

        permutaciones(new ArrayList<>(), Arrays.asList(1, 2, 3, 4));

        //o(n)
        monotonicStackBeachViewForBuildings(Arrays.asList(20, 17, 15, 14, 8, 6, 5, 4));

        //o(n)
        monotonicStackStockSpan();


        //O(n)
        //dailyTemperatures();

        customStack();

        customQueue();


        treeInOrder();

    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    private static void treeInOrder() {


        TreeNode node1 = new TreeNode();
        node1.value = 1;

        TreeNode node2 = new TreeNode();
        node2.value = 2;

        TreeNode node3 = new TreeNode();
        node3.value = 3;

        TreeNode node4 = new TreeNode();
        node4.value = 4;

        TreeNode node5 = new TreeNode();
        node5.value = 5;

        TreeNode node6 = new TreeNode();
        node6.value = 6;

        TreeNode node7 = new TreeNode();
        node7.value = 7;

        TreeNode node8 = new TreeNode();
        node8.value = 8;

        TreeNode node9 = new TreeNode();
        node9.value = 9;

        TreeNode node10 = new TreeNode();
        node10.value = 10;

        node9.left = node10;

        node4.left=node8;
        node7.right=node9;

        node1.right = node3;
        node1.left = node2;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node1);

        while (!queue.isEmpty()) {

            int totalElements = queue.size();
            while (totalElements > 0) {
                TreeNode node = queue.remove();
                if (totalElements==1)
                    System.out.println(node.value);
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
                totalElements--;
            }

        }

        System.out.println("\n\n");
        printAllTreePaths(node1, new ArrayList<>());





    }

    public static void printAllTreePaths(TreeNode node, List<Integer> path ){


        if (node.left==null && node.right==null){
            path.add(node.value);
            System.out.println(path);
        }

        if (node.left!=null){
            List<Integer> temp=new ArrayList<Integer>(path);
            temp.add(node.value);
            printAllTreePaths(node.left,temp);
            temp.remove(temp.size()-1);
        }

        if (node.right!=null){
            List<Integer> temp=new ArrayList<Integer>(path);
            temp.add(node.value);
            printAllTreePaths(node.right,temp);
            temp.remove(temp.size()-1);
        }




    }


    private static void inorderForBST(TreeNode node){


        if (node.left!=null){
         //   inorder(node.left);
        }

        System.out.println(node.value);

        if (node.right!=null){
           // inorder(node.right);
        }




    }

    private static void customQueue() {

        class CustomQueue{
            private Node current;
            private Node firstNode;

            private int size;
            class Node{

                Integer x;
                Node next;
            }


            public void push(Integer x){
                Node newNode= new Node();
                newNode.x=x;
                if (this.current==null){
                    current=newNode;
                    firstNode=current;
                }else{
                    current.next= newNode;
                    current=newNode;
                }
                ++size;
            }

            public Integer pop(){
                Node first= firstNode;
                if (first!=null){
                    firstNode = first.next;
                    --size;
                    if (firstNode==null){
                        current=null;
                    }
                    return first.x;
                }

                return null;
            }

            public Integer size(){
                return size;
            }
        }



        CustomQueue queue=new CustomQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println("size " + queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("size " + queue.size());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println("size " + queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("size " + queue.size());



    }

    private static void customStack() {

        System.out.println("Custom stack");
        class Node{
            int value;
            Node previous;

            @Override
            public String toString() {
                return value+"";
            }
        }

        class Stack{
            Node current;

            public void push(int x){
                Node newNode=new Node();
                newNode.value=x;
                newNode.previous = current;
                current=newNode;
            }

            public Node pop(){
                Node top= current;

                if(current==null){
                    System.out.println("Empty stack");
                    return null;
                }else{
                    current= current.previous;
                }
                return top;
            }

        }

        Stack myStack=new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }

    private static void dailyTemperatures() {

        List<Integer> result=new ArrayList<>();
        Stack<Integer> dailyTemperatures = new Stack<>();

        IntStream.of(73,74,75,71,69,72,76,73).forEach(dailyTemp-> dailyTemperaturesStackValidator(dailyTemp, dailyTemperatures, result));
        System.out.println(result);
    }

    private static void dailyTemperaturesStackValidator(int dailyTemp, Stack<Integer> dailyTemperatures, List<Integer> result) {

        if (dailyTemperatures.isEmpty()){
            dailyTemperatures.push(dailyTemp);
            return;
        }

        List<Integer> temp= new ArrayList<>();

        int i=0;
        if(!dailyTemperatures.isEmpty() && dailyTemperatures.peek()<dailyTemp){
            result.add(1);
        }else {
            boolean found=false;
            while (!dailyTemperatures.isEmpty() && !found) {
                int tempDaily = dailyTemperatures.peek();
                if(tempDaily>dailyTemp){

                }

                    temp.add(tempDaily);
                    i++;
            }
            result.add(i);
        }

        dailyTemperatures.addAll(temp);
        dailyTemperatures.push(dailyTemp);

    }


    private static void monotonicStackStockSpan() {

        Stack<Integer> monotonicStack = new Stack<>();
        monotonicStack.push(0);
        List<Integer> result= new ArrayList<>();
        IntStream.of(100,80,60,70, 60,75,85).forEach(stock-> monotonicStackEvaluationStocks(stock, monotonicStack, result));
        System.out.println(result);
    }

    private static void monotonicStackEvaluationStocks(int stock, Stack<Integer> monotonicStack, List<Integer> result) {

        if (monotonicStack.size()==1){
            result.add(1);
            monotonicStack.push(stock);
            return;
        }

        List<Integer> validationList=new ArrayList<>();
        int i=1;
        while(monotonicStack.peek()<stock){
            int stackTopValue= monotonicStack.pop();
            validationList.add(stackTopValue);
            ++i;
        }
        monotonicStack.addAll(validationList);
        monotonicStack.push(stock);
        result.add(i);
    }

    private static void monotonicStackBeachViewForBuildings(List<Integer> asList) {

        Stack<Integer> buildings = new Stack<>();
        buildings.addAll(asList);

        IntStream.of(8,1,3,4).forEach(integer->monotonicStackEvaluation(integer,buildings));

        System.out.println(buildings);

    }

    public static void monotonicStackEvaluation(int x, Stack<Integer> stack){

        while (stack.peek()<x) {
            stack.pop();
        }
        stack.push(x);

    }




    public static void permutaciones(List<Integer> slate, List<Integer> array){
        if (array.size()==0){
            System.out.println(slate);

        }else {
            for (int i = 0; i < array.size() ; i++) {
                slate.add(array.get(i));
                ArrayList<Integer>temp= new ArrayList<>(array);
                temp.remove(i);
                permutaciones(slate, temp);
                slate.remove(array.get(i));
            }
        }
    }


    private static void removerElementosDuplicados(String s) {




    }

    private static void calcularDias(final int dias) {

        int anos= dias / 365;
        System.out.println("Anos " + anos);

        int diasRestantes = dias % 365;

        int meses= diasRestantes / 30;
        System.out.println("Total de Meses " + meses);

        int diasFinales = diasRestantes % 30;
        System.out.println("Total de Meses " + diasFinales);


    }

    private static void myfibonacci(int limite) {

        int[] array= new int[limite];
        array[0]=1;
        array[1]=1;
        for(int i=2; i<limite; i++){
            array[i]= array[i-1] + array[i-2];
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    private static String conversorAMayusculas(String s) {

        List<String> finalResult= Arrays
                .stream(s.split("\s"))
                .map(palabra ->
                  palabra.substring(0,1).toUpperCase() + palabra.substring(1)
         ).collect(Collectors.toList());

        return String.join(" ", finalResult);
    }

    private static boolean anagrama(String primerstring, String segundoString) {

        if(primerstring.length() != segundoString.length())
            return false;
        char[] arrayPrimerString = primerstring.toCharArray();

        Map<Character, Integer> relacionPrimerString= new HashMap<>();
        for(char s: arrayPrimerString){
            if (!relacionPrimerString.containsKey(s)){
                relacionPrimerString.put(s,1);
            }else{
                relacionPrimerString.put(s,relacionPrimerString.get(s)+1);
            }
        }

        for(char s: segundoString.toCharArray()){
            if (relacionPrimerString.containsKey(s)){
                relacionPrimerString.put(s, relacionPrimerString.get(s)-1);
                if ( relacionPrimerString.get(s)==0){
                    relacionPrimerString.remove(s);
                }
            }
        }

        return relacionPrimerString.isEmpty();
    }

    private static Integer contarVocales(String arrays) {


        char[] array = arrays.toLowerCase().toCharArray();

        int contador= 0;
        for(char c:array){
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                ++contador;
            }
        }

        return contador;
    }

    private static char caracterMasusado(String cadena) {


        char caracter=' ';
        Integer cuenta=0;
        Map<Character, Integer> relacionCaracterNumero = new HashMap<>();
        for(char localChar: cadena.toCharArray()){
            if (relacionCaracterNumero.containsKey(localChar)){
                relacionCaracterNumero.put(localChar, relacionCaracterNumero.get(localChar)+1);

            }else{
                relacionCaracterNumero.put(localChar, 1);
            }
            if (relacionCaracterNumero.get(localChar)>cuenta){
                caracter= localChar;
                cuenta= relacionCaracterNumero.get(localChar);
            }
        }
        System.out.println(relacionCaracterNumero);
        return caracter;
    }

    private static boolean isPalindrome(String animal) {

        char[] array = animal.toCharArray();

        int limiteSuperior=animal.length()-1;
        int limiteInferior=0;
        while(limiteInferior<=limiteSuperior){
            if (array[limiteSuperior] == array[limiteInferior]){
                --limiteSuperior;
                ++limiteInferior;
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean usernameValidator(String chernanq88) {
        chernanq88 = chernanq88.toLowerCase();
        return !chernanq88.endsWith("_") &&
                (chernanq88.length()>=4 && chernanq88.length()<25) &&
                chernanq88.matches("[a-z0-9_]+") ;

    }

    private static boolean bracketsValidator(String s) {

        Stack<Character> myStack= new Stack<>();
        char[] array= s.toCharArray();

        for(int i=0; i< s.length(); i ++){
            if(array[i]=='('){
                myStack.push(array[i]);
            }else if(array[i]==')'){
                if (myStack.size()==0){
                    return false;
                }
                myStack.pop();
            }
        }
        return true;

    }

    private static String longestWord(String string) {

        String[] array = string.split("\s");
        Integer number = 0;
        String word = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length()>number){
                word= array[i];
                number= array[i].length();
            }
        }

        return word;

    }


    private static String intersection(String string1, String string2) {
        String[] string1Mapped = string1.split(",");
        String[] string2Mapped = string2.split(",");
        Set<String> repeated= new HashSet<>();
        Arrays.stream(string1Mapped).forEach(repeated::add);
        List<String> finalResult= new ArrayList<>();
        Arrays.stream(string2Mapped).forEach(localString2-> {
                    if (repeated.contains(localString2)){
                            finalResult.add(localString2);
                    }
                }
        );
        return String.join(",", finalResult);
    }

    private static int factorial(int number) {

        int result = 1;

        for (int i = 1; i <= number; i++){
            result *= i;
        }

        return result;
    }

    private static String bitwiseOperation(String operand1, String operand2){

        char[] operandList1= operand1.toCharArray();
        char[] operandList2= operand2.toCharArray();
        StringBuilder result =  new StringBuilder();

        for(int i=0; i< operand1.length();i++){
            String booleanResult=  (operandList1[i]=='1' || operandList2[2]=='1')?"1":"0";
            result.append(  booleanResult);
        }


        return result.toString();
    }

    private static String firstReverseOrder(String toReverse){

        StringBuilder stringBuilder=new StringBuilder();

        char[] array = toReverse.toCharArray();

        for(int i= array.length-1 ; i>=0 ; i--) {
            stringBuilder.append(array[i]);
        }

        return stringBuilder.toString();

    }



}
