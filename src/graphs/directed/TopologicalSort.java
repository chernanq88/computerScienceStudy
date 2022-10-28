package graphs.directed;

import java.util.*;

/**
 * graph as in this video
 * https://www.youtube.com/watch?v=ddTC4Zovtbc
 * Could be more than one topological sort, at least this is one way
 *
 *  Time complexicy  O(v+e)
 *  Space complexity (N)
 *
 *
 */
public class TopologicalSort {

    /**
     * Node = Edge
     */
    static class Node {

        String identifier;
        List<Node> edges=new ArrayList<>();

        Node(String identifier){
            this.identifier=identifier;
        }

    }

    public static void main(String[] args) {

        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node a=new Node("A");
        Node e=new Node("E");
        Node f=new Node("F");
        Node g=new Node("G");
        Node h=new Node("H");

        a.edges.addAll(List.of(c));

        b.edges.addAll(List.of(c,d));

        c.edges.addAll(List.of(e));

        d.edges.addAll(List.of(f));

        f.edges.addAll(List.of(g));

        e.edges.addAll(List.of(h,f));

        List<Node> nodes=List.of(e,b,a);

        for(Node n: nodes) {
            topologicalSort(n);
        }

        System.out.println("Topological Sort:");
        while(!sort.isEmpty()){
            System.out.print(sort.pop());
        }
        System.out.println();

    }

    static Set<String> visited=new HashSet<>();
    static Stack<String> sort=new Stack<>();
    static void topologicalSort(Node n){

        if(visited.contains(n.identifier)){
            return;
        }

        System.out.println("Visiting node " + n.identifier);
        visited.add(n.identifier);

        for(Node children:n.edges) {
            topologicalSort(children);
        }

        sort.push(n.identifier);

    }


}
