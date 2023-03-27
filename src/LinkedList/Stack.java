package LinkedList;

import java.util.NoSuchElementException;

public class Stack {
    static Node top;
    static Node bottom;
    static class Node {
        int value;
        Node previous;
        Node(int value){
            this.value=value;
        }
    };

    public static void main(String[] args) {

        Stack q= new Stack();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.pop();
        q.pop();
        q.pop();
        q.pop();

        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);

        q.pop();
        q.pop();
        q.pop();
        q.pop();



    }

    void push(int value){

        Node n1=new Node(value);
        if (bottom ==null){
            bottom =n1;
        }

        if(top!=null){
            n1.previous=top;
        }
        top=n1;



    }

    void pop(){

        if(bottom==null){
            throw new NoSuchElementException();
        }
        if(top !=null) {
            System.out.println(top.value);
            top = top.previous;
        }
        if(top ==null)
            bottom =null;

    }

}
