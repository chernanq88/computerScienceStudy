package graphs.undirected;

import java.util.*;

public class UndirectedGraphTraversalDFS {

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
     *
     *  Undirected graph only requires simple DFS, Do need to cache extra values of visited nodes
     *
     *              A ---- C
     *
     *              |      |
     *              |      |
     *              |      |
     *
     *              B ---- E
     *              |
     *              |
     *              |
     *
     *              D ----- F
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
        c.edges.addAll(List.of(e,a));
        b.edges.addAll(List.of(d,a));
        f.edges.addAll(List.of(d));
        d.edges.addAll(List.of(f,b));



        System.out.println("Traverse from A");
        dfsTraverse(a);

    }

    static Set<String> visited=new HashSet<>();

    private static void dfsTraverse(Node a) {

        if (visited.contains(a.identifier)) {
            System.out.println("Already visited.." + a.identifier);
            return;
        }

        System.out.println(a.identifier);
        visited.add(a.identifier);

        for (Node node:a.edges){
            dfsTraverse(node);
        }

    }


}
