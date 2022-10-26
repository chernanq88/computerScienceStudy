package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphTraversalBFS {

    /**
     * Node = Edge
     */
    static class Node {

        String identifier;
        private List<Node> edges=new ArrayList<>();

        Node(String identifier){
            this.identifier=identifier;
        }

    }


    /**
     *
     *              A ----> C
     *              |       |
     *              |       |
     *              |       |
     *              v       v
     *              B <---- E
     *              |
     *              |
     *              |
     *              v
     *              D <----- F
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node a=new Node("A");
        Node e=new Node("E");
        Node f=new Node("F");
        a.edges.addAll(List.of(b,c));
        c.edges.addAll(List.of(e));
        b.edges.addAll(List.of(d));
        f.edges.addAll(List.of(d));

        System.out.println("BFS");
        bfsTraverse(a);

        System.out.println();

        bfsTraverse(f);
    }


    private static void bfsTraverse(Node node){

        Queue<Node> queue=new LinkedList<>();

        queue.add(node);

        while(queue.size()>0){
            int totalElements=queue.size();
            List<Node> nodes=new ArrayList<>();
            while (totalElements>0){
                Node n= queue.remove();
                System.out.println(n.identifier);
                queue.addAll(n.edges);
                totalElements--;
            }
        }
    }

}
