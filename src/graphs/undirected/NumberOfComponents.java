package graphs.undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Tree: Connected graph with no cicles
 *       with only one component
 *
 *
 *
 *
 */
public class NumberOfComponents {

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
     *              Component 1        Component2     Component3      Component4
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
     *              D ----- F          G              H                I ----- J
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
        Node g=new Node("G");
        Node h=new Node("H");
        Node i=new Node("I");
        Node j=new Node("J");

        a.edges.addAll(List.of(b,c));
        c.edges.addAll(List.of(a,e));
        b.edges.addAll(List.of(a,e,d));
        f.edges.addAll(List.of(d));
        d.edges.addAll(List.of(f,b));

        j.edges.addAll(List.of(i));
        i.edges.addAll(List.of(j));

        List<Node> nodes=List.of(a,b,c,d,e,f,g,h, i,j);

        int components=0;
        for(Node n:nodes){
            if (!visited.contains(n.identifier)){
                components++;
                dfs(n);


            }
        }

        System.out.println("NUmber of components:"  + components );
    }


    static Set<String> visited=new HashSet<>();
    static boolean dfs(Node n){

        if (visited.contains(n.identifier))
            return false;

        System.out.println("Visiting node " + n.identifier);
        visited.add(n.identifier);

        if (!n.edges.isEmpty()) {
            for (Node node : n.edges) {
                dfs(node);
            }
        }

        return false;
    }
}
