package graphs.undirected;

import java.util.*;

public class UndirectedGraphTraversalBFS {

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
        c.edges.addAll(List.of(a,e));
        b.edges.addAll(List.of(a,e,d));
        f.edges.addAll(List.of(d));
        d.edges.addAll(List.of(f,b));



        System.out.println("Traverse from A");
        bfsTraverse(a);

        System.out.println("Traverse from F");
        bfsTraverse(f);

    }

    private static void bfsTraverse(Node a){
        Set<String> visited=new HashSet<>();

        Queue<Node> queue= new LinkedList<>();
        queue.add(a);

        while(!queue.isEmpty()){
            Node n=queue.remove();
            if (!visited.contains(n.identifier)){
                System.out.println(n.identifier);
                visited.add(n.identifier);
                queue.addAll(n.edges);
            }

        }
    }


}
