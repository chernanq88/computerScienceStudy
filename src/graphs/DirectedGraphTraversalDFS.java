package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphTraversalDFS {

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


        // F is unreacheable if starts from first component
        System.out.println("Traverse from A");
        dfsTraverse(a);

        System.out.println();

        // A component is unreacheable
        System.out.println("Traverse from F");
        dfsTraverse(f);

    }

    private static void dfsTraverse(Node a) {

        System.out.println(a.identifier);

        if (a.edges.isEmpty())
            return;

        for (Node node:a.edges){
            dfsTraverse(node);
        }

    }


}
