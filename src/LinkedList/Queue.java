package LinkedList;

public class Queue {
    static Node front;
    static Node rear;
    static class Node {
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    };

    public static void main(String[] args) {

        Queue q= new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.pop();
        q.pop();
        q.push(100);
        q.pop();
        q.pop();

        q.push(5);
        q.push(6);
        q.pop();
        q.pop();
        q.pop();

    }

    void push(int value){

        Node n1=new Node(value);
        if (rear==null){
            rear=n1;
        }

        if (front==null)
            front=n1;
        else{
            front.next=n1;
            front=front.next;

        }

    }

    void pop(){

        if(rear!=null)
            System.out.println(rear.value);
        rear=rear.next;
        if(rear==null)
            front=null;

    }

}
